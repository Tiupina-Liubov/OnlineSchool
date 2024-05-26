CREATE TABLE logs (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      timestamp TIMESTAMP NOT NULL,
                      level VARCHAR(50) NOT NULL,
                      logger VARCHAR(255) NOT NULL,
                      message TEXT NOT NULL,
                      thread VARCHAR(255) NOT NULL,
                      exception TEXT
);

UPDATE DATABASECHANGELOG
SET MD5SUM = NULL
WHERE FILENAME = 'db/changelog/v1.0.0-SNAPSHOT/init-db.sql'
   OR FILENAME = 'db/changelog/v1.0.0-SNAPSHOT/data.sql';