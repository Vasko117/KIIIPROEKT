package mk.ukim.finki.vb.service.emt.impl;

import mk.ukim.finki.vb.model.emt.Country;
import mk.ukim.finki.vb.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.vb.repository.emt.CountryRepo;
import mk.ukim.finki.vb.service.emt.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepo countryRepository;

    public CountryServiceImpl(CountryRepo countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return this.countryRepository.findById(id).orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        Country country = this.findById(id);
        this.countryRepository.delete(country);
    }

    @Override
    public Country create(String name, String continent) {
        return this.countryRepository.save(new Country(name, continent));
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country country = this.findById(id);
        country.setName(name);
        country.setContinent(continent);
        return this.countryRepository.save(country);
    }
}
