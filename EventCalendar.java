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
public class EventCalendar {
    public static void addEvent() {
        EventDate eventDate = UserInputManager.retrieveDate();
        Event event = UserInputManager.retrieveEventInformation();

        eventDate.addEvent(event);

        System.out.println("The following event was successfully created:");
        System.out.println(event.toString());
        System.out.println("On " + eventDate.toString());
    }

    public static void deleteEvent() {
        EventDate eventDate = UserInputManager.retrieveDate();
        eventDate.displayEvents();
        if(eventDate.hasEventScheduled()) {
            int eventId = UserInputManager.retrieveEventId();

            Event eventDeleted = eventDate.getEvent(eventId);
            eventDate.removeEvent(eventId);

            System.out.println("The following event was successfully deleted:");
            System.out.println(eventDeleted.toString());
            System.out.println("On " + eventDate.toString());
        }

    }

    public static void listAllEventsForDate() {
        EventDate eventDate = UserInputManager.retrieveDate();
        eventDate.displayEvents();
    }

    public static void listAllEventsForMonth() {
        int month = UserInputManager.retrieveMonth();

        for(EventDate eventDate : Calendar.getMonth(month)) {
            eventDate.displayEvents();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		boolean userIsDone = false;

		while(!userIsDone) {
		    int userOption = UserInputManager.retrieveOption();

		    switch(userOption) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    deleteEvent();
                    break;
                case 3:
                    listAllEventsForDate();
                    break;
                case 4:
                    listAllEventsForMonth();
                    break;
                case 0:
                    userIsDone = true;
                    break;
                default:
            }
        }
    }
    
}
