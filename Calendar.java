/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the ed1itor.
 */
package eventcalendar;

import java.util.ArrayList;

/**
 *
 * @author dakor
 */
public class Calendar {

    public static ArrayList<EventDate> dateList = new ArrayList<>();

    public static EventDate getDate(int day, int month) {
        EventDate eventDateReturned = null;


        for(EventDate eventDate : Calendar.dateList) {
            if((eventDate.getDay() == day) && (eventDate.getMonth() == month)) {
                eventDateReturned = eventDate;

            }
        }

        if(eventDateReturned == null) {
            eventDateReturned = new EventDate(day, month);
        }

        return eventDateReturned;
    }

    public static ArrayList<EventDate> getMonth(int month) {
        ArrayList<EventDate> dateListReturned = new ArrayList<>();

        for(EventDate eventDate : Calendar.dateList) {
            if(eventDate.getMonth() == month) {
                dateListReturned.add(eventDate);
            }
        }

        return dateListReturned;
    }

    public static void addDate(EventDate eventDate) {
        Calendar.dateList.add(eventDate);
    }


}
