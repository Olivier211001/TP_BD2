package com.example.library;

import com.example.library.repository.*;
import com.example.library.model.*;
import com.example.library.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ConsoleApp implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);

    private final LivreService livreService;
    private final MembreService membreService;
    private final ReservationService reservationService;
    private final TransactionEmpruntService transactionService;

    private final VueCatalogueRepository vueCatalogueRepository;
    private final VueHistoriqueMembreRepository vueHistoriqueMembreRepository;
    private final VueEmpruntsEnCoursRepository vueEmpruntsEnCoursRepository;
    private final VueRetardsRepository vueRetardsRepository;
    private final EditeurRepository editeurRepository;
    private final CategorieRepository categorieRepository;
    private final VueReservationsActivesRepository vueReservationsActivesRepository;
    private final VuePenalitesRepository vuePenalitesRepository;
    private final VueLogAdminRepository vueLogAdminRepository;
    private final VueEmployesRepository vueEmployesRepository;

    public ConsoleApp(
            LivreService livreService,
            MembreService membreService,
            ReservationService reservationService,
            TransactionEmpruntService transactionService,
            VueCatalogueRepository vueCatalogueRepository,
            VueHistoriqueMembreRepository vueHistoriqueMembreRepository,
            VueEmpruntsEnCoursRepository vueEmpruntsEnCoursRepository,
            VueRetardsRepository vueRetardsRepository,
            VueReservationsActivesRepository vueReservationsActivesRepository,
            VuePenalitesRepository vuePenalitesRepository,
            VueLogAdminRepository vueLogAdminRepository,
            VueEmployesRepository vueEmployesRepository,
            EditeurRepository editeurRepository,
            CategorieRepository categorieRepository) {
        this.livreService = livreService;
        this.membreService = membreService;
        this.reservationService = reservationService;
        this.transactionService = transactionService;
        this.vueCatalogueRepository = vueCatalogueRepository;
        this.vueHistoriqueMembreRepository = vueHistoriqueMembreRepository;
        this.vueEmpruntsEnCoursRepository = vueEmpruntsEnCoursRepository;
        this.vueRetardsRepository = vueRetardsRepository;
        this.vueReservationsActivesRepository = vueReservationsActivesRepository;
        this.vuePenalitesRepository = vuePenalitesRepository;
        this.vueLogAdminRepository = vueLogAdminRepository;
        this.vueEmployesRepository = vueEmployesRepository;
        this.editeurRepository = editeurRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public void run(String... args) {
        seedData(); // initilisation de données de test au besoin
        menuPrincipal();
    }

    private void seedData() {

        if (editeurRepository.count() == 0) {

            Editeur e1 = new Editeur();
            e1.setId(1L);
            e1.setNom("Pearson");
            e1.setAdresse("Montreal");
            e1.setCourriel("pearson@test.com");
            e1.setNumTel("5141111111");

            editeurRepository.save(e1);
        }

        if (categorieRepository.count() == 0) {

            Categorie c1 = new Categorie();
            c1.setId(1L);
            c1.setNom("Informatique");
            c1.setDescription("Programmation");

            categorieRepository.save(c1);
        }

        System.out.println("Seed initial créé.");
    }

    private void menuPrincipal() {
        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Membre");
            System.out.println("2. Employé");
            System.out.println("3. Administrateur");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            int choix = lireInt();

            switch (choix) {
                case 1 -> menuMembre();
                case 2 -> menuEmploye();
                case 3 -> menuAdmin();
                case 0 -> {
                    System.out.println("Fin de l'application.");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private void menuMembre() {
        while (true) {
            System.out.println("\n===== MENU MEMBRE =====");
            System.out.println("1. Consulter catalogue");
            System.out.println("2. Faire une réservation");
            System.out.println("3. Annuler une réservation");
            System.out.println("4. Consulter mon historique");
            System.out.println("0. Retour");
            System.out.print("Choix : ");

            int choix = lireInt();

            switch (choix) {
                case 1 -> consulterCatalogue();
                case 2 -> faireReservation();
                case 3 -> annulerReservation();
                case 4 -> consulterHistoriqueMembre();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private void menuEmploye() {
        while (true) {
            System.out.println("\n===== MENU EMPLOYÉ =====");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Ajouter un membre");
            System.out.println("3. Faire un emprunt");
            System.out.println("4. Valider un retour");
            System.out.println("5. Gérer les pénalités");
            System.out.println("6. Consulter historique réservations");
            System.out.println("0. Retour");
            System.out.print("Choix : ");

            int choix = lireInt();

            switch (choix) {
                case 1 -> ajouterLivre();
                case 2 -> ajouterMembre();
                case 3 -> faireEmprunt();
                case 4 -> validerRetour();
                case 5 -> gererPenalites();
                case 6 -> consulterHistoriqueReservations();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private void menuAdmin() {
        while (true) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Gérer les employés");
            System.out.println("2. Consulter le log");
            System.out.println("0. Retour");
            System.out.print("Choix : ");

            int choix = lireInt();

            switch (choix) {
                case 1 -> gererEmployes();
                case 2 -> consulterLog();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private void consulterCatalogue() {
        System.out.println("\n--- Catalogue ---");
        vueCatalogueRepository.findAll().forEach(System.out::println);
    }

    private void faireReservation() {
        System.out.println("\n--- Faire une réservation ---");

        System.out.print("ID membre : ");
        Long idMembre = lireLong();

        System.out.print("ISBN du livre : ");
        String isbn = scanner.nextLine();

        System.out.println("À compléter selon ton modèle Reservation.");
        System.out.println(
                "Logique attendue : récupérer Membre + Livre, créer Reservation, puis reservationService.save(reservation).");
    }

    private void annulerReservation() {
        System.out.println("\n--- Annuler une réservation ---");

        System.out.print("ID réservation : ");
        Long id = lireLong();

        if (reservationService.findById(id).isPresent()) {
            reservationService.deleteById(id);
            System.out.println("Réservation annulée.");
        } else {
            System.out.println("Réservation introuvable.");
        }
    }

    private void consulterHistoriqueMembre() {
        System.out.println("\n--- Historique membre ---");

        System.out.print("Nom du membre : ");
        String nom = scanner.nextLine();

        vueHistoriqueMembreRepository
                .findByNomContainingIgnoreCase(nom)
                .forEach(System.out::println);
    }

    private void ajouterLivre() {
        System.out.println("\n--- Ajouter un livre ---");

        Livre livre = new Livre();

        System.out.print("ISBN : ");
        livre.setIsbn(scanner.nextLine());

        System.out.print("Titre : ");
        livre.setTitre(scanner.nextLine());

        System.out.print("Année : ");
        livre.setAnnee(lireInt());

        System.out.print("ID éditeur : ");
        Long idEdit = lireLong();

        System.out.print("ID catégorie : ");
        Long idCat = lireLong();

        var editeur = editeurRepository.findById(idEdit);
        var categorie = categorieRepository.findById(idCat);

        if (editeur.isEmpty() || categorie.isEmpty()) {
            System.out.println("Éditeur ou catégorie introuvable.");
            return;
        }

        livre.setEditeur(editeur.get());
        livre.setCategorie(categorie.get());

        livreService.save(livre);

        System.out.println("Livre ajouté dans Oracle.");
    }

    private void ajouterMembre() {
        System.out.println("\n--- Ajouter un membre ---");

        Membre membre = new Membre();

        System.out.print("Nom : ");
        membre.setNom(scanner.nextLine());

        System.out.print("Prénom : ");
        membre.setPrenom(scanner.nextLine());

        System.out.print("Password : ");
        membre.setPassword(scanner.nextLine());

        membre.setStatutCompte(Membre.StatutCompte.Actif);

        membreService.save(membre);
        System.out.println("Membre ajouté.");
    }

    private void faireEmprunt() {
        System.out.println("\n--- Faire un emprunt ---");

        System.out.print("ID membre : ");
        Long idMembre = lireLong();

        System.out.print("ID employé : ");
        Long idEmploye = lireLong();

        System.out.print("ID exemplaire : ");
        Long idExemplaire = lireLong();

        System.out.println("À compléter selon tes repositories/services Employe et Exemplaire.");
        System.out.println("Logique attendue : créer TransactionEmprunt avec membre + employe + exemplaire.");
        System.out.println("Ensuite transactionService.save(transaction).");
    }

    private void validerRetour() {
        System.out.println("\n--- Valider un retour ---");

        System.out.print("ID transaction : ");
        Long id = lireLong();

        transactionService.findById(id).ifPresentOrElse(transaction -> {
            transaction.setEtat(TransactionEmprunt.EtatTransaction.TERMINE);
            transaction.setDateRetourEffective(LocalDate.now());
            transactionService.save(transaction);
            System.out.println("Retour validé.");
        }, () -> System.out.println("Transaction introuvable."));
    }

    private void gererPenalites() {
        System.out.println("\n--- Pénalités ---");
        vuePenalitesRepository.findAll().forEach(System.out::println);
    }

    private void consulterHistoriqueReservations() {
        System.out.println("\n--- Réservations actives ---");
        vueReservationsActivesRepository.findAll().forEach(System.out::println);
    }

    private void gererEmployes() {
        System.out.println("\n--- Employés ---");
        vueEmployesRepository.findAll().forEach(System.out::println);
    }

    private void consulterLog() {
        System.out.println("\n--- Log admin ---");
        vueLogAdminRepository.findAll().forEach(System.out::println);
    }

    private int lireInt() {
        try {
            int value = Integer.parseInt(scanner.nextLine());
            return value;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Long lireLong() {
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nombre invalide, réessaie : ");
            }
        }
    }
}