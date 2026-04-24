package com.example.library;

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
        System.out.print("Nouvel ISBN: ");
        String isbn = sc.nextLine().trim();
        System.out.print("Titre: ");
        String titre = sc.nextLine().trim();
        System.out.print("Année (nombre): ");
        String anneeStr = sc.nextLine().trim();
        Integer annee = null;
        try {
            if (!anneeStr.isEmpty())
                annee = Integer.parseInt(anneeStr);
        } catch (NumberFormatException ignored) {
        }
        Livre l = new Livre();
        l.setIsbn(isbn);
        l.setTitre(titre);
        l.setAnnee(annee);
        Livre saved = livreService.save(l);
        System.out.println("Livre ajouté: " + saved.getIsbn());
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
