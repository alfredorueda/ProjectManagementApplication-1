package demo.repository;

import demo.model.Speciality;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by poo2 on 25/06/2015.
 */
public interface SpecialityRepository extends PagingAndSortingRepository<Speciality, Long> {
}
