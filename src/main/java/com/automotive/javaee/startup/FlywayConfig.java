package com.automotive.javaee.startup;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import org.flywaydb.core.Flyway;

@Singleton
@Startup
public class FlywayConfig {

    @PostConstruct
    public void migrate() {
        String dbUrl = System.getenv().getOrDefault(
                "DB_URL",
                "jdbc:mysql://mysql:3306/automotiveJavaEE?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
        );

        String dbUser = System.getenv().getOrDefault("DB_USER", "automotive");
        String dbPassword = System.getenv().getOrDefault("DB_PASSWORD", "Jabulani2002@");

        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, dbUser, dbPassword)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}