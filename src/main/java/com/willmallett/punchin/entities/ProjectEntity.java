package com.willmallett.punchin.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_project")
public class ProjectEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "project_id", updatable = false, nullable = false)
    private UUID id;
    private String title;
    private String color;
    private int punchIns;
    private int totalTime;
    private double totalPay;
    private String notes;
    private double payRate;

    @OneToMany(
        fetch= FetchType.LAZY,
        orphanRemoval = true,
        cascade = {CascadeType.ALL},
        mappedBy = "project"
    )
    @JsonManagedReference
    private List<TimeEntry> timeEntries;

    public void addTimeEntry(TimeEntry timeEntry) {
        timeEntries.add(timeEntry);
        timeEntry.setProject(this);
    }

    public void deleteTimeEntry(UUID id) {
        timeEntries.remove(getTimeEntryById(id));
    }

    public TimeEntry getTimeEntryById(UUID id) {
        return getTimeEntries().stream()
            .filter(entry -> entry.getId().equals(id))
            .findAny().orElse(null);
    }

    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    public void setTimeEntries(List<TimeEntry> timeEntries) {
        this.timeEntries = timeEntries;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPunchIns() {
        return punchIns;
    }

    public void setPunchIns(int punchIns) {
        this.punchIns = punchIns;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
}
