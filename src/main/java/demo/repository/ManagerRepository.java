package demo.repository;

import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {

    List<Manager> findBySurname(@Param("surname") String surname);

    List<Manager> findByNameAndSurname(@Param("name") String name,
                                       @Param("surname") String surname);

}
