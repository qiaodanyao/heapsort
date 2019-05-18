package test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class heap 
{	
	public static void sort(Comparable [] a)
	{
		int n=a.length;
		for (int k =n/2; k >= 1; k--)
			sink(a, k, n);
		while (n > 1)
		{
			exch(a, 1, n--);//
			sink(a, 1, n);
		}
	}
	
	private static void sink(Comparable[] a, int k, int n) 
	{
        while (2*k <= n)
        {
            int j = 2*k;
            if (j < n && less(a, j, j+1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
     }
        
     private static boolean less(Comparable[] a, int i, int j) 
     {
            return a[i-1].compareTo(a[j-1]) < 0;
     }
     
     private static void exch(Object[] a, int i, int j) {
         Object swap = a[i-1];
         a[i-1] = a[j-1];
         a[j-1] = swap;
     }
     
     private static void show(Comparable[] a)
     {
         for (int i = 0; i < a.length; i++)
         {
             StdOut.println(a[i]);
         }
     }
     
     public static void main(String[] args) {
         String[] a = StdIn.readAllStrings();
         heap.sort(a);
         show(a);
         System.out.println("123455");
     }


}
