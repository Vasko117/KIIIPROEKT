package mk.ukim.finki.vb.model.emt.Dto;

import lombok.Data;
import mk.ukim.finki.vb.model.emt.Category;

@Data
public class SmestuvanjeDTO {
    Category category;
    Long hostId;
    int numRooms;
}
