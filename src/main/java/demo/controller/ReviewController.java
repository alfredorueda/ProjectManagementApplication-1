package demo.controller;

import demo.exception.*;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Speciality;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRepository;
import demo.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by poo2 on 06/07/2015.
 */
@RestController
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    @RequestMapping(value = "/projects/{idProject}/developers/{idDeveloper}/specialtys/{idSpecialty}/review", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@PathVariable Long idProject,
                            @PathVariable Long idDeveloper,
                            @PathVariable Long idSpeciality,
                            @RequestBody Review review)
    {
        /*INSTANCIAMOS UN PROJECTO A PARTIR DEL IDPROJECTO*/
        Project project = projectRepository.findOne(idProject);

        if (project == null) throw new ProjectException(idProject);

        /*INSTANCIAMOS UN DEVELOPER A PARTIR DEL IDDEVELOPER*/
        Developer developer = developerRepository.findOne(idDeveloper);

        if (developer == null) throw new DeveloperException(idDeveloper);

        /*INSTANCIAMOS UNA SPECIALTY A PARTIR DE LA IDSPECIALTY*/
        Speciality speciality = specialityRepository.findOne(idSpeciality);

        if (speciality == null) throw new SpecialityException(idSpeciality);

        /**/
        if (!developer.getProjectSet().contains(project)) throw new ReviewDeveloperProjectException(idProject, idDeveloper);

        /**/
        if (!project.getSpecialities().contains(speciality)) throw new ReviewProjectSpecialityException(idProject, idSpeciality);

        /**/
        if (!developer.getSpecialitiesSet().contains(speciality)) throw new ReviewDeveloperSpeciality(idDeveloper, idSpeciality);

        review.setDate(new Date());

        review.setProjects(project);

        review.setDevelopers(developer);

        review.setSpecialitys(speciality);

        reviewRepository.save(review);

        return review;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<Review>();
        Iterator<Review> iterator = reviewRepository.findAll().iterator();

        while (iterator.hasNext()) reviews.add(iterator.next());

        return reviews;
    }

    @RequestMapping(value= "/{id}", method = GET)
    public Review getById(@PathVariable Long id) {
        Review review = reviewRepository.findOne(id);

        if (review == null) throw new ReviewException(id);

        return review;
    }


    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        Review review = reviewRepository.findOne(id);

        if (review == null) throw new ReviewException(id);

        reviewRepository.delete(id);
    }

    @RequestMapping(value= "/{id}", method = RequestMethod.PUT)
    public Review updateById(@PathVariable Long id, @RequestBody Review review) {
        if (reviewRepository.findOne(id) == null) throw new ReviewException(id);

        review = reviewRepository.save(review);

        return review;
    }
}
