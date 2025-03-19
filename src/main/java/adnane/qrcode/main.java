package adnane.qrcode;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        System.out.println("=========================================");

        // Test de la fonction generateQrCodeData
        String ref_Fatourati = "1141010001850"; // Exemple de référence
        Map<String, Object> qrCodeData = generateQrCodeData(ref_Fatourati);
        

        // Affichage du résultat
        System.out.println("Données du QR Code générées :");
        System.out.println(qrCodeData);
    }

    public static Map<String, Object> generateQrCodeData(final String ref_Fatourati) {
        String fournisseur = ref_Fatourati.substring(0, 4);
        String creance = ref_Fatourati.substring(4, 6);

        // Créer une liste mutable de Maps
        final List<Map<String, String>> ifArray = new ArrayList<>();
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("n", "token");
        tokenMap.put("v", ref_Fatourati);
        ifArray.add(tokenMap);

        // Optionnellement ajouter d'autres valeurs à ifArray
        // Map<String, String> amountMap = new HashMap<>();
        // amountMap.put("n", "amount");
        // amountMap.put("v", totalAmount.toString());
        // ifArray.add(amountMap);

        // Créer une Map mutable et y ajouter les éléments
        Map<String, Object> result = new HashMap<>();
        result.put("f", fournisseur);  // code créancier
        result.put("c", creance);      // code créance
        result.put("if", ifArray);     // valeurs du formulaire d'entrée (contient amount et token ref)

        return result;
    }
}
