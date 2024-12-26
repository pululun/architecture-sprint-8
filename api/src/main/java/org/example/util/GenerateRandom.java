package org.example.util;

import java.security.SecureRandom;
import java.util.Random;

public class GenerateRandom {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final Random random = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    public static int generateRandomInt(int bound) {
        return random.nextInt(bound);
    }

}
