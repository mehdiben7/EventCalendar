/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventcalendar;

import java.util.ArrayList;

/**
 *
 * @author dakor
 */
public class EventDate implements IDate {

    // Properties
    private int day, month, year;
    private ArrayList<Event> eventList;

    // Getters
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public Event getEvent(int eventId) {
        Event eventReturned = null;

        for(Event event : this.eventList) {

            if(event.getEventId() == eventId) {
                eventReturned = event;
            }
        }

        return eventReturned;
    }

    // Setters
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }


    // Object methods
    @Override
    public void addEvent(Event e) {
        this.eventList.add(e);
    }

    @Override
    public void displayEvents() {

        System.out.println("Events for " + this.toString() + ":");
        if(this.eventList.isEmpty()) {
            System.out.println("There is no event scheduled on " + this.toString());
        } else {
            for(Event event: this.eventList) {
                System.out.println(event.toString());
            }
        }

    }

    @Override
    public void removeEvent(int eventId) {
        this.eventList.remove(this.getEvent(eventId));
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    public boolean hasEventScheduled() {
        return !this.eventList.isEmpty();
    }

    // Constructors
    public EventDate(int day, int month) {
        // For the sake of the project all the date's year are set to 2020
        this.eventList = new ArrayList<>();
        this.day = day;
        this.month = month;
        this.year = 2020;
        Calendar.addDate(this);
    }
}
