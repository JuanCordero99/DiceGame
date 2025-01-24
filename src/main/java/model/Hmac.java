package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hmac {

    private static final String HMAC_ALGORITHM = "HmacSHA256"; // Algoritmo HMAC
    private byte[] secretKey; // Clave secreta

    public String getHmacAlgorithm() {
        return HMAC_ALGORITHM;
    }

}
