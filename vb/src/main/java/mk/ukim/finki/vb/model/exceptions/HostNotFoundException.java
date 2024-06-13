package mk.ukim.finki.vb.model.exceptions;

public class HostNotFoundException extends RuntimeException{
    public HostNotFoundException() {
        super("Host not found.");
    }
}
