package demo.controller;

import demo.exception.ManagerException;
import demo.model.Manager;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by poo2 on 01/07/2015.
 */
@RestController //SIRVE PARA SABER QUE ES UN CONTROLADOR
@RequestMapping("/managers")  //URL RELATIVA PARA ACCEDER AL CONTROLADOR
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Manager save(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }

    @RequestMapping(method= RequestMethod.GET)
    public List<Manager> findAll() {
        List<Manager> managers = new ArrayList<Manager>();
        Iterator<Manager> iterator = managerRepository.findAll().iterator();

        while (iterator.hasNext()) {
            managers.add(iterator.next());
        }

        return managers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        Manager manager = managerRepository.findOne(id);

        if(manager == null){throw new ManagerException(id);}

        managerRepository.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Manager updateById(@PathVariable Long id, @RequestBody Manager manager) {
        Manager m1 = managerRepository.findOne(id);

        if(m1 == null){throw new ManagerException(id);}

        return managerRepository.save(manager);
    }
}