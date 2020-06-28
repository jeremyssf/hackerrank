/*
* Writing some Java problems from HackerRank with and to teach
* my son Yuzuki Fujiwara at the high school level in beginner programming
* by jss
    Sample Input
    5 3
    1 2 100
    2 5 100
    3 4 100
    
    Sample Output
    200
    
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Arrays;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {    
        long[] array = new long[n];
        int a, b, k;
        int m = queries.length;

        // using prefix sum logic we reduce the queries addition to O(1) time to 
        // improve efficiency, and calculate the summation at the end
        for( int i = 0; i < queries.length; i++ ){
            // since input is 1-indexed, we remove 1 to match 0-indexed java arrays
            a = queries[i][0] - 1;
            b = queries[i][1] - 1;
            // k is the value to add
            k = queries[i][2];

            // using the prefix sum theory, we store the most important information
            // index a gets the value
            array[a] = array[a] + k;
            // we will also mark the point where the addition stops with -k such that 
            // the cumulative summation will cancel with the added k giving 0
            // It is also important to note that we only do this if b+1 is not the end
            // value, thus checking if b+1 < size of array
            if( b+1 < n)
            array[b+1] = array[b+1] - k;
        }
        // with the arrays we are now going to calculate the sums and store the max
        long max = 0; 
        long sum = 0;
        for( int i = 0; i < array.length; i++ ){
            sum = array[i] + sum;
            if( sum > max)
            max = sum;
        }
        return max;
    }
    
    // this code is from hackerrank and not written by us
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
