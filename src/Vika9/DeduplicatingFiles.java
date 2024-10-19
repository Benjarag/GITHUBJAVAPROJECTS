package Vika9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeduplicatingFiles {

    // Simple XOR hash function for a file's content.
    public static int computeHash(String fileContent) {
        int hashValue = 0;
        for (int i = 0; i < fileContent.length(); i++) {
            hashValue ^= fileContent.charAt(i);  // XOR each character's ASCII value
        }
        return hashValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Read the number of files
            String line = scanner.nextLine().trim();
            if (line.equals("0")) {
                break;  // End of input when "0" is entered
            }

            int numFiles = Integer.parseInt(line);  // Convert to integer

            // Store file contents and their hashes
            List<String> fileContents = new ArrayList<>();
            List<Integer> fileHashes = new ArrayList<>();

            // Read all files for this test case
            for (int i = 0; i < numFiles; i++) {
                String fileContent = scanner.nextLine().trim().replace(" ", "");
                fileContents.add(fileContent);
                fileHashes.add(computeHash(fileContent));  // Compute and store the hash
            }

            int uniqueFileCount = 0;
            int collisionCount = 0;

            // Compare every pair of files (n(n-1)/2 comparisons)
            for (int i = 0; i < numFiles; i++) {
                boolean isUnique = true;

                for (int j = i + 1; j < numFiles; j++) {
                    // If two files have the same hash, compare their contents
                    if (fileHashes.get(i).equals(fileHashes.get(j))) {
                        if (!fileContents.get(i).equals(fileContents.get(j))) {
                            collisionCount++;  // Increment collision count for different file contents
                        } else {
                            isUnique = false;  // If contents are identical, it's not unique
                        }
                    }
                }

                // If no collisions found for this file, count it as unique
                if (isUnique) {
                    uniqueFileCount++;
                }
            }

            // Output the results for the current test case
            System.out.println(uniqueFileCount + " " + collisionCount);
        }

        scanner.close();
    }
}