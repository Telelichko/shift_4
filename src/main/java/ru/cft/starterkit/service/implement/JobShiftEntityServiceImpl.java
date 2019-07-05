package ru.cft.starterkit.service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.starterkit.entity.JobShiftEntity;
import ru.cft.starterkit.exception.ObjectNotFoundException;
import ru.cft.starterkit.repository.JobShiftEntityRepository;
import ru.cft.starterkit.service.JobShiftEntityService;

import java.util.Collection;
import java.util.UUID;

@Service
public class JobShiftEntityServiceImpl implements JobShiftEntityService {

    private final JobShiftEntityRepository jobShiftEntityRepository;

    @Autowired
    public JobShiftEntityServiceImpl(JobShiftEntityRepository jobShiftEntityRepository) {
        this.jobShiftEntityRepository = jobShiftEntityRepository;
    }

    @Override
    public JobShiftEntity get(Long id) throws ObjectNotFoundException {
        return jobShiftEntityRepository.get(id);
    }

    @Override
    public Collection<JobShiftEntity> get() {
        return jobShiftEntityRepository.get();
    }

    @Override
    public JobShiftEntity add(JobShiftEntity jobShiftEntity) {
        jobShiftEntity.setBaz(UUID.randomUUID());
        return jobShiftEntityRepository.add(jobShiftEntity);
    }

    @Override
    public JobShiftEntity delete(long id) {
        return jobShiftEntityRepository.delete(id);
    }

}
