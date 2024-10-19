package Vika9;
import java.util.Arrays;

import edu.princeton.cs.algs4.ST;


public class Pyramidasala_C {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        // Inntak
        int n = io.getInt();  // Fjöldi starfsmanna
        int m = io.getInt();  // Fjöldi talna í runu 2

        int[] preorder = new int[n];  // Runa 1
        int[] inorder = new int[m];   // Runa 2
        int[] postorder = new int[n]; // Runa 3

        // Lesum inn runur
        for (int i = 0; i < n; i++) preorder[i] = io.getInt();
        for (int i = 0; i < m; i++) inorder[i] = io.getInt();
        for (int i = 0; i < n; i++) postorder[i] = io.getInt();
        
        int root = -1;
        if (preorder[0] == postorder[n-1]) {
            root = preorder[0];
        }
        ST<Integer, Integer> workersMap = new ST<>();
        int children_from_root = findChildren(root, inorder);
        workersMap.put(root, children_from_root);
        
    }

    private static Integer findChildren(int root, int[] inorder) {
        
        int root_index = findRootIndex(root, inorder);
        int[] left_sub_tree = Arrays.copyOfRange(inorder, 0, root_index); // [1]
        int[] right_sub_tree = Arrays.copyOfRange(inorder, root_index + 1, inorder.length); // [3, 4, 5]
        
        return ;
    }

    private static Integer findRootIndex(int root, int[] inorder) {
        // finds the index at wich the root is located
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                return i;  // return the index where the root is located in the inorder array
            }
        }
        return -1;
    }
}
