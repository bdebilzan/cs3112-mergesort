package cs3112.edu;

import java.util.Random;

//Implements merge sort

public class ProblemOne {	
	//merges two subarrays
	void merge(int[] array, int l, int m, int r)
	{
		//finds sizes of two subarrays to be merged
		int n1 = m - l + 1;
        int n2 = r - m;
        
        //creates temp arrays
        int L[] = new int [n1];
        int R[] = new int [n2];
        
        //copies data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[m + 1+ j];
        
        //merges temp arrays
        
        //initializes index of first and second subarrays
        int i = 0, j = 0;
        
        //initializes index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                array[k] = L[i];
                i++;
            }
            else
            {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        
        //copy remaining elements of L[] if any 
        while (i < n1)
        {
            array[k] = L[i];
            i++;
            k++;
        }
 
        //copy remaining elements of R[] if any 
        while (j < n2)
        {
            array[k] = R[j];
            j++;
            k++;
        }
    }
        
	//sorts array and uses merge fcn
    void sort(int array[], int l, int r)
    {
        if (l < r)
        {
            //finds middle point
            int m = (l+r)/2;
 
            //sorts first and second halves
            sort(array, l, m);
            sort(array , m + 1, r);
 
            //merges sorted halves
            merge(array, l, m, r);
        }
    }
	
	
	public static void main(String args[])
	{
		int[] array1 = new int[10];
		
		//fills array1 with random numbers 1-20
		for(int i = 0; i < array1.length; i++)
		{
			Random rand = new Random();
			array1[i] = 	rand.nextInt(20)+1;
		}

		//prints unsorted list
		System.out.println("Unsorted List:");
		for(int i = 0; i < array1.length; i++)
		{
			System.out.print(array1[i]);
			
			if(i == array1.length - 1)
			{
				System.out.print(".");
			}
			
			else
			{
				System.out.print(", ");
			}
		}	
		
		//calls sort
		ProblemOne ob = new ProblemOne();
		ob.sort(array1, 0, array1.length-1);
		
		//prints sorted list
		System.out.println("");
		System.out.println("");
		System.out.println("Sorted List:");
		for(int i = 0; i < array1.length; i++)
		{
			System.out.print(array1[i]);
			
			if(i == array1.length - 1)
			{
				System.out.print(".");
			}
			
			else
			{
				System.out.print(", ");
			}
		}	
	}
}
