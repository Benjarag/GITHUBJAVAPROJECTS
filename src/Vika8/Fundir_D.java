package Vika8;

import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.RedBlackBST;
import java.util.NoSuchElementException;

public class Fundir_D {
    // Store meetings for each employee using a RedBlackBST
    private static LinearProbingHashST<Long, RedBlackBST<Long, Long>> store = new LinearProbingHashST<>();

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        int q_number_of_queries = io.getInt();
        for (int i = 0; i < q_number_of_queries; i++) {
            Long s_id = io.getLong();
            Long t1_time_starts = io.getLong();
            Long t2_time_ends = io.getLong();
            String result = scheduleMeeting(s_id, t1_time_starts, t2_time_ends);
            io.println(result);
        }
        io.close();
    }

    // Method to schedule a meeting
    private static String scheduleMeeting(Long s_id, Long startTime, Long endTime) {
        // Validate time range
        if (endTime < startTime) {
            return "Invalid time range"; // Return if end time is not greater than start time
        }

        // Retrieve or initialize the employee's meetings RedBlackBST
        RedBlackBST<Long, Long> meetings = store.get(s_id);
        if (meetings == null) {
            meetings = new RedBlackBST<>();
        }

        // Check for conflicts
        boolean hasConflict = false;

        // Use try-catch to avoid NoSuchElementException when using floor and ceiling
        Long prevStart = null;
        Long nextStart = null;

        try {
            // Check for overlapping meetings
            prevStart = meetings.floor(startTime); // Previous meeting start time
            if (prevStart != null) {
                Long prevEnd = meetings.get(prevStart); // End time of the previous meeting
                if (prevEnd != null && prevEnd >= startTime) {
                    hasConflict = true; // Overlap detected
                }
            }
        } catch (NoSuchElementException e) {
            // Do nothing, prevStart is already null
        }

        try {
            nextStart = meetings.ceiling(startTime); // Next meeting start time
            if (nextStart != null && nextStart <= endTime) {
                hasConflict = true; // Overlap detected
            }
        } catch (NoSuchElementException e) {
            // Do nothing, nextStart is already null
        }

        // If there's a conflict, return an appropriate message
        if (hasConflict) {
            return "Starfsmadur er thegar a fundi"; // Overlap detected
        }

        // No conflicts, add the new meeting
        meetings.put(startTime, endTime);
        store.put(s_id, meetings); // Update the employee's meeting schedule
        return "Fundur bokadur"; // Meeting scheduled successfully
    }
}
