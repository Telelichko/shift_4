package ru.cft.starterkit.repository;

import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;

import java.util.Collection;

public interface WorkerEntityRepository {
    WorkerEntity add(WorkerEntity workerEntity);

    WorkerEntity get(Long id) throws ObjectNotFoundException;

    Collection<WorkerEntity> get();

    WorkerEntity delete(WorkerEntity workerEntity);
}
