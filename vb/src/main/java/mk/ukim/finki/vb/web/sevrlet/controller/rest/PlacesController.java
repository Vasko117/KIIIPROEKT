package mk.ukim.finki.vb.web.sevrlet.controller.rest;

import mk.ukim.finki.vb.model.emt.Category;
import mk.ukim.finki.vb.model.emt.Dto.SmestuvanjeDTO;
import mk.ukim.finki.vb.model.emt.Smestuvanje;
import mk.ukim.finki.vb.service.emt.HostService;
import mk.ukim.finki.vb.service.emt.PlacesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost","http://localhost:30080","http://localhost:3000"})
@RequestMapping("/api/places")
public class PlacesController {
    private final PlacesService service;
    private final HostService hostService;

    public PlacesController(PlacesService service, HostService hostService) {
        this.service = service;
        this.hostService = hostService;
    }
    @PostMapping("/add-place")
    public ResponseEntity<Void> addPlace(@RequestBody SmestuvanjeDTO smestuvanjeDTO) {
        if(smestuvanjeDTO == null) {
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(smestuvanjeDTO.getHostId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.save(smestuvanjeDTO.getCategory(), smestuvanjeDTO.getHostId(), smestuvanjeDTO.getNumRooms());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete-place/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        if(service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/edit-place/{id}")
    public ResponseEntity<Void> editPlace(@PathVariable Long id, @RequestBody SmestuvanjeDTO smestuvanjeDTO) {
        if(smestuvanjeDTO == null) {
            return ResponseEntity.notFound().build();
        }

        if(hostService.findById(smestuvanjeDTO.getHostId()) == null || service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.edit(id, smestuvanjeDTO.getCategory(), smestuvanjeDTO.getNumRooms(), smestuvanjeDTO.getHostId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mark-place/{id}")
    public ResponseEntity<Void> markPlace(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }

        if(service.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        this.service.mark(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public Smestuvanje getbyId(@PathVariable Long id) {
        return this.service.findById(id);
    }
    @GetMapping("/categories")
    public List<Category> getcategories() {
        return Arrays.stream(Category.values()).toList();
    }

    @GetMapping("")
    public List<Smestuvanje> getPlaces() {
        return this.service.findAll();
    }
}
