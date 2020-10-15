package com.app.blackteam.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.UUID;

@Entity // This tells Hibernate to make a table out of this class
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID timeSlotID;

    private Time startTime;

    private Time endTime;

    public TimeSlot() {
    }

    public TimeSlot(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getTimeSlotID() {
        return timeSlotID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
