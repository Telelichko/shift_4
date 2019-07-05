package ru.cft.starterkit.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.cft.starterkit.entity.SampleEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.service.SampleEntityService;

import java.util.Collection;

@RestController // ("/tests")
public class SampleEntityController {

    private final SampleEntityService sampleEntityService;

    @Autowired
    public SampleEntityController(SampleEntityService sampleEntityService) {
        this.sampleEntityService = sampleEntityService;
    }

    @PostMapping(
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public SampleEntity add(
            @RequestParam(name = "foo") String foo,
            @RequestParam(name = "bar", defaultValue = "1.1") Double bar
    ) {

        return sampleEntityService.add(foo, bar);
    }


//    @RequestMapping( // действие 1_1
//            method = RequestMethod.POST,
//            path = "/sample",
//            consumes = "application/json", //x-www-form-urlencoded", 1 действ
//            produces = "application/json"
//    )
//    public SampleEntity add(@RequestBody SampleEntity sampleEntity)   // Что приходит от протокола Ltqcnd 1_2
////             {
////        //return sampleEntityService.add(sampleEntity);
////    }

    @RequestMapping(method = RequestMethod.GET, path = "/sample/{id}", produces = "application/json")
    public SampleEntity get(@PathVariable(name = "id") Long id) {
        try {
            return sampleEntityService.get(id);
        } catch (ObjectNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/samples", produces = "application/json")
    public Collection<SampleEntity> get(){
        return sampleEntityService.get();}

}
