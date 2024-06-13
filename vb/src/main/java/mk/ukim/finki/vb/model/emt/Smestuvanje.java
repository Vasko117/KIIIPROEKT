package mk.ukim.finki.vb.model.emt;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Smestuvanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated
    private Category category;
    private int numRooms;
    private boolean daliIznajmena;
    @ManyToOne
    private Host host;

    public Smestuvanje(Category category, int numRooms, Host host) {
        this.category = category;
        this.numRooms = numRooms;
        this.daliIznajmena = false;
        this.host = host;
    }
}
