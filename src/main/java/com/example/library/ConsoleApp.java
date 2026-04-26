package com.example.library;

import com.example.library.model.Categorie;
import com.example.library.model.Editeur;
import com.example.library.model.Livre;
import com.example.library.model.Membre;
import com.example.library.service.LivreService;
import com.example.library.service.MembreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

/**
 * Console runner for interactive library commands.
 * Enabled only when property `app.console.enabled=true`.
 */
@Component
@ConditionalOnProperty(name = "app.console.enabled", havingValue = "true", matchIfMissing = false)
public class ConsoleApp implements CommandLineRunner {

    private final LivreService livreService;
    private final MembreService membreService;

    public ConsoleApp(LivreService livreService, MembreService membreService) {
        this.livreService = livreService;
        this.membreService = membreService;
    }

    @Override
    public void run(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            printHeader();
            boolean running = true;
            while (running) {
                printMenu();
                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1" -> listLivres();
                    case "2" -> findLivre(sc);
                    case "3" -> createLivre(sc);
                    case "4" -> listMembres();
                    case "0" -> {
                        running = false;
                        System.out.println("Au revoir.");
                    }
                    default -> System.out.println("Choix invalide.");
                }
            }
        } catch (Exception e) {
            System.err.println("Erreur console: " + e.getMessage());
        }
    }

    private void printHeader() {
        System.out.println("--- Bibliothèque (console) ---");
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1) Lister les livres");
        System.out.println("2) Rechercher un livre par ISBN");
        System.out.println("3) Ajouter un livre");
        System.out.println("4) Lister les membres");
        System.out.println("0) Quitter");
        System.out.print("Choix : ");
    }

    private void listLivres() {
        List<Livre> livres = livreService.findAll();
        if (livres.isEmpty()) {
            System.out.println("Aucun livre.");
            return;
        }
        for (Livre l : livres) {
            System.out.printf("ISBN: %s | %s (%s)%n", l.getIsbn(), l.getTitre(), l.getAnnee());
        }
    }

    private void findLivre(Scanner sc) {
        System.out.print("ISBN: ");
        String isbn = sc.nextLine().trim();
        livreService.findByIsbn(isbn).ifPresentOrElse(
                l -> System.out.printf("Trouvé: %s - %s (%s)%n", l.getIsbn(), l.getTitre(), l.getAnnee()),
                () -> System.out.println("Livre non trouvé."));
    }

    private void createLivre(Scanner sc) {
        System.out.println("\n--- Ajouter un nouveau livre ---");

        System.out.print("ISBN : ");
        String isbn = sc.nextLine().trim();

        // Vérifier que l'ISBN n'existe pas déjà
        if (livreService.findByIsbn(isbn).isPresent()) {
            System.out.println("❌ Un livre avec cet ISBN existe déjà.");
            return;
        }

        System.out.print("Titre : ");
        String titre = sc.nextLine().trim();

        System.out.print("Année : ");
        Integer annee = null;
        try {
            annee = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Année invalide.");
            return;
        }

        // ID éditeur — obligatoire car ID_EDIT est NOT NULL dans Oracle
        System.out.print("ID éditeur : ");
        Long idEditeur = null;
        try {
            idEditeur = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ ID éditeur invalide.");
            return;
        }

        // ID catégorie — obligatoire car ID_CAT est NOT NULL dans Oracle
        System.out.print("ID catégorie : ");
        Long idCategorie = null;
        try {
            idCategorie = Long.parseLong(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ ID catégorie invalide.");
            return;
        }

        // On crée les objets avec seulement l'ID
        // JPA utilise la référence (FK) sans charger l'entité complète
        Editeur editeur = new Editeur();
        editeur.setId(idEditeur);

        Categorie categorie = new Categorie();
        categorie.setId(idCategorie);

        Livre l = new Livre();
        l.setIsbn(isbn);
        l.setTitre(titre);
        l.setAnnee(annee);
        l.setEditeur(editeur);
        l.setCategorie(categorie);

        try {
            Livre saved = livreService.save(l);
            System.out.printf("✅ Livre ajouté : ISBN=%s | %s (%d)%n",
                    saved.getIsbn(), saved.getTitre(), saved.getAnnee());
        } catch (Exception e) {
            System.out.println("❌ Erreur lors de l'ajout : " + e.getMessage());
        }
    }

    private void listMembres() {
        List<Membre> membres = membreService.findAll();
        if (membres.isEmpty()) {
            System.out.println("Aucun membre.");
            return;
        }
        for (Membre m : membres) {
            System.out.printf("ID: %d | %s %s%n", m.getId(), m.getNom(), m.getPrenom() == null ? "" : m.getPrenom());
        }
    }
}
