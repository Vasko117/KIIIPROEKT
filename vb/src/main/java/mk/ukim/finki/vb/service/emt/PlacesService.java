package mk.ukim.finki.vb.service.emt;

import mk.ukim.finki.vb.model.emt.Category;
import mk.ukim.finki.vb.model.emt.Host;
import mk.ukim.finki.vb.model.emt.Smestuvanje;

import java.util.List;
import java.util.Optional;

public interface PlacesService {
    List<Smestuvanje> findAll();

    Smestuvanje findById(Long id);

    Smestuvanje save(Category category, Long hostId, int numRooms);

    Smestuvanje edit(Long id, Category category, int numRooms, Long hostId);

    void deleteById(Long id);
    void mark(Long id);
}
