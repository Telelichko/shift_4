package ru.cft.starterkit.repository.implement;

import ru.cft.starterkit.repository.JobShift;

import java.util.Date;

public class JobShiftRepositoryImpl implements JobShift {

    private Integer id;
    private Date date;
    private String workerName;
    private Boolean editableDay;

    public JobShiftRepositoryImpl() {
    }

    public JobShiftRepositoryImpl(Integer id, Date date, String workerName, Boolean editableDay) {
        this.id = id;
        this.date = date;
        this.workerName = workerName;
        this.editableDay = editableDay;
    }

    public String getWorkerName() {
        return workerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Boolean getEditableDay() {
        return editableDay;
    }

    public void setEditableDay(Boolean editableDay) {
        this.editableDay = editableDay;
    }
}
