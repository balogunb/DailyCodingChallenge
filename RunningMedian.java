/**
Daily Coding Problem: Problem #33 [Easy]

This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

**/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.Scanner;
import java.util.*;


public class RunningMedian{
	 public static void main(String args[]){
	 	int [] seq = {2, 1, 5, 7, 2, 0, 5};
        calculateRunningMedian(seq);
	 }




	 //Use binary tree to optimize 
	 public static void calculateRunningMedian(int[] seq){
	 	ArrayList<Integer> curr = new ArrayList<Integer>();


	 	// loop through list
	 	for(int i = 0; i < seq.length; i++){
	 		sort(i,seq[i], curr);
	 		System.out.println(getMedian(i,curr));

	 	}


	 }


	  public static double getMedian(int i, ArrayList<Integer> newA){
	  	if (i == 0) return newA.get(i);
	  	else{
	  		if((i+1) % 2 != 0) return (double)newA.get(i/2);
	  		else{
	  			double a = (double) (newA.get(i/2));
	  			double b = (double) (newA.get((i+1)/2));
	  			return (double) (a+b)/2;
	  		} 
	  	}
	  	

	 } 

	 /***
	 add sorted where j is the int to be added and i is the current index
	 **/
	 public static void sort(int i, int j, ArrayList<Integer> newA){
	 	if(i == 0 ){
	 		newA.add(j);
	 	} 

	 	else{
	 		for(int k = 0 ; k < i; k++){
	 			if(j <= newA.get(k)){
	 				newA.add(k,j);
	 				return;
	 			} 
	 		}
	 		newA.add(j);//get here only if greater than everything
	 	}
	 }   
}


