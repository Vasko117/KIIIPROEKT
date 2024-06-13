package mk.ukim.finki.vb.model.exceptions;

public class PlaceNotFoundExeption extends RuntimeException{
    public PlaceNotFoundExeption() {
        super("No place found.");
    }

}
