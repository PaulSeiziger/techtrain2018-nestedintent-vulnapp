package positive.on.techtrain2018_nestedintent_vulnapp;

import java.security.SecureRandom;

public class IntentTokenSingleton {
    private static IntentTokenSingleton instance;

    public static IntentTokenSingleton getInstance() {
        if (instance == null){
            instance = new IntentTokenSingleton();
        }

        return instance;
    }

    private String currentToken;

    private IntentTokenSingleton(){}

    public String getCurrentToken() {
        if (currentToken == null){
            currentToken = generateToken();
        }

        return currentToken;
    }

    private String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        return Long.toHexString(secureRandom.nextLong()) + Long.toHexString(System.nanoTime()) + Long.toHexString(secureRandom.nextLong());

    }
}
