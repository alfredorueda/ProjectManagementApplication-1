package demo.controller;

import demo.exception.DeveloperException;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by poo2 on 29/06/2015.
 */
@RestController //SIRVE PARA SABER QUE ES UN CONTROLADOR
@RequestMapping("/developers")  //URL RELATIVA PARA ACCEDER AL CONTROLADOR
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer) {
        return developerRepository.save(developer);
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while (iterator.hasNext()) {
            developers.add(iterator.next());
        }

        return developers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        Developer developer = developerRepository.findOne(id);

        if(developer == null){throw new DeveloperException(id);}

        developerRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Developer updateById(@PathVariable Long id, @RequestBody Developer developer) {
        Developer d1 = developerRepository.findOne(id);

        if(d1 == null){throw new DeveloperException(id);}

        return developerRepository.save(developer);
    }
}