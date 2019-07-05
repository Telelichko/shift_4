package ru.cft.starterkit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class WorkerEntity {
    private Integer id;
    private String workerName;
    private String category;
    private String phoneNumber;

    public WorkerEntity() {
    }

    @JsonIgnore
    private UUID baz;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getBaz() {
        return baz;
    }

    public void setBaz(UUID baz) {
        this.baz = baz;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workerName, category, phoneNumber, baz);
    }


    @Override
    public String toString() {
        return "WorkerEntity{" +
                "id=" + id +
                ", workerName='" + workerName + '\'' +
                ", category='" + category + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", baz=" + baz +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(workerName, that.workerName) &&
                Objects.equals(category, that.category) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(baz, that.baz);
    }

}
