package com.opencart.managers;

public class DataSubstituteManager {
    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOM":
                return RandomDataGeneratorManager.generateLastName();
            case "RANDOMMAIL":
                return RandomDataGeneratorManager.generateRandomEmail();
            case "RANDOMFIRSTNAME":
                return RandomDataGeneratorManager.generateFirstName();

        }
        return value;

    }
}
