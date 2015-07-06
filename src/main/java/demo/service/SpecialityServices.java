package demo.service;

import demo.model.Developer;
import demo.model.Project;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by poo2 on 25/06/2015.
 */
@Service
@Transactional
public class SpecialityServices {

    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public void testSpecialities() {
        Developer developer = developerRepository.findBySurname("Romero").get(0);
        Project project = projectRepository.findOne(1L);
        Speciality speciality = new Speciality();
        speciality.setName("Java");

        specialityRepository.save(speciality);

        project.getSpecialities().add(speciality);

        developer.getProjectSet().add(project);

        developerRepository.save(developer);
    }

}
