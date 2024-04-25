package com.example.online_school.utils;

import org.mindrot.jbcrypt.BCrypt;

public class HashingPassword {

    public static String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}

