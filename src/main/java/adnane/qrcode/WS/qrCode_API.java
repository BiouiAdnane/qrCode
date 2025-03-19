package adnane.qrcode.WS;

import adnane.qrcode.Services.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class qrCode_API {
    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/api/qrCode")
    public ResponseEntity<byte[]> qrCode(@RequestBody String qrCode) {
        try{
            byte[] qrCodeImage = qrCodeService.generateQRCode(qrCode, 300, 300);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return ResponseEntity.ok().headers(headers).body(qrCodeImage);

        } catch (Exception e) {
            throw new RuntimeException("Error while generating QR Code");
        }

    }
}
