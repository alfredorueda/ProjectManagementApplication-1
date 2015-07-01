package demo.service;

import demo.model.Developer;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
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

    public void testSpecialities() {
        Developer developer = developerRepository.findBySurname("Romero").get(0);
        Speciality sp1 = new Speciality();
        sp1.setName("Java");

        specialityRepository.save(sp1);

        developer.getSpecialitiesSet().add(sp1);

        developerRepository.save(developer);
    }

}
