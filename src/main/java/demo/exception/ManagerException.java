package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 30/06/2015.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ManagerException extends RuntimeException{
    public ManagerException(Long id) {
        super("NO EXIST MANAGER WITH ID: "+ id);
    }
}