package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n02.exceptions;

public class PlayerNotFound extends RuntimeException{
    public PlayerNotFound(String message) {
        super(message);
    }
}