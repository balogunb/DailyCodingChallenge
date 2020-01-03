
/**
 * Write a description of class df here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


/*
Daily Coding Problem: Problem #29 [Easy]


Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.

*/
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

public class EncoderDecoder{
      public static void main(String args[]){  
        Scanner reader = new Scanner(System.in);  
        String s = reader.next();	
        String r = encode(s);
        System.out.println("Encoded " + r);
        System.out.println("Decoded " + decode(r));
    }

    public static String encode(String s){
        char [] arr = s.toCharArray();
        char [] soln = new char [arr.length* 2];
        int j = 0; //current index
        int c = 0; //current char count
        int i = 0;
        while(i < arr.length){			
            char curr = arr[i];			
            c = 0;			
            while (curr == arr[i]){
                i++;
                c++;
                if(i == arr.length)break;
            }	
            //System.out.println(c);
            soln[j++] = (char)(c+'0');
            soln[j++] = curr;			
            //i++;
        }		
        String result = new String(soln);
        return result;	
    }

    public static String decode(String s){
        char [] arr = s.toCharArray();
        List<Character> soln = new ArrayList<Character>();
        
        int i = 0;
        while(i < arr.length){  
            int count = Character.getNumericValue(arr[i]);
            for(int j = 0; j < count;j++ ){
                soln.add(arr[i+1]);
            }
            i += 2;
        }       

        char[] resultArr = new char[soln.size()];
        
        for(int j = 0; j < soln.size();j++){
            resultArr[j] = (char)soln.get(j);
        }
        String result = new String(resultArr);
        return result; 
    }
}





