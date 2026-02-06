package sqch103.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sqch103.DTO.Country;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/all")
    public ResponseEntity<List<Country>> all(){
        Country c1 = Country.of("France",68);
        Country c2 = Country.of("Germany",88);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent","Europe")
                .header("capital","Paris")
                .header("favourite_food","cheese and  wine")
                .body(List.of(c1,c2));
    }
    // jo type body ka hoga wohi type ResponseEntity<  yaha hoga>;
}
