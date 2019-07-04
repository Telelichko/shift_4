package ru.cft.starterkit.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.service.WorkerEntityService;

import java.util.Collection;

@RestController // ("/tests")
public class WorkerEntityController {

    private final WorkerEntityService workerEntityService;

    @Autowired
    public WorkerEntityController(WorkerEntityService workerEntityService) {
        this.workerEntityService = workerEntityService;
    }

    @RequestMapping( // действие 1_1
            method = RequestMethod.POST,
            path = "/worker",
            consumes = "application/json", //x-www-form-urlencoded", 1 действ
            produces = "application/json"
    )

    public WorkerEntity add(@RequestBody WorkerEntity workerEntity)   // Что приходит от протокола Ltqcnd 1_2
             {
        return workerEntityService.add(workerEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/worker/{id}", produces = "application/json")
    public WorkerEntity get(@PathVariable(name = "id") Long id) {
        try {
            return workerEntityService.get(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/workers", produces = "application/json")
    public Collection<WorkerEntity> get(){
        return workerEntityService.get();}

    @RequestMapping(method = RequestMethod.DELETE, path = "worker/{id}", produces = "application/json")
    public WorkerEntity delete(){
        return workerEntityService.delete();}

}
