package ru.cft.starterkit.service;


import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;

import java.util.Collection;

public interface WorkerEntityService {

//    WorkerEntity add(String foo, Double bar);

    WorkerEntity get(Long id) throws ObjectNotFoundException;

    Collection<WorkerEntity> get();

    Collection<WorkerEntity> delete();

    WorkerEntity add(WorkerEntity workerEntity);
}
