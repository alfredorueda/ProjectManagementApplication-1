package demo.controller;

    import demo.exception.ProjectException;
    import demo.model.Manager;
    import demo.model.Project;
    import demo.repository.ManagerRepository;
    import demo.repository.ProjectRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;

    import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by poo2 on 01/07/2015.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project save(@RequestBody Project project) {return projectRepository.save(project);}

    @RequestMapping(method= RequestMethod.GET)
    public List<Project> findAll() {
        List<Project> projects = new ArrayList<Project>();
        Iterator<Project> iterator = projectRepository.findAll().iterator();

        while (iterator.hasNext())projects.add(iterator.next());

        return projects;
    }

    @RequestMapping(value= "/{id}", method = GET)
    public Project getById(@PathVariable Long id) {
        Project project = projectRepository.findOne(id);

        if (project == null) throw new ProjectException(id);

        return project;
    }
    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        Project project = projectRepository.findOne(id);

        if (project == null) throw new ProjectException(id);

        projectRepository.delete(id);

    }
    @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
    public Project updateById(@PathVariable Long id,@RequestBody Project project) {

        if (projectRepository.findOne(id) == null)
            throw new ProjectException(id);

        project = projectRepository.save(project);
        return project;
    }

    @RequestMapping(value = "/{idProject}/manager/{idManager}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project addManager(@PathVariable Long idProject, @RequestBody Project project) {
        if (projectRepository.findOne(idProject) == null) throw new ProjectException(idProject);
        return projectRepository.save(project);
    }

    @RequestMapping(value = "/{idProject}/manager", method = RequestMethod.GET)
    public Manager getByManager(@PathVariable Long idProject) {
        Project project = projectRepository.findOne(idProject);

        if (project == null) throw new ProjectException(idProject);

        return project.getManager();

    }
}