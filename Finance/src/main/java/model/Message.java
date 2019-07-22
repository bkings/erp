package model;

import java.security.Key;
import java.util.Map;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Message {

    public Map map;
    public List list;

    public String encryptText(String text) {
//     String text = "Manoj";
        try {

            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            text = new String(encrypted);

//            cipher.init(Cipher.DECRYPT_MODE, aesKey);
//            String decrypted = new String(cipher.doFinal("ÁôŠR•d?¾RG²?È,"));
//            System.err.println(decrypted);
            /*

ÁôŠR•d?¾RG²?È,
ÁôŠR•d?¾RG²?È,
             */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return text;
    }

    public static String exceptionMsg(Exception e) {
        try {
            return e.getCause().getMessage();
        } catch (Exception ex) {
        }
        return e.getMessage();
    }

    public String respondWithError(String message) {
        return "{\"error\":{\"message\":\"" + message + "\"}}";
    }

    public String respondWithMessage(String message) {
        return "{\"message\":\"" + message + "\"}";
    }
   
}
