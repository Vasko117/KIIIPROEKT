package mk.ukim.finki.vb.model.emt;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surrname;
    @ManyToOne
    private Country country;


    public Host(String name, String surrname, Country country) {
        this.name = name;
        this.surrname = surrname;
        this.country = country;
    }
}
