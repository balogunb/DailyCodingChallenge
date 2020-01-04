/**
Daily Coding Problem: Problem #31 [Easy]


Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between "kitten"and "sitting"is three: substitute the "k" for "s", substitute the "e"for "i", and append a "g".

Given two strings, compute the edit distance between them.

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


public class EditDist{
      public static void main(String args[]){  
        Scanner reader = new Scanner(System.in);  
        String s = reader.next();
        String d = reader.next();
        System.out.println(calculateDist(s,d));
     
    }

    public static int calculateDist(String s, String t){
        //char [] a = s.toCharArray();
        //char [] b = t.toCharArray();
        int s1Len = s.length();
        int s2Len = t.length();
        int [][] soln = new int[s1Len +1 ][s2Len + 1];
        

        for(int i = 0; i < s1Len + 1; i++){
            soln[i][0] = i;
        }
        for(int i = 0; i < s2Len + 1; i++){
            soln[0][i] = i;
        }


        for(int i = 1; i <= s1Len ; i++){
        	for(int j = 1; j <= s2Len ; j++){
        		if(s.charAt(i -1) == t.charAt(j-1)){
                    soln[i][j] = soln[i-1][j-1];
                } 
        		else{
                    int min = Math.min(soln[i][j-1],soln[i-1][j] );
                    soln[i][j] = Math.min(soln[i-1][j-1], min) + 1;
                } 
        	}
        }
      return soln [s1Len][s2Len];
    }


}
