package controller;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import model.Hmac;

public class HmacController {

    private final Hmac hmac;

    public HmacController() {
        this.hmac = new Hmac();
        generateSecretKey();
    }

    private void generateSecretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretKey = new byte[32];
        secureRandom.nextBytes(secretKey);
        hmac.setSecretKey(secretKey);
    }

    public String generateHmac(String message) throws Exception {
        Mac mac = Mac.getInstance(hmac.getHmacAlgorithm());
        SecretKeySpec secretKeySpec = new SecretKeySpec(hmac.getSecretKey(), hmac.getHmacAlgorithm());
        mac.init(secretKeySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(hmacBytes);
    }

    public String getSecretKeyBase64() {
        return Base64.getEncoder().encodeToString(hmac.getSecretKey());
    }


}
