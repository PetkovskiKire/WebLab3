package mk.finki.ukim.mk.lab.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BalloonNotFoundException extends RuntimeException{
    public BalloonNotFoundException(Long id) {
        super(String.format("Ballooon with id: %d was not found", id));
    }
}
