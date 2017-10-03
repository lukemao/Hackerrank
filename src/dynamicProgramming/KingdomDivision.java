package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class KingdomDivision{
	
	static int MAX_NODE_SIZE = 100005;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(100005);
	static final int MOD = 1000000007;
	static long mem[][][] = new long[MAX_NODE_SIZE][2][2];
	
	static long g(int node, int parent, int index, int color, int ally){
		//System.out.println("node: "+node+", parent: "+parent+", color: "+color+", ally: "+ally);
		if(index == graph.get(node).size()){
			//System.out.println("No more child "+ally);
			return ally;
		}
		
		int child = graph.get(node).get(index);
		
		if(child == parent){
			//System.out.println("Child is parent");
			return g(node, parent, index+1, color, ally);
		}
		
		if(mem[child][color][ally] != -1){
			//System.out.println("Already Cal");
			return mem[child][color][ally];
		}
	    ///For each child, we can make it ally with its parent
	    ///And start independent sub-tree dp
		long res = (g(child, node, 0, color, 1) * g(node, parent, index + 1, color, 1)) % MOD;
		///Or, make it different
	    res = res + (g(child, node, 0, 1 - color, 0) * g(node, parent, index + 1, color, ally)) % MOD;
		//System.out.println("END "+res+" subtree rooted at parents of child node "+child+" (color:"+color+", ally:"+ally+")\n ----");
	    mem[child][color][ally] = res;
		return res;
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0; i<=n; i++){
			mem[i][0][0] = mem[i][0][1] = mem[i][1][0] = mem[i][1][1] = -1;
		}
		for(int i = 0; i <= n; i++){
			ArrayList<Integer> l = new ArrayList<>();
			graph.add(l);
		}
		
		for(int i = 0; i < n - 1; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		long cnt = (2 * g(1, 0, 0, 0, 0)) % MOD;
		System.out.println(cnt);
		/*
		System.out.println("<--------TEST---------->");
		for(int i = 1; i <= n; i++){
			System.out.println(i+"->{"+graph.get(i)+"}");
		}
		for(int i =1; i<=n; i++){
			System.out.print(i+"||");
			for(int j =0; j<2; j++){
				for(int k =0; k<2; k++){
					if(mem[i][j][k] == -1)
					    System.out.print("- ");
					else
					    System.out.print(mem[i][j][k]+" ");
				}
				System.out.print("|");
			}
			System.out.println();
		}
		*/
		sc.close();
	}
}