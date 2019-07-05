package ru.cft.starterkit.repository.implement;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.repository.WorkerEntityRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class WorkerEntityRepositoryImpl implements WorkerEntityRepository {

    private static final Logger log = LoggerFactory.getLogger(WorkerEntityRepositoryImpl.class);

    private final File storageFile;

    private final AtomicInteger idCounter = new AtomicInteger();

    private final Map<Long, WorkerEntity> storage = new ConcurrentHashMap<>();

    private final ObjectMapper objectMapper;

    public WorkerEntityRepositoryImpl(@Value("${repository.storage.worker}") String storageFilePath) {
        this.storageFile = new File(storageFilePath);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public WorkerEntity add(WorkerEntity workerEntity) {
        workerEntity.setId(idCounter.incrementAndGet());
        storage.put((long) workerEntity.getId(), workerEntity);

        log.info("Added new worker entity to storage: {}", workerEntity);
        return workerEntity;
    }

    @Override
    public WorkerEntity delete(long id) {
        log.info("Worker entity deleted from storage: {}", id);
        return storage.remove(id);
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

    @PostConstruct
    private void initStorage() {
        try {
            WorkerEntity[] entriesFromFile = objectMapper.readValue(storageFile, WorkerEntity[].class);
            for (WorkerEntity workerEntity : entriesFromFile) {
                storage.put((long)workerEntity.getId(), workerEntity);
                if (idCounter.get() < workerEntity.getId()) {
                    idCounter.set(workerEntity.getId());
                }
            }
            log.info("Loaded {} entities to storage. Id counter set to {}.", storage.size(), idCounter.get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    private void shutdown() {
        log.info("Start shutdown!");
        try {
            objectMapper.writeValue(storageFile, storage.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Shutdown is ready!");
    }

}
