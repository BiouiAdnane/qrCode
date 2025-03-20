package adnane.qrcode.WS;

import adnane.qrcode.Services.GenerateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class JsonFormat {
    @Autowired
    private GenerateData generateData;

    @GetMapping("/api/jsonFormat/{ref}/{montant}")
    public String jsonFormat(@PathVariable("ref") String ref,@PathVariable String montant) {
        return generateData.setupQrCodeFormatJSON(ref, BigDecimal.valueOf(Long.parseLong(montant)));
    }

    @PostMapping("/api/jsonFormat")
    public String jsonFormat(@RequestBody Map<String, String> requestData) {
        String ref = requestData.get("ref");
        String montant = requestData.get("montant");
        return generateData.setupQrCodeFormatJSON(ref, BigDecimal.valueOf(Long.parseLong(montant)));
    }

}
