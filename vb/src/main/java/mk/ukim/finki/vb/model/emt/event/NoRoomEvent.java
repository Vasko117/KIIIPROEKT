package mk.ukim.finki.vb.model.emt.event;

import lombok.Getter;
import mk.ukim.finki.vb.model.emt.Smestuvanje;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class NoRoomEvent extends ApplicationEvent {
    private LocalDateTime when;
    public NoRoomEvent(Smestuvanje source) {
        super(source);
        this.when = LocalDateTime.now();
    }

    public NoRoomEvent(Smestuvanje source, LocalDateTime when) {
        super(source);
        this.when = when;
    }

}
