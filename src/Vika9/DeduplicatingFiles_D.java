package Vika9;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DeduplicatingFiles_D {
    public static int calculateHash(String sentances) {
        int hash_value = 0;
        for (char c : sentances.toCharArray()) {
            hash_value ^= (int) c;
        }
        return hash_value;
    }

    public static void main(String[] args) {
        while (true) {
            // reading inputs
            int N = StdIn.readInt();
            if (N == 0) {
                break;
            }
            StdIn.readLine();
            String[] sentences = new String[N];
            for (int i = 0; i < N; i++) {
                sentences[i] = StdIn.readLine();
            }

            // initializing a symbol table to map hash values to queues of sentences
            ST<Integer, Queue<String>> hashed_sentance_map = new ST<>();
            // initializing a set to keep track of unduplicated files
            SET<String> unduplicated_files = new SET<>();
            int collisions = 0;

            // processing each sentence
            for (String sentence : sentences) {
                int hash = calculateHash(sentence); // calculate the hash for the file
                unduplicated_files.add(sentence); // add the file to the unduplicated set

                // checking if the hash value already exists in the map
                if (hashed_sentance_map.contains(hash)) {
                    // if so, check for collisions with files already in the queue
                    for (String file_in_map : hashed_sentance_map.get(hash)) {
                        if (!file_in_map.equals(sentence)) {
                            collisions++;
                        }
                    }
                    hashed_sentance_map.get(hash).enqueue(sentence);
                } 
                else {
                    // if hash is new, create a new queue and add the file
                    Queue<String> queue = new Queue<>();
                    queue.enqueue(sentence);
                    hashed_sentance_map.put(hash, queue); // storing the queue in the symbol table
                }
            }

            StdOut.println(unduplicated_files.size() + " " + collisions);
        }
    }
}