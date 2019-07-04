package ru.cft.starterkit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class JobShiftEntity {

    private Integer id;
    private Date date;
    private Integer workerID;
    private String shiftNumber;
    private Boolean status;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getWorkerID() {
        return workerID;
    }

    public void setWorkerID(Integer workerID) {
        this.workerID = workerID;
    }

    public String getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(String shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
                Objects.equals(shiftNumber, that.shiftNumber) &&
                Objects.equals(status, that.status) &&
                Objects.equals(baz, that.baz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, shiftNumber, status, baz);
    }

    @Override
    public String toString() {
        return "JobShiftEntity{" +
                "id=" + id +
                ", date=" + date +
                ", shiftNumber='" + shiftNumber + '\'' +
                ", status=" + status +
                ", baz=" + baz +
                '}';
    }
}
