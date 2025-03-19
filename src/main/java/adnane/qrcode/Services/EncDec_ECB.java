package adnane.qrcode.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
public class EncDec_ECB {

    @Value("${app.secret.key}")
    private String secretKey;

    private static final String ALGORITHM = "AES";
    private static final String MODE = "ECB";
    private static final String PADDING = "PKCS5Padding";


    public String encrypt(String data) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM + "/" + MODE + "/" + PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encryptedData = cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public String decrypt(String encryptedData) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM + "/" + MODE + "/" + PADDING);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decodedData = Base64.getDecoder().decode(encryptedData);

        byte[] decryptedData = cipher.doFinal(decodedData);

        return new String(decryptedData);
    }

}
