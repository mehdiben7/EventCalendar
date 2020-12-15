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
public interface IDate {

    /*
    * Add an Event object to the event list
    */
    void addEvent(Event e);

    /*
    * Display each Event Object instance in the event list
    */
    void displayEvents();

    /*
    * Remove the Event object whose eventId property matches the eventId parameter
    */
    void removeEvent(int eventId);
    
}
