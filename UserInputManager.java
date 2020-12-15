/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventcalendar;

import java.util.Scanner;

/**
 *
 * @author dakor
 */
public class UserInputManager {
    
    
    /**
     * Function Name: retrieveOption
     * 
     * parameters: none
     * 
     * Inquires the user to input the number associated with the operation he/she wants to execute
     * then retrieves the entry from the console
     * 
     * return the selected option number (integer)
     */
    public static int retrieveOption(){
        Scanner sc = new Scanner(System.in);
        int userInput;

        do {
            System.out.println("Please select 1 of the following options...");

            System.out.println("[1] Add an Event \n" +
                    "[2] Delete an Event\n" +
                    "[3] List all Events on a specific date\n" +
                    "[4] List all Events for a specific month\n" +
                    "[0] Exit");
            try {
                userInput = sc.nextInt();
            } catch(Exception e) {
                userInput = -1;
                sc.nextLine();
            }

        } while ((userInput < 0) || (userInput > 4));

        return userInput;
    }
    
    /**
     * Function Name: retrieveDate
     *  
      * parameters: none
     *  
     *  Inquires the user to input a text representing part of a date in the following format: mm/dd
     *  (mm/dd means 2 digits for the month, followed by a '/' symbol followed by 2 digits for the day)
     *  then retrieves the entry from the console
     * 
     *  return an EventDate object (using the entered data)
     */
     public static EventDate retrieveDate(){


         Scanner sc = new Scanner(System.in);

         String userInput;
         int month = 0;
         int day = 0;

         while(month == 0 || day == 0) {
             System.out.println("Please enter the date of the event (mm/dd):");
             userInput = sc.nextLine();

             try {
                 String[] date = userInput.split("/");
                 month = Integer.parseInt(date[0]);
                 day = Integer.parseInt(date[1]);
             } catch(Exception e){
                 System.out.println("Be sure to use the right format (mm/dd)");

             }
         }

         return Calendar.getDate(day, month);
    }

    /**
     * Function Name: retrieveMonth
     * 
     * parameters: none
     * 
     * Inquires the user to input a number representing the month (1-12)
     * then retrieves the entry from the console
     * 
     * return the selected month number (integer)
     */
    public static int retrieveMonth(){
        Scanner sc = new Scanner(System.in);

        int month = 0;

        do {
            System.out.println("Enter the event's month (1-12):");
            try {
                month = sc.nextInt();
            } catch(Exception e) {
                System.out.println("Please be sure to enter a number between 1 and 12");
            }
        } while(month <= 0 || month > 12);

        return month;

    }

    
    /**
     * Function Name: retrieveEventInformation
     * 
     * parameters: none
     * 
     * Inquires the user to input a text for the title of the event
     * then retrieves the entry from the console
     * Inquires the user to input a number for the duration of the event
     * then retrieves the entry from the console
     * 
     * return an Event object (using the entered data)
     */
    public static Event retrieveEventInformation(){
        Scanner sc = new Scanner(System.in);
        int eventDuration = 0;
        Event.EventType eventType;
        String holidaySubtitle = null;

        System.out.println("Please enter the title of the event:");
        String eventTitle = sc.nextLine();

        while(eventDuration <= 0) {
            System.out.println("Please enter the duration of the event (in hours):");

            try {
                eventDuration = sc.nextInt();
                if(eventDuration <= 0) {
                    System.out.println("An event's duration cannot be 0 nor negative");
                }
            } catch(Exception e) {
                System.out.println("Please be sure to enter a positive whole number representing the duration in hours");
                sc.nextLine();
            }
        }

        sc.nextLine(); // Cleaning Scanner's cache

        System.out.println("Is this event a holiday (y/n) ?");
        String userChoice = sc.nextLine();

        while(!userChoice.equals("y") && !userChoice.equals("n")) {
            System.out.println("This is not a valid option, please answer the question using y or n");
            System.out.println("Is this event a holiday (y/n) ?");
            userChoice = sc.nextLine();
        }

        if(userChoice.equals("y")) {
            eventType = Event.EventType.HOLIDAY_EVENT;
            System.out.println("Please enter a subtitle for the holiday:");
            holidaySubtitle = sc.nextLine();
        } else {
            eventType = Event.EventType.EVENT;
        }

        return (eventType == Event.EventType.EVENT) ? new Event(eventDuration, eventTitle) : new HolidayEvent(eventDuration, eventTitle, holidaySubtitle);
        
    }

    /**
     * Function Name: retrieveEventId
     * 
     * parameters: none
     * 
     * Inquires the user to input a number representing the Event Id
     * then retrieves the entry from the console
     * 
     * return the selected Id (integer)
     */
    public static int retrieveEventId(){
        Scanner sc = new Scanner(System.in);

        int eventId = 0;

        while(eventId < Event.counter || eventId > Event.counter) {
            System.out.println("Please enter the event's id:");
            try {
                eventId = sc.nextInt();
            } catch(Exception e) {
                System.out.println("Please be sure to enter a valid ID (recall that ids are positive whole numbers)");
                sc.nextLine();
            }
        }

        return eventId;
		
    }

}
