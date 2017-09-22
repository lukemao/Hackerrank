package heap.findtheRunningMedian;

import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        PriorityQueue<Integer> small = new PriorityQueue<>((k, l) -> l-k);
        PriorityQueue<Integer> large = new PriorityQueue<>();
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            // decide where to put a new number
            // small and large size should always balance (equal size, or large has one more if total current size is odd)
            // when a new number come, 
            // compare with the peek of both queue, if it smaller than the small peek add to small queue, 
            // and then poll the peek off the queue add it to large
            // similar to large
            // so peek of both queue will be the middle two numbers of both queue
            if(small.size() == 0 && large.size() != 0){
                if(large.peek()<a[a_i]){
                    small.add(large.poll());
                    large.add(a[a_i]);
                }else{
                    small.add(a[a_i]);
                }
                System.out.println(df.format((small.peek()+large.peek())/2.0));
            }else if(large.size() == 0 && small.size() == 0){
                large.add(a[a_i]);
                System.out.println(df.format(a[a_i]));
            }else{
                if(a[a_i] <= small.peek()){
                    small.add(a[a_i]);
                    if((a_i+1)%2 == 1){
                        large.add(small.poll());
                    }
                }else{
                    if((a_i+1)%2 == 1){
                        large.add(a[a_i]);
                    }
                    else{
                        if(a[a_i]>large.peek()){
                            small.add(large.poll());
                            large.add(a[a_i]);
                        }else{
                            small.add(a[a_i]);
                        }
                    }
                    if((a_i+1)%2 == 1){
                        System.out.println(df.format(large.peek()));
                    }else{
                        System.out.println(df.format((small.peek()+large.peek())/2.0));
                    }
                }
            }
            //System.out.println("small: "+small);
            //System.out.println("large: "+large);
        }
    }
}
