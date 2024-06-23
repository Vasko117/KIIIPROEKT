package mk.ukim.finki.vb.web.sevrlet.controller.rest;

import mk.ukim.finki.vb.model.emt.Dto.HostDTO;
import mk.ukim.finki.vb.model.emt.Host;
import mk.ukim.finki.vb.service.emt.CountryService;
import mk.ukim.finki.vb.service.emt.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:30080","http://localhost","http://localhost:3000","http://front.accomidations.com:30080"})@RequestMapping("/api")
public class HostController {
    private final HostService service;
    private final CountryService countryService;

    public HostController(HostService service, CountryService countryService) {
        this.service = service;
        this.countryService = countryService;
    }
    @PostMapping("/add-host")
    public ResponseEntity<Void> addHost(@RequestBody HostDTO authorDTO) {
        if(authorDTO == null) {
            return ResponseEntity.notFound().build();
        }

        if(countryService.findById(authorDTO.getCountryId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.create(authorDTO.getName(), authorDTO.getSurname(), authorDTO.getCountryId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hosts")
    public List<Host> getHosts() {
        return this.service.listAll();
    }

    @PostMapping("/delete-host/{id}")
    public ResponseEntity<Void> getHosts(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
