package demo.repository;

import demo.model.Manager;
import demo.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long>{

    List<Project> findByManagerProjects(@Param("manager")Manager manager);

}
