# Library backend (Spring Boot)


Projet backend minimal pour la gestion de bibliothèque — entités JPA créées d'après le schéma fourni.

Prérequis:
- Java 17
- Maven

Configuration pour Oracle:
- Modifiez `src/main/resources/application.properties` et renseignez `spring.datasource.url`, `spring.datasource.username` et `spring.datasource.password` pour votre base Oracle.
- Assurez-vous d'avoir le driver Oracle JDBC (ojdbc). Si votre Maven n'a pas le driver, installez-le localement avec :

```bash
# exemple si vous avez le jar ojdbc8.jar
mvn install:install-file -Dfile=/path/to/ojdbc8.jar -DgroupId=com.oracle.database.jdbc -DartifactId=ojdbc8 -Dversion=19.8.0.0 -Dpackaging=jar
```

Lancer l'application en utilisant Oracle configuré :

```bash
mvn spring-boot:run
```

Remarques:
- Le projet contient encore la configuration H2 (commentée) si vous souhaitez un démarrage rapide en mémoire pour tests locaux.
- Hibernate est configuré pour `Oracle12cDialect`.

Accès H2-console (si vous activez H2 pour le développement): http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:librarydb`)
# TP_BD2