package com.willmallett.punchin.entities;

import javax.persistence.Embeddable;

@Embeddable
public class TimeEntry {
    private String id;
    private String date;
    private String timeStart;
    private String timeEnd;
    private String timeEntryTotal;
    private double timeEntryPay;

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

    public String getTimeEntryTotal() {
        return timeEntryTotal;
    }

    public void setTimeEntryTotal(String timeEntryTotal) {
        this.timeEntryTotal = timeEntryTotal;
    }

    public double getTimeEntryPay() {
        return timeEntryPay;
    }

    public void setTimeEntryPay(double timeEntryPay) {
        this.timeEntryPay = timeEntryPay;
    }
}
