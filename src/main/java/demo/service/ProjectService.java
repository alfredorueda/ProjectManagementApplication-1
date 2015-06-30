package demo.service;

import demo.model.*;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by maariioo on 18/6/15.
 */

@Service
public class ProjectService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    ProjectRepository projectRepository;

    public void testProject() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();
        calendar.set(2015, Calendar.SEPTEMBER, 1);
        Date endDate = calendar.getTime();
        Project project = new Project();
        project.setDescription("PROYECTO DE JAVA");
        project.setStartDate(startDate);
        project.setEndDate(endDate);
        Manager manager = managerRepository.findBySurname("SSJJ").get(0);
        project.setManager(manager);

        projectRepository.save(project);

        Developer developer = (Developer)developerRepository.findBySurname("Romero").get(0);
        project.getDeveloperSet().add(developer);

        projectRepository.save(project);

    }
}
