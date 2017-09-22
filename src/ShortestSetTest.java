import java.util.*;

public class ShortestSetTest{
	public static void main(String args[]){
		Set set = new HashSet();
		for(int i =0; i<100; i++){
			set.add(i);
			set.remove(i-1);
		}
		System.out.println(set);
		int a =0;
		System.out.println(a++);
		a=0;
		System.out.println(++a);
		
	}
}