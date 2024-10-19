package Vika9;

import edu.princeton.cs.algs4.ST;

public class LargestZeroSumSubarray {

    public static int[] findLargestZeroSumSubarray(int[] A) {
        // ST frá Princeton algs4 pakkann til að geyma prefix summur og indexa
        ST<Integer, Integer> prefixSumMap = new ST<>();
        int prefixSum = 0;
        int maxLen = 0;  // Lengd stærsta undirfylkisins sem við höfum fundið
        int startIndex = -1;  // Upphafsstaðsetning þess undirfylkis

        // Förum í gegnum öll stök í fylkinu
        for (int i = 0; i < A.length; i++) {
            // Bætum A[i] við núverandi prefix summu
            prefixSum += A[i];

            // Athugum hvort summan frá byrjun til nú sé 0
            if (prefixSum == 0) {
                maxLen = i + 1;
                startIndex = 0;
            }

            // Athugum hvort þessi prefix summa hefur komið áður í ST
            if (prefixSumMap.contains(prefixSum)) {
                // Finnum lengdina á undirfylkinu sem hefur summu 0
                int subarrayLen = i - prefixSumMap.get(prefixSum);
                if (subarrayLen > maxLen) {
                    maxLen = subarrayLen;
                    startIndex = prefixSumMap.get(prefixSum) + 1;
                }
            } else {
                // Setjum prefix summuna og indexið inn í ST
                prefixSumMap.put(prefixSum, i);
            }
        }

        // Prentum út stærsta undirfylkið með summu 0
        if (maxLen > 0) {
            System.out.print("Stærsta undirfylkið með summu 0: ");
            for (int i = startIndex; i < startIndex + maxLen; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();  // Færum niður á næstu línu
        } else {
            System.out.println("Ekkert undirfylki fannst með summu 0.");
        }

        // Skilum lengd stærsta undirfylkisins og upphafsstað þess
        return new int[]{maxLen, startIndex};
    }

    public static void main(String[] args) {
        // Testum með fast fylki
        int[] A = {3, 4};

        // Finnum stærsta undirfylkið með summu 0
        findLargestZeroSumSubarray(A);
    }
}
