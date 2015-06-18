package demo.repository;

import demo.model.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

/**
 * Created by poo2 on 17/06/2015.
 */
public interface DeveloperRepository  extends PagingAndSortingRepository<Developer, Long> {

    List<Developer> findBySurname(@Param("surname") String surname);

    List<Developer> findByNameAndSurname(@Param("name") String name,
                                          @Param("surname") String surname);

    //List<Developer> findByCategory(@Param("category")Category category);
}
