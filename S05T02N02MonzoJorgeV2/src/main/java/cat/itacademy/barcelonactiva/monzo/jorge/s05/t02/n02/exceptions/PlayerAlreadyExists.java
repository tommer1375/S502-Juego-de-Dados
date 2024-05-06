package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.exceptions;

public class PlayerAlreadyExists extends RuntimeException{
    public PlayerAlreadyExists(String message) {
        super(message);
    }
}