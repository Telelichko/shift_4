package ru.cft.starterkit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class JobShiftEntity {

    private Integer id;
    private Long date;
    private Integer workerID;
    private String status;

    public JobShiftEntity() {
    }

    @JsonIgnore
    private UUID baz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getWorkerID() {
        return workerID;
    }

    public void setWorkerID(Integer workerID) {
        this.workerID = workerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getBaz() {
        return baz;
    }

    public void setBaz(UUID baz) {
        this.baz = baz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobShiftEntity that = (JobShiftEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(workerID, that.workerID) &&
                Objects.equals(status, that.status) &&
                Objects.equals(baz, that.baz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, workerID, status, baz);
    }

    @Override
    public String toString() {
        return "JobShiftEntity{" +
                "id=" + id +
                ", date=" + date +
                ", workerID=" + workerID +
                ", status='" + status + '\'' +
                ", baz=" + baz +
                '}';
    }
}
