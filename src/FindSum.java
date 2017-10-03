import java.util.*;

public class FindSum{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		HashMap<Integer, Integer> sumMap = new HashMap<>();
		for(int i =0; i < a.length; i++){
			a[i] = sc.nextInt();
			if(sumMap.get(a[i]) != null){
				System.out.println("YES");
				System.exit(0);
			}else{
				sumMap.put(8-a[i], a[i]);
			}
		}
		//System.out.println("NO");
		sc.close();
	}
}