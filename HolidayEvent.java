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
public class HolidayEvent extends Event {
    // Properties
    private String subTitle;

    // Getters
    public String getSubTitle() {
        return this.subTitle;
    }

    // Setters
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    // Object methods
    @Override
    public String toString() {
        return "[" + this.eventId + "] " + this.title + ": " + this.subTitle + ", " + this.duration + " hour";
    }

    // Constructors
    public HolidayEvent(int duration, String title, String subTitle) {
        super(duration, title);
        this.eventType = EventType.HOLIDAY_EVENT;
        this.subTitle = subTitle;
    }
}
