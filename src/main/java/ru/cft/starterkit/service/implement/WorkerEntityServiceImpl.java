package ru.cft.starterkit.service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.starterkit.entity.WorkerEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.repository.WorkerEntityRepository;
import ru.cft.starterkit.service.WorkerEntityService;

import java.util.Collection;
import java.util.UUID;

@Service
public class WorkerEntityServiceImpl implements WorkerEntityService {

    private final WorkerEntityRepository workerEntityRepository;

    @Autowired
    public WorkerEntityServiceImpl(WorkerEntityRepository workerEntityRepository) {
        this.workerEntityRepository = workerEntityRepository;
    }


//    @Override
//    public WorkerEntity add(String shiftName, String category, Integer phoneNumber) {
//        return workerEntityRepository.add(new WorkerEntity(shiftName, category, phoneNumber, UUID.randomUUID()));
//    }

    @Override
    public WorkerEntity get(Long id) throws ObjectNotFoundException {
        return workerEntityRepository.get(id);
    }

    @Override
    public Collection<WorkerEntity> get() {
        return workerEntityRepository.get();
    }

    @Override
    public WorkerEntity add(WorkerEntity workerEntity) {
        workerEntity.setBaz(UUID.randomUUID());
        return workerEntityRepository.add(workerEntity);
    }

    @Override
    public WorkerEntity delete(WorkerEntity workerEntity) {
        workerEntity.setBaz(UUID.randomUUID());
        return workerEntityRepository.delete(workerEntity);
    }

}
