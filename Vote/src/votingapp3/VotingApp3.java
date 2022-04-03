package votingapp3;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import votingapp3.view.EntryView;

public class VotingApp3 {

    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(() -> {
        new EntryView().setVisible(true);
        });
        
        /*
        try {
            System.out.println(sha("rebecca"));
        } catch (NoSuchAlgorithmException ex) {}
        */
    }
    
    public static String sha(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32)
            hexString.insert(0, '0');
        return hexString.toString();
    }
    

    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ALPHA = "abcdefghijklmnopqrstuvwxyz";
        String NUMERIC = "0123456789";
        //String SPECIAL_CHARS = "!@#$%^&*_=+-/";
        String dictionary = ALPHA_CAPS + ALPHA + NUMERIC;
        String result = "";
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(dictionary.length());
            result += dictionary.charAt(index);
        }
        return result;
    }
    
}
