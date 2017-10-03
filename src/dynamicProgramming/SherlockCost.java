package dynamicProgramming;

import java.util.*;

public class SherlockCost {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i =0; i< tc; i++){
            int n = sc.nextInt();
            int[] B = new int[n];
            long[][] dp = new long[2][n];
            for(int j =0; j<n; j++){
                B[j] = sc.nextInt();
            }
            for(int j =1; j<n; j++){
            	System.out.println("B["+j+"] - B["+(j-1)+"] = "+ B[j]+" - "+ B[j - 1]+" = "+Math.abs(B[j] - B[j - 1]));
            	System.out.println("B["+j+"] - 1 = "+ B[j]+" - 1 = "+Math.abs(B[j] - 1));
            	// A[j] <- B[j]
                dp[0][j] = Math.max(dp[0][j - 1] + Math.abs(B[j] - B[j - 1]),
                                    dp[1][j - 1] + Math.abs(B[j] - 1));

            	System.out.println("1 - B["+(j-1)+"] = 1 - "+ B[j - 1]+" = "+Math.abs(1    - B[j - 1]));
            	System.out.println("1 - 1 = 1 - 1 = 0");
            	// A[j] <- 1
                dp[1][j] = Math.max(dp[0][j - 1] + Math.abs(1    - B[j - 1]),
                                    dp[1][j - 1] + Math.abs(1    - 1));
            	System.out.println();
            }
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
            
            
            
            
            

            System.out.print("dp[0][j]: {");
            for(int j =0; j<n; j++){
                System.out.print(dp[0][j]+" ");
            }
            System.out.println("}");
            System.out.print("dp[1][j]: {");
            for(int j =0; j<n; j++){
                System.out.print(dp[1][j]+" ");
            }
            System.out.println("}");
        }
        sc.close();
    }
}
