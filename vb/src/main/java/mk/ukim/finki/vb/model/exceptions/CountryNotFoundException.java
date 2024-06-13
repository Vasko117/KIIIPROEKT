package mk.ukim.finki.vb.model.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException() {
        super("Country not found.");
    }
}
