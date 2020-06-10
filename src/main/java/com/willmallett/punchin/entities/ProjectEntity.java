package com.willmallett.punchin.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class ProjectEntity {
    private String id;
    private String title;
    private String color;
    private int punchIns;
    private String totalTime;
    private double totalPay;
    private String notes;

    @Embedded
    private List<TimeEntry> timeEntries;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
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

    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    public void setTimeEntries(List<TimeEntry> timeEntries) {
        this.timeEntries = timeEntries;
    }
}
