package ru.cft.starterkit.repository.implement;

import ru.cft.starterkit.repository.Worker;

import java.util.ArrayList;

public class WorkerRepositoryImpl implements Worker {

    private Integer id;
    private String shiftName;
    private ArrayList<String> category;
    private Integer phoneNumber;

    public WorkerRepositoryImpl() {
    }

    public String getShiftName() {
        return shiftName;
    }

    public WorkerRepositoryImpl(Integer id, String workerName, ArrayList<String> category, Integer phoneNumber) {
        this.id = id;
        this.shiftName = workerName;
        this.category = category;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
