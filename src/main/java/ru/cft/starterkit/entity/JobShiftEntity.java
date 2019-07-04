package ru.cft.starterkit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class JobShiftEntity {

    private Long id;
    private Date date;
    private String shiftNumber;
    private Boolean editableDay;

    public JobShiftEntity() {
    }

    @JsonIgnore
    private UUID baz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(String shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public Boolean getEditableDay() {
        return editableDay;
    }

    public void setEditableDay(Boolean editableDay) {
        this.editableDay = editableDay;
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
                Objects.equals(editableDay, that.editableDay) &&
                Objects.equals(baz, that.baz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, shiftNumber, editableDay, baz);
    }

    @Override
    public String toString() {
        return "JobShiftEntity{" +
                "id=" + id +
                ", date=" + date +
                ", shiftNumber='" + shiftNumber + '\'' +
                ", editableDay=" + editableDay +
                ", baz=" + baz +
                '}';
    }
}
