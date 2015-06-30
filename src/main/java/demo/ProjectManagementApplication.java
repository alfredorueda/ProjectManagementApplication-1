package demo;

import demo.model.*;
import demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        DeveloperService developerService = context.getBean(DeveloperService.class);
        ManagerService managerService = context.getBean(ManagerService.class);
        ProjectService projectService = context.getBean(ProjectService.class);
        SpecialityServices specialityService = context.getBean(SpecialityServices.class);

        employeeService.testEmployees();
        developerService.testDevelopers();
        managerService.testManager();
        projectService.testProject();
        specialityService.testSpecialities();

    }
}
