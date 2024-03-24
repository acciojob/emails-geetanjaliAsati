package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<Meeting>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        // Sort the meetings based on their end time
        Collections.sort(calendar, (a, b) -> a.getEndTime().compareTo(b.getStartTime()));

        int maxMeetings = 0;
        LocalTime currentTime = LocalTime.MIN;

        // Iterate over the sorted meetings
        for (Meeting meeting : calendar) {
            // Check if the meeting's start time is after the current time
            if (meeting.getStartTime().compareTo(currentTime) >= 0) {
                // Increment the count of maximum meetings attended
                maxMeetings++;
                // Update the current time to the end time of the current meeting
                currentTime = meeting.getEndTime();
            }
        }

        return maxMeetings;
    }
}
