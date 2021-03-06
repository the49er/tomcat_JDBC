package com.servlet.test.feature.storage;

import com.servlet.test.feature.prefs.Config;
import org.flywaydb.core.Flyway;

public class DataBaseInitService {

    public void initDbFlyWay(Storage storage) {
        Config config = new Config();
        String connectionUrl = config.getString(Config.DB_JDBC_CONNECTION_URL);
        String connectionUser = config.getString(Config.DB_JDBC_USER_1);
        String connectionUserPassword = config.getString(Config.DB_JDBC_USER_PASSWORD_1);

        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, connectionUser, connectionUserPassword)
                .load();

        flyway.migrate();
    }
}
