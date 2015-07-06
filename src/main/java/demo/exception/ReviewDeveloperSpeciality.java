package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by poo2 on 06/07/2015.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReviewDeveloperSpeciality extends RuntimeException{
   public ReviewDeveloperSpeciality(Long idDeveloper, Long idSpeciality) {
       super("NO IDDEVELOPER: " + idDeveloper + " WITH IDSPECIALITY: " + idSpeciality);
   }
}
