package com.willmallett.punchin.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tbl_time_entry")
public class TimeEntry {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "time_entry_id", updatable = false, nullable = false)
    private String id;
    private String date;
    private String timeStart;
    private String timeEnd;
    private int timeEntryTotal;
    private double timeEntryPay;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getTimeEntryTotal() {
        return timeEntryTotal;
    }

    public void setTimeEntryTotal(int timeEntryTotal) {
        this.timeEntryTotal = timeEntryTotal;
    }

    public double getTimeEntryPay() {
        return timeEntryPay;
    }

    public void setTimeEntryPay(double timeEntryPay) {
        this.timeEntryPay = timeEntryPay;
    }
}
