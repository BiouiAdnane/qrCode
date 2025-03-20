package adnane.qrcode.WS;

import adnane.qrcode.Services.QRCodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
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

    @PostMapping("api/qrCodeImage/Base64")
    public String qrCodeImage(@RequestBody String qrCode) throws IOException, WriterException {
        return QRCodeService.generateQRCodeAsBase64Image(qrCode,250,250);
    }
}
