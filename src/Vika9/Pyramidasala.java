package Vika9;

import edu.princeton.cs.algs4.ST;

public class Pyramidasala {
    private static int[] edgeTo;  // Array to track connections
    private static boolean[] visited;  // Array to track visited nodes

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        
        // Input
        int n = io.getInt();  // Number of employees
        int m = io.getInt();  // Number of elements in inorder
    
        int[] preorder = new int[n];  // Preorder
        int[] inorder = new int[m];    // Inorder
    
        // Read in arrays
        for (int i = 0; i < n; i++) preorder[i] = io.getInt();
        for (int i = 0; i < m; i++) inorder[i] = io.getInt();
    
        // Initialize the edgeTo and visited arrays
        edgeTo = new int[n + 1];  // Assuming employees are indexed from 1 to n
        visited = new boolean[n + 1];
    
        // Call function to find subordinates
        ST<Integer, StringBuilder> workersMap = new ST<>();
        buildHierarchy(preorder, inorder, workersMap, 0, n - 1, 0, m - 1);
    
        // Perform DFS to print the hierarchy correctly
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = workersMap.get(i);
            if (sb != null) {
                System.out.print(i + ":");  // Print the employee number
                dfs(i, workersMap);  // Perform DFS for the current employee
                // Print only the direct children
                System.out.println(sb.toString().trim());
            } else {
                System.out.println(i + ":");
            }
        }
    }

    private static void dfs(int v, ST<Integer, StringBuilder> workersMap) {
        visited[v] = true;  // Mark the current node as visited
        StringBuilder sb = workersMap.get(v);
        if (sb == null) return;  // No children to process
    
        String[] children = sb.toString().trim().split(" ");
        StringBuilder directChildren = new StringBuilder();  // To store direct children only
        for (String child : children) {
            // Check if child is not empty
            if (child.isEmpty()) continue; // Skip empty strings
    
            int w = Integer.parseInt(child);
            if (!visited[w]) {  // If not visited, perform DFS
                edgeTo[w] = v;  // Set the parent for the current child
                directChildren.append(w).append(" ");  // Add direct child to output
                dfs(w, workersMap);  // Recursively call DFS on the child
            }
        }
        // Update the StringBuilder for direct children of the parent
        workersMap.put(v, directChildren);
    }
    
    private static void buildHierarchy(int[] preorder, int[] inorder, 
                                   ST<Integer, StringBuilder> workersMap,
                                   int preStart, int preEnd, 
                                   int inStart, int inEnd) {
        // Base case: if indices are out of bounds
        if (preStart > preEnd || inStart > inEnd) return;

        int root = preorder[preStart];
        StringBuilder sb = new StringBuilder();

        // Find the index of the root in the inorder array
        int rootIndex = findRootIndex(root, inorder, inStart, inEnd);
        if (rootIndex == -1) return; // Root not found, exit

        // Left subtree exists
        if (rootIndex > inStart) {
            for (int i = inStart; i < rootIndex; i++) {
                sb.append(inorder[i]).append(" ");
            }
        }

        // Right subtree exists
        if (rootIndex < inEnd) {
            for (int i = rootIndex + 1; i <= inEnd; i++) {
                sb.append(inorder[i]).append(" ");
            }
        }

        // Store the children in the workersMap
        workersMap.put(root, sb);

        // Recursively build the left and right subtrees
        buildHierarchy(preorder, inorder, workersMap,
                        preStart + 1, preStart + (rootIndex - inStart), inStart, rootIndex - 1);

        buildHierarchy(preorder, inorder, workersMap,
                        preStart + (rootIndex - inStart) + 1, preEnd, rootIndex + 1, inEnd);
    }

    private static int findRootIndex(int root, int[] inorder, int inStart, int inEnd) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root) {
                return i;  // return the index where the root is located in the inorder array
            }
        }
        return -1;
    }
}
