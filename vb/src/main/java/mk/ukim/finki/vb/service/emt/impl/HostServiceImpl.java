package mk.ukim.finki.vb.service.emt.impl;

import mk.ukim.finki.vb.model.emt.Country;
import mk.ukim.finki.vb.model.emt.Host;
import mk.ukim.finki.vb.model.exceptions.HostNotFoundException;
import mk.ukim.finki.vb.repository.emt.CountryRepo;
import mk.ukim.finki.vb.repository.emt.HostRepo;
import mk.ukim.finki.vb.service.emt.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl  implements HostService {
    private final HostRepo hostRepo;
    private final CountryRepo countryRepo;

    public HostServiceImpl(HostRepo hostRepo, CountryRepo countryRepo) {
        this.hostRepo = hostRepo;
        this.countryRepo = countryRepo;
    }

    @Override
    public List<Host> listAll() {
        return this.hostRepo.findAll();
    }

    @Override
    public Host findById(Long id) {
        return this.hostRepo.findById(id).orElseThrow(HostNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        Host host = this.findById(id);
        this.hostRepo.delete(host);

    }

    @Override
    public Host create(String name, String surname, Long countryId) {
        Country country = this.countryRepo.findById(countryId).get();
        return this.hostRepo.save(new Host(name, surname, country));
    }

    @Override
    public Host update(Long id, String name, String surname, Long countryId) {
        Host host = this.findById(id);
        Country country = this.countryRepo.findById(countryId).get();
        host.setName(name);
        host.setSurrname(surname);
        host.setCountry(country);
        return this.hostRepo.save(host);
    }
}
