package demo.service;


import demo.model.*;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * CREADO POR MARIO ROMERO FERNANDEZ
 */

@Service
public class DeveloperService {

    /**
     * Test Developers
     */
    @Autowired
    DeveloperRepository developerRepository;

    public void testDevelopers(){

        Developer developer1 = new Developer();
        developer1.setName("Mario");
        developer1.setSurname("Romero");
        developer1.setSalary(3400.0);
        developer1.setCategory(Category.JUNIOR);
        developer1.setDateIncorporation(new Date());

        developerRepository.save(developer1);

        Developer developer2 = new Developer();
        developer2.setName("Alejandro");
        developer2.setSurname("Muñoz");
        developer2.setSalary(3200.0);
        developer2.setCategory(Category.SENIOR);
        developer2.setDateIncorporation(new Date());

        developerRepository.save(developer2);

        Developer developer3 = new Developer();
        developer3.setName("Alhaj");
        developer3.setSurname("Bah Boom");
        developer3.setSalary(1200.0);
        developer3.setCategory(Category.ARCHITECT);
        developer3.setDateIncorporation(new Date());

        developerRepository.save(developer3);

        Developer developer4 = new Developer();
        developer4.setName("Son");
        developer4.setSurname("Goku");
        developer4.setSalary(200.0);
        developer4.setCategory(Category.JUNIOR);
        developer4.setDateIncorporation(new Date());

        developerRepository.save(developer4);

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Developer daux : developerRepository.findByNameAndSurname("Mario", "Romero")){
            System.out.println(daux);
        }

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        /*for(Developer daux : developerRepository.findByCategory(Category.SENIOR)){
            System.out.println(daux);
        }*/

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Developer daux : developerRepository.findBySurname("Goku")){
            System.out.println(daux);
        }
    }
}