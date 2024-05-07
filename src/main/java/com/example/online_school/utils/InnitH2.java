package com.example.online_school.utils;

import java.util.UUID;

public class InnitH2 {
    public static byte[] uuidToBin(UUID uuid) {
        return uuid.toString().getBytes();
    }
}
