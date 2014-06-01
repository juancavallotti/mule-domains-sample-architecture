package org.mule.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by juancavallotti on 31/05/14.
 */
public class InitDatabase {

    private DataSource dataSource;

    private static final Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    public void createTables() throws Exception {

        try (Connection conn = dataSource.getConnection()) {

            try (Statement smt = conn.createStatement()) {
                logger.info("Creating jobs table...");
                smt.execute("CREATE TABLE jobs(jobId VARCHAR(36) UNIQUE, status VARCHAR(16), updated TIMESTAMP)");

                logger.info("Creating ingredients table...");
                smt.execute("CREATE TABLE recipeIngredients(itemId VARCHAR(36), name VARCHAR(100), recipeId VARCHAR(36))");

                logger.info("Creating recipes table...");
                smt.execute("CREATE TABLE recipes(recipeId VARCHAR(36) UNIQUE, name VARCHAR(100))");
            }
        }

    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
