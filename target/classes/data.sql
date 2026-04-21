-- Sample data for development (H2)
INSERT INTO editeur (id, nom, adresse, courriel, num_tel) VALUES (1, 'Editions Demo', 'Rue A', 'contact@demo.com', '0123456789');
INSERT INTO categorie (id, nom, description) VALUES (1, 'Science', 'Livres scientifiques');
INSERT INTO livre (isbn, titre, annee, editeur_id, categorie_id) VALUES ('978-0000000001', 'Introduction to Demo', 2020, 1, 1);

INSERT INTO membre (id, nom, prenom, adresse, num_tel, statut_compte, password) VALUES (1, 'Dupont', 'Jean', 'Rue 1', '0102030405', 'ACTIF', 'password');

-- Exemplaire will need fk to livre; column names vary depending on schema generation
-- The data here may require adaptation depending on actual DDL names produced by JPA/Hibernate.
