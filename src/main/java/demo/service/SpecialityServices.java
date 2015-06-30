package demo.service;

import demo.model.Developer;
import demo.model.Speciality;
import demo.repository.EmployeeRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by poo2 on 25/06/2015.
 */
@Service
public class SpecialityServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    public void testSpecialities() {
        Developer developer = (Developer)employeeRepository.findBySurname("Romero").get(0);
        Speciality sp1 = new Speciality();
        sp1.setName("Java");
        sp1.getDeveloperSet().add(developer);
        specialityRepository.save(sp1);
    }

}
