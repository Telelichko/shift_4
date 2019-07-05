package ru.cft.starterkit.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.cft.starterkit.entity.JobShiftEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.service.JobShiftEntityService;

import java.util.Collection;

@RestController // ("/tests")
public class JobShiftEntityController {

    private final JobShiftEntityService jobShiftEntityService;

    @Autowired
    public JobShiftEntityController(JobShiftEntityService jobShiftEntityService) {
        this.jobShiftEntityService = jobShiftEntityService;
    }

    @RequestMapping( // действие 1_1
            method = RequestMethod.POST,
            path = "/shift",
            consumes = "application/json", //x-www-form-urlencoded", 1 действ
            produces = "application/json"
    )
    public JobShiftEntity add(@RequestBody JobShiftEntity jobShiftEntity)   // Что приходит от протокола Ltqcnd 1_2
    {
        return jobShiftEntityService.add(jobShiftEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/shift/{id}", produces = "application/json")
    public JobShiftEntity get(@PathVariable(name = "id") Long id) {
        try {
            return jobShiftEntityService.get(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/shifts", produces = "application/json")
    public Collection<JobShiftEntity> get(){
        return jobShiftEntityService.get();}

    @RequestMapping(method = RequestMethod.DELETE, path = "shift/delete/{id}", produces = "application/json")
    public JobShiftEntity delete(@PathVariable(name = "id") Long id) {
        return jobShiftEntityService.delete(id);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "shift/{id}/edit", produces = "application/json")
    public JobShiftEntity update(@RequestBody JobShiftEntity jobShiftEntity, @PathVariable(name = "id") Long id) {
        return jobShiftEntityService.update(jobShiftEntity);
    }

}
