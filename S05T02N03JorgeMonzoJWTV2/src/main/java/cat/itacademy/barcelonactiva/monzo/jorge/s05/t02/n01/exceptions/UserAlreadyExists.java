package cat.itacademy.barcelonactiva.monzo.jorge.s05.t02.n01.exceptions;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message) {
        super(message);
    }
}

