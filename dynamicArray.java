/*
* writing from scratch to practice the Scanner element and not use the client
* by Jeremy Sung
*
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/* Problem from HackerRank called Dynamic Array
* can be found at https://www.hackerrank.com/challenges/dynamic-array/problem
* Essentially, slightly cryptic instructions that forces the individual to be confortable 
* with working with Lists and ArrayLists which have flexible size
* The goal is more or less to force practice with array syntax, so the language you code it matters
* input is N Q, Q queries, where N is number of sequences, Q is number of queres, and the actual list of 
* integers as queries
*/

public class DynamicArray{
    // let's declare what they ask for which is a list of sequences, or a list of lists called "seqList"
    List<List<Integer>> seqList = new ArrayList<List<Integer>>();
    
    // also let's declare the sequence object that will populate the actual sequence list
    // keep in mind we are using an existing data object in Java called "ArrayList" which is why 
    // we have the "()" brackets
    List<Integer> seq = new ArrayList<Integer>();
    
    // we also create a variable called lastAnswer initialized as 0 as requested.
    int lastAnswer = 0;
    
    // we then create an initialization block common in Java and create the structre listed given N
    // for each N, we add an empty sequence to the object, seqList with the "add()" function from Java
    public DynamicArray(int N){
        for ( int i = 0; i < N; i++ ){
            seq = new ArrayList<Integer>();
            seqList.add(seq);
        }
    }

    // execution part of the code goes here, including reading inputs and output final answer
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int queryCount = scan.nextInt();
        
        // create our data structure Dynamic Array by initializing of N size
        DynamicArray da = new DynamicArray(N);
        // begin reading the queries
        while(queryCount --> 0){
            int qType = scan.nextInt();
            int xval = scan.nextInt();
            int yval = scan.nextInt();
            
            // using switch here as it is more readable, that depends on the query type
            // instead of writing all the code in the block here, I split it to an append and print function
            // that is pushes through the x y and N
            
            // first is the append, which requires the first query int to be 1
            switch(qType){
                case 1:
                da.append( xval, yval, N );
                break;

            // second is the print, which requires the first query int to be 2
                case 2:
                da.print( xval, yval, N );
                break;
            }

        }
        scan.close();
    }

    // here is the append function, caculates the index
    // simply grabs the sequence and adds the yval to the end
    private void append( int xval, int yval, int N){
        int index = (xval ^ lastAnswer) % N;
        seq = seqList.get(index);
        seq.add(yval);
    }
    
    // here is the print function, caculates the index
    // simply grabs the sequence, grabs a specific element, then replaces lastAnswer with it and prints
    private void print( int xval, int yval, int N ){
        int index = (xval ^ lastAnswer) % N;
        seq = seqList.get(index);
        int value = yval % seq.size();
        lastAnswer = seq.get(value);
        System.out.println(lastAnswer);
    }

}
