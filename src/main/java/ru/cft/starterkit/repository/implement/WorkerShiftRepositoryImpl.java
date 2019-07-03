package ru.cft.starterkit.repository.implement;

import ru.cft.starterkit.repository.WorkerShift;

public class WorkerShiftRepositoryImpl implements WorkerShift {

    private Integer id;
    private String worker; // ??? Создать поле ссылочного типа
    private String jobShift;
    private Boolean spendShift;

    public WorkerShiftRepositoryImpl() {
    }

    public WorkerShiftRepositoryImpl(Integer id, String worker, String jobShift, Boolean spendShift) {
        this.id = id;
        this.worker = worker;
        this.jobShift = jobShift;
        this.spendShift = spendShift;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getJobShift() {
        return jobShift;
    }

    public void setJobShift(String jobShift) {
        this.jobShift = jobShift;
    }

    public Boolean getSpendShift() {
        return spendShift;
    }

    public void setSpendShift(Boolean spendShift) {
        this.spendShift = spendShift;
    }
}
