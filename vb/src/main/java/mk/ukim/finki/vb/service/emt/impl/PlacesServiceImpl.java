package mk.ukim.finki.vb.service.emt.impl;

import mk.ukim.finki.vb.model.emt.Category;
import mk.ukim.finki.vb.model.emt.Host;
import mk.ukim.finki.vb.model.emt.Smestuvanje;
import mk.ukim.finki.vb.model.emt.event.NoRoomEvent;
import mk.ukim.finki.vb.model.exceptions.PlaceNotFoundExeption;
import mk.ukim.finki.vb.repository.emt.HostRepo;
import mk.ukim.finki.vb.repository.emt.SmestuvanjeRepo;
import mk.ukim.finki.vb.service.emt.PlacesService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacesServiceImpl implements PlacesService {
    private final SmestuvanjeRepo smestuvanjeRepo;
    private final HostRepo hostRepo;
    private final ApplicationEventPublisher applicationEventPublisher;

    public PlacesServiceImpl(SmestuvanjeRepo smestuvanjeRepo, HostRepo hostRepo, ApplicationEventPublisher applicationEventPublisher) {
        this.smestuvanjeRepo = smestuvanjeRepo;
        this.hostRepo = hostRepo;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Smestuvanje> findAll() {
        return this.smestuvanjeRepo.findAll();
    }

    @Override
    public Smestuvanje findById(Long id) {
        return smestuvanjeRepo.findById(id).orElseThrow(PlaceNotFoundExeption::new);
    }

    @Override
    public Smestuvanje save(Category category, Long hostId, int numRooms) {
        Host host=hostRepo.findById(hostId).get();
        return smestuvanjeRepo.save(new Smestuvanje(category,numRooms,host));
    }

    @Override
    public Smestuvanje edit(Long id, Category category, int numRooms, Long hostId) {
        Smestuvanje s = this.findById(id);
        Host host = hostRepo.findById(hostId).get();

        s.setCategory(category);
        s.setHost(host);
        s.setNumRooms(numRooms);

        return smestuvanjeRepo.save(s);
    }

    @Override
    public void deleteById(Long id) {
        Smestuvanje s=smestuvanjeRepo.findById(id).get();
        this.smestuvanjeRepo.delete(s);
    }

    @Override
    public void mark(Long id) {
        Smestuvanje smestuvanje = this.findById(id);
        if(smestuvanje.getNumRooms()!=0)
        {
            smestuvanje.setNumRooms(smestuvanje.getNumRooms() - 1);
            smestuvanjeRepo.save(smestuvanje);

        }
        if(smestuvanje.getNumRooms()==0)
        {
            this.applicationEventPublisher.publishEvent(new NoRoomEvent(smestuvanje));
            smestuvanjeRepo.delete(smestuvanje);
        }
    }

}
