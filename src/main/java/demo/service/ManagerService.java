package demo.service;

import demo.model.*;
import demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by maariioo on 18/6/15.
 */

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    public void testManager() {

        Manager manager1 = new Manager();
        manager1.setName("Trunks");
        manager1.setSurname("SSJJ");
        manager1.setSalary(1000.0);
        manager1.setDateIncorporation(new Date());
        manager1.setBonusSuccess(20.0);

        managerRepository.save(manager1);


        Manager manager2 = new Manager();
        manager2.setName("Son Goten");
        manager2.setSurname("SSJJ");
        manager2.setSalary(1500.0);
        manager2.setDateIncorporation(new Date());
        manager2.setBonusSuccess(50.0);

        managerRepository.save(manager2);

        Manager manager3 = new Manager();
        manager3.setName("Vegeta");
        manager3.setSurname("SSJJ2");
        manager3.setSalary(10000.0);
        manager3.setDateIncorporation(new Date());
        manager3.setBonusSuccess(200.0);

        managerRepository.save(manager3);

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Manager maux : managerRepository.findByNameAndSurname("Trunks", "SSJJ")){
            System.out.println(maux);
        }

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Manager maux : managerRepository.findBySurname("SSJJ")){
            System.out.println(maux);
        }
    }
}
