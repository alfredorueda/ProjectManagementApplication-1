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
    @Autowired
    private DeveloperRepository developerRepository;
/*
    public void testEmployees() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();
        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();
        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date incorporationDate = calendar.getTime();

        CRAECION DE LOS EMPLEADOS DENTRO DEL RANGO DE FECHA

        Employee employee000 = new Employee();
        employee000.setName("Mario");
        employee000.setSurname("Romero");
        employee000.setSalary(12300.0);
        employee000.setDateIncorporation(incorporationDate);
        employeeRepository.save(employee000);

        Employee employee0 = new Employee();
        employee0.setName("Cristian");
        employee0.setSurname("Fernandez");
        employee0.setSalary(12300.0);
        employee0.setDateIncorporation(incorporationDate);
        employeeRepository.save(employee0);

        Employee employee00 = new Employee();
        employee00.setName("Sara");
        employee00.setSurname("Lorente");
        employee00.setSalary(12300.0);
        employee00.setDateIncorporation(incorporationDate);
        employeeRepository.save(employee00);

        CREACION DE LOS EMPLEADOS CON FECHA DE HOY

        Employee employee = new Employee();
        employee.setName("Carlos");
        employee.setSurname("Mendez");
        employee.setSalary(12300.0);
        employee.setDateIncorporation(new Date());
        employeeRepository.save(employee);

        Employee employee2 = new Employee();
        employee2.setName("Mario");
        employee2.setSurname("Mendez");
        employee2.setSalary(12300.0);
        employee2.setDateIncorporation(new Date());
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Alejandro");
        employee3.setSurname("Mendez");
        employee3.setSalary(12300.0);
        employee3.setDateIncorporation(new Date());
        employeeRepository.save(employee3);

        for (Employee eaux : employeeRepository.findBySurname("Mendez")){
            System.out.println(eaux);
        }

        for (Employee eaux : employeeRepository.findByDateIncorporationBetween(startDate, endDate)){
            System.out.println(eaux);
        }
    }
*/
    public void testDeveloper(){

        Calendar calendar = Calendar.getInstance();

        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();
        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();
        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date incorporationDate = calendar.getTime();

        Developer developer1 = new Developer();
        developer1.setName("Mario");
        developer1.setSurname("Romero");
        developer1.setSalary(1000.0);
        developer1.setDateIncorporation(new Date());
        developer1.setCategory(Category.ARCHITECT);
        developerRepository.save(developer1);

        Developer developer2 = new Developer();
        developer2.setName("Alejandro");
        developer2.setSurname("Muñoz");
        developer1.setSalary(2000.0);
        developer1.setDateIncorporation(incorporationDate);
        developer2.setCategory(Category.JUNIOR);
        developerRepository.save(developer2);

        Developer developer3 = new Developer();
        developer3.setName("Cristian");
        developer3.setSurname("Fernandez");
        developer1.setSalary(3000.0);
        developer1.setDateIncorporation(new Date());
        developer3.setCategory(Category.SENIOR);
        developerRepository.save(developer3);

        for (Developer eaux : developerRepository.findByNameAndSurname("Mario", "Romero")){
            System.out.println(eaux);
        }

        for (Developer eaux : developerRepository.findByDateIncorporationBetween(startDate, endDate)){
            System.out.println(eaux);
        }

        for (Developer eaux : developerRepository.findByCategory(Category.SENIOR)){
            System.out.println(eaux);
        }
    }
}
