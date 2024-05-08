package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message) {
        super(message);
    }
}

