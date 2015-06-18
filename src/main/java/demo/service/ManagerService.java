package demo.service;

import demo.model.Manager;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by maariioo on 18/6/15.
 */

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public void testManager() {

        Manager manager1 = new Manager();
        manager1.setName("Trunks");
        manager1.setSurname("SSJJ");
        manager1.setSalary(1000.0);
        manager1.setDateIncorporation(new Date());
        manager1.setBonusSucces(20.0);

        managerRepository.save(manager1);


        Manager manager2 = new Manager();
        manager2.setName("Son Goten");
        manager2.setSurname("SSJJ");
        manager2.setSalary(1500.0);
        manager2.setDateIncorporation(new Date());
        manager2.setBonusSucces(50.0);

        managerRepository.save(manager2);

        Manager manager3 = new Manager();
        manager3.setName("Vegeta");
        manager3.setSurname("SSJJ4");
        manager3.setSalary(10000.0);
        manager3.setDateIncorporation(new Date());
        manager3.setBonusSucces(200.0);

        managerRepository.save(manager3);
    }
}
