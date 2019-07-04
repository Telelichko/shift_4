package ru.cft.starterkit.repository.implement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.cft.starterkit.entity.JobShiftEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.repository.JobShiftEntityRepository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class JobShiftEntityRepositoryImpl implements JobShiftEntityRepository {

    private static final Logger log = LoggerFactory.getLogger(JobShiftEntityRepositoryImpl.class);

    private final AtomicInteger idCounter = new AtomicInteger();

    private final Map<Long, JobShiftEntity> storage = new ConcurrentHashMap<>();

    @Override
    public JobShiftEntity add(JobShiftEntity jobShiftEntity) {
        jobShiftEntity.setId(idCounter.incrementAndGet());
        storage.put((long)jobShiftEntity.getId(), jobShiftEntity);

        log.info("Added new job entity to storage: {}", jobShiftEntity);
        return jobShiftEntity;
    }

    @Override
    public JobShiftEntity get(Long id) throws ObjectNotFoundException {
        JobShiftEntity jobShiftEntity = storage.get(id);

        if (jobShiftEntity == null) {
            log.error("Failed to get job entity with id '{}' from storage", id);
            throw new ObjectNotFoundException(String.format("Job entity with id %s not found", id));
        }

        log.info("Returned job entity with id '{}' from storage: {}", id, jobShiftEntity);
        return jobShiftEntity;
    }

    @Override
    public JobShiftEntity delete(JobShiftEntity jobShiftEntity) {
        storage.remove(jobShiftEntity.getId(), jobShiftEntity);

        log.info("Worker entity deleted from storage: {}", jobShiftEntity);
        return jobShiftEntity;
    }

    @Override
    public Collection<JobShiftEntity> get() {
        return storage.values();
    }

}
