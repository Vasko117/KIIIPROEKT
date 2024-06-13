package mk.ukim.finki.vb.model.emt.listener;

import mk.ukim.finki.vb.model.emt.event.NoRoomEvent;
import mk.ukim.finki.vb.service.emt.PlacesService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NoRoomEventHandler {
    private final PlacesService placesService;

    public NoRoomEventHandler(PlacesService placesService) {
        this.placesService = placesService;
    }
    @EventListener
    public void onProductCreated(NoRoomEvent event) {
        System.out.println("No more room");
    }

}
