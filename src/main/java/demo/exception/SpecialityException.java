package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SpecialityException extends RuntimeException{
    public SpecialityException(Long id) {
        super("NO EXIST SPECIALITY WITH ID: "+ id);
    }
}
