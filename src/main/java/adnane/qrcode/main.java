package adnane.qrcode;

import adnane.qrcode.Services.GenerateData;
import adnane.qrcode.Services.QRCodeService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;


public class main {
    public static void main(String[] args) throws Exception {
        GenerateData generateData = new GenerateData();

        String ref_Fatourati = "1141010001850"; // Exemple de référence
        String qrCodeData = generateData.setupQrCodeFormatJSON(ref_Fatourati, null);

        // Affichage du résultat
        System.out.println("Données du QR Code générées :");
        System.out.println(qrCodeData);

        System.out.println("=========================================");

        System.out.println("QR Code générées en base 64:");
        System.out.println(QRCodeService.generateQRCodeAsBase64Image(qrCodeData,250,250));
    }
}
