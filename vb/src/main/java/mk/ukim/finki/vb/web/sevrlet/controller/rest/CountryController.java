package mk.ukim.finki.vb.web.sevrlet.controller.rest;

import mk.ukim.finki.vb.model.emt.Country;
import mk.ukim.finki.vb.model.emt.Dto.CountryDTO;
import mk.ukim.finki.vb.service.emt.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost","http://localhost:30080","http://localhost:3000"})
@RequestMapping("/api")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping("/add-country")
    public ResponseEntity<Void> addCountry(@RequestBody CountryDTO countryDTO) {
        if(countryDTO == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.create(countryDTO.getName(), countryDTO.getContinent());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return this.service.listAll();
    }
}
