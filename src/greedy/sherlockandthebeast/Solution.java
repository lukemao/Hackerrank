package greedy.sherlockandthebeast;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        //String d3 = "";
        //String d5 = "";
        StringBuffer d3 = new StringBuffer();
        StringBuffer d5 = new StringBuffer();
        for(int i =0 ;i < tc; i++){
            //3 = "";
            //d5 = "";
            d3 = new StringBuffer();
            d5 = new StringBuffer();
            int n = sc.nextInt();
            int j =n;
            String num = "-1";
            while(j>=0){
                d3 = new StringBuffer();
                d5 = new StringBuffer();
                if(j%3 == 0 && (n-j)%5==0){
                        int k =0;
                        for(; k<j; k++){
                            d5.append("5");
                        }
                        for(; k<n; k++){
                            d3.append("3");
                        }
                        break;
                }
                j--;
                
            }
            //System.out.println("d3= "+d3);
            if(d3.length() == 0 && d5.length() == 0){
                System.out.println("-1");
                
            }else{
                System.out.println(d5.toString()+""+d3.toString());
            }
            
        }
        sc.close();
    }
}