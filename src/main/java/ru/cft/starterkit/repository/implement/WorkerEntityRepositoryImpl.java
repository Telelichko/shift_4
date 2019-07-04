package ru.cft.starterkit.repository.implement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.repository.WorkerEntityRepository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class WorkerEntityRepositoryImpl implements WorkerEntityRepository {

    private static final Logger log = LoggerFactory.getLogger(WorkerEntityRepositoryImpl.class);

    private final AtomicInteger idCounter = new AtomicInteger();

    private final Map<Long, WorkerEntity> storage = new ConcurrentHashMap<>();

    @Override
    public WorkerEntity add(WorkerEntity workerEntity) {
        workerEntity.setId(idCounter.incrementAndGet());
        storage.put((long)workerEntity.getId(), workerEntity);

        log.info("Added new worker entity to storage: {}", workerEntity);
        return workerEntity;
    }

    @Override
    public WorkerEntity delete(WorkerEntity workerEntity) {
        workerEntity.getId(idCounter.incrementAndGet());
        storage.put((long) workerEntity.getId(), workerEntity);

        log.info("Added new worker entity to storage: {}", workerEntity);
        return workerEntity;
    }

    @Override
    public WorkerEntity get(Long id) throws ObjectNotFoundException {
        WorkerEntity workerEntity = storage.get(id);

        if (workerEntity == null) {
            log.error("Failed to get worker entity with id '{}' from storage", id);
            throw new ObjectNotFoundException(String.format("Worker entity with id %s not found", id));
        }

        log.info("Returned worker entity with id '{}' from storage: {}", id, workerEntity);
        return workerEntity;
    }

    @Override
    public Collection<WorkerEntity> get() {
        return storage.values();
    }

}
