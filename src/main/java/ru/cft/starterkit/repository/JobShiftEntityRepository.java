package ru.cft.starterkit.repository;


import ru.cft.starterkit.entity.JobShiftEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;

import java.util.Collection;

public interface JobShiftEntityRepository {

    JobShiftEntity add(JobShiftEntity entity);

    JobShiftEntity get(Long id) throws ObjectNotFoundException;

    Collection<JobShiftEntity> get();
}
