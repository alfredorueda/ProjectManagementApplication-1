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
    ProjectRepository projectRepository;

    public void testProject() {

        Manager manager1 = new Manager();
        manager1.setName("Son Goku");
        manager1.setSurname("SSJJ4");
        manager1.setSalary(1234.0);
        manager1.setBonusSucces(100.0);
        manager1.setDateIncorporation(new Date());

        managerRepository.save(manager1);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        calendar.set(2015, Calendar.SEPTEMBER, 1);

        Date startDate = calendar.getTime();
        Date endDate = calendar.getTime();

        Project project = new Project();

        project.setDescription("PROYECTO DE JAVA");
        project.setStartDate(startDate);
        project.setEndDate(endDate);

        project.setManager(manager1);

        projectRepository.save(project);

    }
}
