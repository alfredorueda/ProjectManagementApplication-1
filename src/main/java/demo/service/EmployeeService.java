package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 16/06/2015.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void testEmployees() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();
        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();
        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date incorporationDate = calendar.getTime();

        /* EMPLEADOS CON FECHA DE INCORPORACION, NO NEW DATE() */

        Employee employee = new Employee();
        employee.setName("Cristian");
        employee.setSurname("Fernandez");
        employee.setSalary(12300.0);
        employee.setDateIncorporation(incorporationDate);

        employeeRepository.save(employee);

        Employee employee0 = new Employee();
        employee0.setName("Sara");
        employee0.setSurname("Lorente");
        employee0.setSalary(12300.0);
        employee0.setDateIncorporation(incorporationDate);

        employeeRepository.save(employee0);

        /* EMPLEADOS CON FECHA DE INCORPORACION, NEW DATE() */

        Employee employee1 = new Employee();
        employee1.setName("Mario");
        employee1.setSurname("Romero");
        employee1.setSalary(12300.0);
        employee1.setDateIncorporation(new Date());

        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Omar");
        employee2.setSurname("Romero");
        employee2.setSalary(12300.0);
        employee2.setDateIncorporation(new Date());

        employeeRepository.save(employee2);

        /* FIND BY NAME AND SURNAME */

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Employee eaux : employeeRepository.findByNameAndSurname("Mario", "Romero")){
            System.out.println(eaux);
        }

        /* FIND BY SURNAME */

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Employee eaux : employeeRepository.findBySurname("Romero")){
            System.out.println(eaux);
        }

        /* FIND BY DATE INCORPORATION */

        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");
        System.out.println("####################################################");

        for(Employee eaux : employeeRepository.findByDateIncorporationBetween(startDate,endDate)){
            System.out.println(eaux);
        }


    }
}
