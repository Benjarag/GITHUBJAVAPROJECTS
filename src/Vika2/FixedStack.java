package Vika2;

/******************************************************************************
 *  Compilation:  javac FixedStack.java
 *  Execution:    java FixedStack
 *  Dependencies: StdIn.java StdOut.java
 *
 *  Stack of characters implementation with a fixed-size array.
 *
 *  Remark:  bare-bones implementation. Does not do repeated
 *  doubling or null out empty array entries to avoid loitering.
 *
 ******************************************************************************/

 import java.util.Iterator;
 import java.util.NoSuchElementException;
 
 public class FixedStack implements Iterable<Character> {
     private Character[] a;  // holds the items
     private int n;       // number of items in stack
 
     // create an empty stack with given capacity
     public FixedStack(int capacity) {
         a = new Character[capacity];
         n = 0;
     }
 
     public boolean isEmpty() {
         return n == 0;
     }
 
     public boolean isFull() {
         return n == a.length;
     }
 
     public void push(Character item) {
         a[n++] = item;
     }
 
     public Character pop() {
         return a[--n];
     }
 
     public Character peek() {
         return a[n-1];
     }
 
     public Iterator<Character> iterator() {
         return new ReverseArrayIterator();
     }
 
     // an array iterator, in reverse order
     public class ReverseArrayIterator implements Iterator<Character> {
         private int i = n-1;
 
         public boolean hasNext() {
             return i >= 0;
         }
 
         public Character next() {
             if (!hasNext()) throw new NoSuchElementException();
             return a[i--];
         }
     }
 
 }