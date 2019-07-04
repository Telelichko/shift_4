package ru.cft.starterkit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class WorkerEntity {
    private Long id;
    private String workerName;
    private String category;
    private Integer phoneNumber;

    public WorkerEntity() {
    }

    @JsonIgnore
    private UUID baz;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
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


//    public Long getId(long incrementAndGet) { // Удалить при необходимости
//        return null;
//    }
}
