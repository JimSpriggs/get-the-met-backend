package uk.spon.getthemet.exception;

public class MetrolinkStationNotFoundException extends IllegalArgumentException {
    public MetrolinkStationNotFoundException(String message) {
        super(message);
    }
}
