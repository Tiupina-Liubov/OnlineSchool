//package com.example.online_school.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//
//
//@Configuration
//public class DatabaseConfig {
//    @Bean
//    public boolean registerCustomFunctions(DataSource dataSource) throws SQLException {
//        try (Connection conn = dataSource.getConnection()) {
//            conn.createStatement().execute("CREATE ALIAS IF NOT EXISTS UUID_TO_BIN FOR \"com.example.online_school.util.InnitH2.uuidToBin\"");//todo спросить упреподователя по етому поводу
//        } catch (SQLException e) {
//            return false;
//        }
//        return true; // Возвращаем true, чтобы показать, что бин успешно создан
//    }
//
//}
