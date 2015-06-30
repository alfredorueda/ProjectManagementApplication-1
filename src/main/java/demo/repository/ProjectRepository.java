package demo.repository;

import demo.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long>{
}
