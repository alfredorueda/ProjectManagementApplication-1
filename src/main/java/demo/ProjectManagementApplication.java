package demo;

import demo.model.Manager;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        employeeService.testEmployees();

        DeveloperService developerService = context.getBean(DeveloperService.class);
        developerService.testDevelopers();

        ManagerService managerService = context.getBean(ManagerService.class);
        managerService.testManager();

        ProjectService projectService = context.getBean(ProjectService.class);
        projectService.testProject();


    }
}
