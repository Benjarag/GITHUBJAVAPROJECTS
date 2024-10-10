package Vika8;

import edu.princeton.cs.algs4.LinearProbingHashST;
import java.util.Map;
import java.util.TreeMap;

public class Test_2_D {
    // Store meetings for each employee using a TreeMap (to act like an interval tree)
    private static LinearProbingHashST<Long, TreeMap<Long, Long>> store = new LinearProbingHashST<>();

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
        // If the end time is not greater than the start time, return empty string
        if (endTime < startTime) {
            return "";
        }

        // Retrieve or initialize the employee's meetings map
        TreeMap<Long, Long> meetings = store.get(s_id);
        if (meetings == null) {
            meetings = new TreeMap<>();
        }

        // Check for conflicts using the floor and ceiling methods in TreeMap
        Map.Entry<Long, Long> prev = meetings.floorEntry(startTime); // Previous meeting
        Map.Entry<Long, Long> next = meetings.ceilingEntry(startTime); // Next meeting

        // Check for overlap with previous or next meeting
        if ((prev != null && prev.getValue() >= startTime) || (next != null && next.getKey() <= endTime)) {
            return "Starfsmadur er thegar a fundi"; // Overlap detected
        }

        // No conflicts, add the new meeting
        meetings.put(startTime, endTime);
        store.put(s_id, meetings); // Update the employee's meeting schedule
        return "Fundur bokadur";
    }
}
