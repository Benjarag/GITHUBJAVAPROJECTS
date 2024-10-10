package Vika8;

import edu.princeton.cs.algs4.LinearProbingHashST;
import java.util.ArrayList;
import java.util.List;

public class Fundir_D {
    private static LinearProbingHashST<Long, List<Long[]>> store = new LinearProbingHashST<>(); // Store meetings for each employee

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

    private static String scheduleMeeting(Long s_id, Long startTime, Long endTime) {
        // end time is not greater than the start time, return empty string
        if (endTime <= startTime) {
            return "";
        }

        // retrieve or initialize the employee's list of meetings
        List<Long[]> meetings = store.get(s_id);
        if (meetings == null) {
            meetings = new ArrayList<>(); // initializing if the employee has no meetings
        }

        // check for conflicts with all meetings for the specific employee
        for (Long[] times : meetings) {
            Long storedStartTime = times[0];
            Long storedEndTime = times[1];

            // check for all potential time conflicts
            if (startTime.equals(storedStartTime) || startTime.equals(storedEndTime) ||
                endTime.equals(storedStartTime) || endTime.equals(storedEndTime) ||
                (startTime < storedEndTime && endTime > storedStartTime)) {
                return "Starfsmadur er thegar a fundi"; // Overlap or exact match detected
            }
        }

        // if no conflicts, add new meeting to the schedule
        meetings.add(new Long[]{startTime, endTime});
        store.put(s_id, meetings); // updating the schedule for this employee
        return "Fundur bokadur";
    }
}
