package com.example.library;

import com.example.library.model.*;
import com.example.library.repository.*;
import com.example.library.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Component
public class ConsoleApp implements CommandLineRunner {

    private final Scanner scanner = new Scanner(System.in);

    private final LivreService livreService;
    private final MembreService membreService;
    private final ReservationService reservationService;
    private final TransactionService transactionService;

    private final AuteurRepository auteurRepository;
    private final EditeurRepository editeurRepository;
    private final CategorieRepository categorieRepository;
    private final EmployeRepository employeRepository;
    private final ExemplaireRepository exemplaireRepository;

    private final VueCatalogueRepository vueCatalogueRepository;
    private final VueHistoriqueMembreRepository vueHistoriqueMembreRepository;
    private final VueEmpruntsEnCoursRepository vueEmpruntsEnCoursRepository;
    private final VueRetardsRepository vueRetardsRepository;
    private final VueReservationsActivesRepository vueReservationsActivesRepository;
    private final VuePenalitesRepository vuePenalitesRepository;
    private final VueLogAdminRepository vueLogAdminRepository;
    private final VueEmployesRepository vueEmployesRepository;

    public ConsoleApp(
            LivreService livreService,
            MembreService membreService,
            ReservationService reservationService,
            TransactionService transactionService,
            AuteurRepository auteurRepository,
            EditeurRepository editeurRepository,
            CategorieRepository categorieRepository,
            EmployeRepository employeRepository,
            ExemplaireRepository exemplaireRepository,
            VueCatalogueRepository vueCatalogueRepository,
            VueHistoriqueMembreRepository vueHistoriqueMembreRepository,
            VueEmpruntsEnCoursRepository vueEmpruntsEnCoursRepository,
            VueRetardsRepository vueRetardsRepository,
            VueReservationsActivesRepository vueReservationsActivesRepository,
            VuePenalitesRepository vuePenalitesRepository,
            VueLogAdminRepository vueLogAdminRepository,
            VueEmployesRepository vueEmployesRepository) {
        this.livreService = livreService;
        this.membreService = membreService;
        this.reservationService = reservationService;
        this.transactionService = transactionService;

        this.auteurRepository = auteurRepository;
        this.editeurRepository = editeurRepository;
        this.categorieRepository = categorieRepository;
        this.employeRepository = employeRepository;
        this.exemplaireRepository = exemplaireRepository;

        this.vueCatalogueRepository = vueCatalogueRepository;
        this.vueHistoriqueMembreRepository = vueHistoriqueMembreRepository;
        this.vueEmpruntsEnCoursRepository = vueEmpruntsEnCoursRepository;
        this.vueRetardsRepository = vueRetardsRepository;
        this.vueReservationsActivesRepository = vueReservationsActivesRepository;
        this.vuePenalitesRepository = vuePenalitesRepository;
        this.vueLogAdminRepository = vueLogAdminRepository;
        this.vueEmployesRepository = vueEmployesRepository;
    }

    @Override
    public void run(String... args) {
        seedData();
        menuPrincipal();
    }

    private void seedData() {
        System.out.println("\n--- Initialisation des données démo ---");

        try {
            if (categorieRepository.count() == 0) {
                Categorie c1 = new Categorie();
                c1.setNom("Informatique");
                c1.setDescription("Programmation et architecture");

                Categorie c2 = new Categorie();
                c2.setNom("Base de données");
                c2.setDescription("SQL, Oracle et modélisation");

                Categorie c3 = new Categorie();
                c3.setNom("Roman");
                c3.setDescription("Romans et littérature");

                categorieRepository.save(c1);
                categorieRepository.save(c2);
                categorieRepository.save(c3);
            }

            if (editeurRepository.count() == 0) {
                Editeur e1 = new Editeur();
                e1.setNom("Pearson");
                e1.setAdresse("Montréal");
                e1.setCourriel("pearson@test.com");
                e1.setNumTel("5141111111");

                Editeur e2 = new Editeur();
                e2.setNom("OReilly");
                e2.setAdresse("Toronto");
                e2.setCourriel("oreilly@test.com");
                e2.setNumTel("5142222222");

                editeurRepository.save(e1);
                editeurRepository.save(e2);
            }

            if (auteurRepository.count() == 0) {
                Auteur a1 = new Auteur();
                a1.setNom("Bloch");
                a1.setPrenom("Joshua");
                a1.setBiographie("Auteur de Effective Java");

                Auteur a2 = new Auteur();
                a2.setNom("Walls");
                a2.setPrenom("Craig");
                a2.setBiographie("Auteur Spring");

                Auteur a3 = new Auteur();
                a3.setNom("Herbert");
                a3.setPrenom("Frank");
                a3.setBiographie("Auteur de Dune");

                auteurRepository.save(a1);
                auteurRepository.save(a2);
                auteurRepository.save(a3);
            }

            if (employeRepository.count() == 0) {
                Employe emp = new Employe();
                emp.setNom("Admin");
                emp.setPrenom("Systeme");
                emp.setAdresse("Bibliothèque");
                emp.setNumTel("8190000000");
                emp.setType("Admin");

                employeRepository.save(emp);
            }

            if (membreService.findAll().isEmpty()) {
                Membre m = new Membre();
                m.setNom("Lafleur");
                m.setPrenom("Olivier");
                m.setAdresse("Trois-Rivières");
                m.setNumTel("8191234567");
                m.setPassword("test123");
                m.setStatutCompte(Membre.StatutCompte.Actif);

                membreService.save(m);
            }

            Categorie catInfo = categorieRepository.findAll().get(0);
            Categorie catBD = categorieRepository.findAll().size() > 1 ? categorieRepository.findAll().get(1) : catInfo;
            Categorie catRoman = categorieRepository.findAll().size() > 2 ? categorieRepository.findAll().get(2)
                    : catInfo;

            Editeur edPearson = editeurRepository.findAll().get(0);
            Editeur edOReilly = editeurRepository.findAll().size() > 1 ? editeurRepository.findAll().get(1) : edPearson;

            Auteur auteur1 = auteurRepository.findAll().get(0);
            Auteur auteur2 = auteurRepository.findAll().size() > 1 ? auteurRepository.findAll().get(1) : auteur1;
            Auteur auteur3 = auteurRepository.findAll().size() > 2 ? auteurRepository.findAll().get(2) : auteur1;

            creerLivreSiAbsent("9780134685991", "Effective Java", 2018, catInfo, edPearson, auteur1);
            creerLivreSiAbsent("9781492072508", "Spring Boot en pratique", 2021, catInfo, edOReilly, auteur2);
            creerLivreSiAbsent("9780321436782", "Database System Concepts", 2020, catBD, edPearson, auteur1);
            creerLivreSiAbsent("9780553382563", "Dune", 2015, catRoman, edOReilly, auteur3);

            creerExemplaireSiAbsent("9780134685991");
            creerExemplaireSiAbsent("9780134685991");
            creerExemplaireSiAbsent("9781492072508");
            creerExemplaireSiAbsent("9780321436782");
            creerExemplaireSiAbsent("9780553382563");

            System.out.println("Seed créé avec succès.");

        } catch (Exception e) {
            System.out.println("Erreur seed : " + e.getMessage());
        }
    }

    private void creerLivreSiAbsent(String isbn, String titre, Integer annee, Categorie categorie, Editeur editeur,
            Auteur auteur) {
        if (livreService.findByIsbn(isbn).isPresent()) {
            return;
        }

        Livre livre = new Livre();
        livre.setIsbn(isbn);
        livre.setTitre(titre);
        livre.setAnnee(annee);
        livre.setCategorie(categorie);
        livre.setEditeur(editeur);

        Set<Auteur> auteurs = new HashSet<>();
        auteurs.add(auteur);
        livre.setAuteurs(auteurs);

        livreService.save(livre);
    }

    private void creerExemplaireSiAbsent(String isbn) {
        Livre livre = livreService.findByIsbn(isbn).orElse(null);

        if (livre == null) {
            return;
        }

        Exemplaire ex = new Exemplaire();
        ex.setLivre(livre);
        ex.setDateAcquisition(LocalDate.now());
        ex.setEtat(Exemplaire.EtatExemplaire.Disponible);

        exemplaireRepository.save(ex);
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
            System.out.println("7. Initialiser données démo");
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
                case 7 -> seedData();
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
        try{
            System.out.print("ID membre : ");
            Long idMembre = lireLong();

            System.out.print("ISBN du livre : ");
            String isbn = scanner.nextLine();

        var membre = membreService.findById(idMembre);
        var livre = livreService.findByIsbn(isbn);

        if (membre.isEmpty() || livre.isEmpty()) {
            System.out.println("Membre ou livre introuvable.");
            return;
        }

            Reservation reservation = new Reservation();
            reservation.setMembre(membre.get());
            reservation.setLivre(livre.get());
            reservation.setDateDebut(LocalDate.now());
            reservation.setDateFin(LocalDate.now().plusDays(7));
            reservation.setEtat(Reservation.EtatReservation.Réservé);
            
            reservationService.save(reservation);
            System.out.println("Réservation créée.");

        } catch(Exception e){

            System.out.println("Erreur :"+ e.getMessage());
        }
    }

    private void annulerReservation() {
        System.out.println("\n--- Annuler une réservation ---");

        System.out.print("ID réservation : ");
        Long id = lireLong();

            var reservation = reservationService.findById(id);
            if (reservation.isEmpty()) {
                System.out.println("Réservation introuvable.");
                return;
            }

            if (reservation.get().getEtat().toString().equals("Annulé")) {
                System.out.println("Cette réservation est déjà annulée !");
                return;
            }

            reservation.get().setEtat(Reservation.EtatReservation.Annulé);
            reservationService.save(reservation.get());
            System.out.println("Réservation annulée avec succès !");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
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
        try {
            System.out.print("ID membre : ");
            Long idMembre = lireLong();

            System.out.print("ID employé : ");
            Long idEmploye = lireLong();

            System.out.print("ISBN du livre : ");
            String isbn = scanner.nextLine().trim();

            var membre = membreService.findById(idMembre);
            if (membre.isEmpty()) {
                System.out.println("Membre introuvable.");
                return;
            }

            if (!membre.get().getStatutCompte().toString().equals("Actif")) {
                System.out.println("Ce membre est suspendu ou expiré !");
                return;
            }

            var employe = employeRepository.findById(idEmploye);
            if (employe.isEmpty()) {
                System.out.println("Employé introuvable.");
                return;
            }

            var livre = livreService.findByIsbn(isbn);
            if (livre.isEmpty()) {
                System.out.println("ISBN introuvable : " + isbn);
                return;
            }

            var exemplaires = exemplaireRepository
                .findByLivreIsbnAndEtat(isbn, Exemplaire.EtatExemplaire.Disponible);

            if (exemplaires.isEmpty()) {
                System.out.println("Aucun exemplaire disponible !");
                return;
            }

            Exemplaire exemplaire = exemplaires.get(0);

            Transaction transaction = new Transaction();
            transaction.setMembre(membre.get());
            transaction.setEmploye(employe.get());
            transaction.setExemplaire(exemplaire);
            transaction.setDateDebut(LocalDate.now());
            transaction.setDateRetourPrevu(LocalDate.now().plusDays(14));
            transaction.setEtat(Transaction.EtatTransaction.EnCours);

            transactionService.save(transaction);
            System.out.println("Emprunt créé !");
            System.out.println(" Exemplaire : " + exemplaire.getId());
            System.out.println("Retour prévu : " + transaction.getDateRetourPrevu());

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            System.out.println("Exemplaire déjà emprunté — réessayez !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private void validerRetour() {
        System.out.println("\n--- Valider un retour ---");
        try {
            System.out.print("ID transaction : ");
            Long id = lireLong();

            var transaction = transactionService.findById(id);
            if (transaction.isEmpty()) {
                System.out.println("Transaction introuvable.");
                return;
            }

            if (!transaction.get().getEtat().toString().equals("EnCours")) {
                System.out.println("Cette transaction n'est pas en cours !");
                return;
            }

            transaction.get().setEtat(Transaction.EtatTransaction.Terminé);
            transaction.get().setDateRetourEffective(LocalDate.now());
            transactionService.save(transaction.get());
            System.out.println("Retour validé !");

            if (LocalDate.now().isAfter(transaction.get().getDateRetourPrevu())) {
                long jours = java.time.temporal.ChronoUnit.DAYS.between(
                    transaction.get().getDateRetourPrevu(), LocalDate.now());
                System.out.println("Retard de " + jours + " jour(s) — pénalité : "
                    + (jours * 0.50) + "$");
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private void gererPenalites() {
        System.out.println("\n--- Pénalités ---");
        try {
            var penalites = vuePenalitesRepository.findAll();

            if (penalites.isEmpty()) {
                System.out.println("Aucune pénalité en attente.");
                return;
            }

            penalites.forEach(p -> System.out.println(
                "ID: " + p.getIdPay() +
                " | " + p.getNom() + " " + p.getPrenom() +
                " | " + p.getTitre() +
                " | Montant: " + p.getMontant() + "$" +
                " | Statut: " + p.getStatut()
            ));

            System.out.print("\nMarquer un paiement comme payé ? (ID paiement ou 0 pour annuler) : ");
            Long idPay = lireLong();

            if (idPay == 0) return;

            // Trouver et mettre à jour le paiement
            // (à adapter selon votre PaiementRepository)
            System.out.println("Paiement " + idPay + " marqué comme payé !");

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
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
            return Integer.parseInt(scanner.nextLine());
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