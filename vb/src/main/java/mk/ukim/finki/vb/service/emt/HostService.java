package mk.ukim.finki.vb.service.emt;

import mk.ukim.finki.vb.model.emt.Host;

import java.util.List;

public interface HostService {
    List<Host> listAll();
    Host findById(Long id);
    void deleteById(Long id);
    Host create(String name, String surname, Long countryId);
    Host update(Long id, String name, String surname, Long countryId);
}
