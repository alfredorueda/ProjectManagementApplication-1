package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 30/06/2015.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DeveloperException extends RuntimeException{
    public DeveloperException(Long id) {
        super("NO EXIST DEVELOPER WITH ID: "+ id);
    }
}