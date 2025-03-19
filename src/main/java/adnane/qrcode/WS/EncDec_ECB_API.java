package adnane.qrcode.WS;

import adnane.qrcode.Services.EncDec_ECB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncDec_ECB_API {

    @Autowired
    private EncDec_ECB encDec_ECB;

    @PostMapping("/api/encrypt")
    public String encrypt(@RequestBody String data) throws Exception {
        return encDec_ECB.encrypt(data);
    }

    @PostMapping("/api/decrypt")
    public String decrypt(@RequestBody String encryptedData) throws Exception {
        return encDec_ECB.decrypt(encryptedData);
    }
}
