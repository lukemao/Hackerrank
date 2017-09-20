package greedy.priyankaAndToys;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] w = new int[N];
        for(int i =0; i<N; i++){
            w[i] = sc.nextInt();
        }
        Arrays.sort(w);
        
        int count = 0;
        int head = -1;
        
        for(int i =0; i<N; i++){
            if(head<0) {
                head = w[0];
                count++;
            }else{
                if(w[i]>head+4){
                    count++;
                    head = w[i];
                }
            }
            
            
        }
        System.out.println(count);
        sc.close();
    }
}