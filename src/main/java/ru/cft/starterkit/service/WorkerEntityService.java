package ru.cft.starterkit.service;


import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;

import java.util.Collection;

public interface WorkerEntityService {

    WorkerEntity get(Long id) throws ObjectNotFoundException;

    Collection<WorkerEntity> get();

    WorkerEntity add(WorkerEntity workerEntity);

    WorkerEntity delete(WorkerEntity workerEntity);
}
