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
            path = "/job",
            consumes = "application/json", //x-www-form-urlencoded", 1 действ
            produces = "application/json"
    )
    public JobShiftEntity add(@RequestBody JobShiftEntity jobShiftEntity)   // Что приходит от протокола Ltqcnd 1_2
    {
        return jobShiftEntityService.add(jobShiftEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/job/{id}", produces = "application/json")
    public JobShiftEntity get(@PathVariable(name = "id") Long id) {
        try {
            return jobShiftEntityService.get(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/jobs", produces = "application/json")
    public Collection<JobShiftEntity> get(){
        return jobShiftEntityService.get();}

}
