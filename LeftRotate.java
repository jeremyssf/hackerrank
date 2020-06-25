/*
* Writing some Java problems from HackerRank with and to teach
* my son Yuzuki Fujiwara at the high school level in beginner programming
* by jss
  Sample Input
  5 4
  1 2 3 4 5
  
  Sample Output
  5 1 2 3 4
  
  This is more or less an exercise to practice using arrays.
  There are couple of ways to do this, this being probably one of the simpler ways by
  calling a method to shift the array elements one at a time, and d times.
*/

import java.io.*;
import java.math.*;
import java.util.Scanner;
import java.util.Arrays;

/*
* Calling this one LeftRot for Left Rotation of an Array
*
*    Sample Input
*    5 4
*    1 2 3 4 5
*
*    after 5 left rotations
*
*    Sample Output
*    5 1 2 3 4
*    
*    inputs "n" integers, "d" operations, and the array
*/

public class LeftRotate {
   
    public static int[] LeftRotate( int[] array, int rotations ){
        // do solution here
        int size = array.length;
        int[] result = array;

        for( int i = 0; i < rotations; i++){
            leftRotOne(result, size);
        }
        return result;
            
        
    }

    static void leftRotOne( int[] array, int size ){
        int temp = array[0];
        for (int i = 0; i < size-1; i++ ){
            array[i] = array[i+1];
        }
        array[size-1] = temp;

    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int d = scan.nextInt();
        int[] array = new int[n];
        for( int i = 0; i < n; i++ ){
            array[i] = scan.nextInt();
        }
        
        int[] answer = new int[n];
        answer = LeftRotate(array, d);
        
        for (int i = 0; i < n; i++)
        System.out.print(answer[i]+" ");
    }
    
}
