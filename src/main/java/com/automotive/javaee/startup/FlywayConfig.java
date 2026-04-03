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
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jdbc:mysql://mysql:3306/automotiveJavaEE?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                        "automotive",
                        "Jabulani2002@"
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}