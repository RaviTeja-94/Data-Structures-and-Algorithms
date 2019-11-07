import java.util.HashMap;

class Program {
  public static int getNthFib(int n) {
//     // Write your code here.
		//recursive solution
// 	HashMap<Integer,Integer> mem=new HashMap<Integer,Integer>();
// 		mem.put(1,0);
// 		mem.put(2,1);
// 		return getNthFib(n,mem);
// }
// 	public static int getNthFib(int n,HashMap<Integer,Integer> mem) {
// 		if(mem.containsKey(n))
// 		{
// 			return mem.get(n);
// 		}
// 		mem.put(n,getNthFib(n-1,mem)+getNthFib(n-2,mem));
// 		return mem.get(n);
// 	}
		
		//iterative solution
		int[] mem={0,1};
		int counter=3;
		int ans;
		while(counter<=n)
		{
			ans=mem[0]+mem[1];
			mem[0]=mem[1];
			mem[1]=ans;
			counter++;
		}
		return n>1?mem[1]:mem[0];
	}
}
