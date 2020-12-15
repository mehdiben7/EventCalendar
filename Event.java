/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventcalendar;

/**
 *
 * @author dakor
 */
public class Event {

    enum EventType {
        EVENT,
        HOLIDAY_EVENT
    }
    // Properties
    protected EventType eventType;
    public static int counter;
    protected int eventId, duration;
    protected String title;

    // Getters
    public int getEventId() {
        return this.eventId;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getTitle() {
        return this.title;
    }

    // Setters
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Object methods
    public String toString() {
        return "[" + this.eventId + "] " + this.title + ", " + this.duration + " hour";
    }

    // Constructor
    public Event(int duration, String title) {
        this.eventType = EventType.EVENT;
        Event.counter++;
        this.eventId = Event.counter;
        this.duration = duration;
        this.title = title;
    }
}
