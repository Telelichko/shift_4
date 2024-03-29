package ru.cft.starterkit.service;


import ru.cft.starterkit.entity.JobShiftEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;

import java.util.Collection;

public interface JobShiftEntityService {

//    WorkerEntity add(String foo, Double bar);

    JobShiftEntity get(Long id) throws ObjectNotFoundException;

    Collection<JobShiftEntity> get();

    JobShiftEntity add(JobShiftEntity jobShiftEntity);
}
