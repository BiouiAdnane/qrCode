package adnane.qrcode.Services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static adnane.qrcode.ConstantBase.*;

@Service
public class GenerateData {

    public String setupQrCodeFormatJSON(String refFatourati, BigDecimal montant ) {
        StringBuilder builder = new StringBuilder(1000);

        if (refFatourati == null || refFatourati.length() != 13 || !refFatourati.matches("\\d+")) {
            throw new IllegalArgumentException("La référence Fatourati doit contenir exactement 13 chiffres.");
        }

        String f = refFatourati.substring(0, 4);
        String c = refFatourati.substring(4, 6);

        builder.append(C_OBJ_DEB);
        builder.append("\"f\"").append(DP).append("\"").append(f).append("\"").append(VRG);
        builder.append("\"c\"").append(DP).append("\"").append(c).append("\"").append(VRG);

        builder.append("\"if\"").append(DP).append(C_DEB);

        builder.append(C_OBJ_DEB);
        builder.append("\"n\"").append(DP).append("\"Ref_fatourati\"").append(VRG);
        builder.append("\"v\"").append(DP).append("\"").append(refFatourati).append("\"");
        if(montant != null) {
            builder.append(VRG).append("\"n\"").append(DP).append("\"montant\"").append(VRG);
            builder.append("\"v\"").append(DP).append("\"").append(montant).append("\"");
        }
        builder.append(C_OBJ_FIN);

        builder.append(C_FIN);
        builder.append(C_OBJ_FIN);

        return builder.toString();
    }


}
