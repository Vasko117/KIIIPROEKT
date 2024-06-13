package mk.ukim.finki.vb.service.emt;

import mk.ukim.finki.vb.model.emt.Country;

import java.util.List;

public interface CountryService {
    List<Country> listAll();
    Country findById(Long id);
    void deleteById(Long id);
    Country create(String name, String continent);
    Country update(Long id, String name, String continent);
}
