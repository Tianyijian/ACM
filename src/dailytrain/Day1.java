package dailytrain;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**快速过桥
 * PC/UVa IDs: 110403/10037, 
 * Popularity: B, 
 * Success rate: low Level: 3
 * 测试地址：https://vjudge.net/problem/UVA-10037
 **/
public class Day1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T;i++) {
			int n = sc.nextInt();
			int a[] = new int[n];
			for (int j = 0; j < n;j++) {
				a[j] = sc.nextInt();
			}
			Arrays.sort(a);
			TimeAndPath res = guoqiao(a, 0, a.length -1 );
			res.print();
			if ( i < T - 1 ) {
				System.out.println();
			}
		}
	}
	
	static TimeAndPath guoqiao(int[] a, int s, int e) {
		TimeAndPath res = new TimeAndPath();
		int A = a[s];
		if (e == s)  { 	//一个人
			res.time = A;
			res.q.add(String.valueOf(A));
			return res;
		}
		int Z = a[e];
		if (e - s == 1) { //两个人
			res.time = Z;
			res.q.add(A + " " + Z);
			return res;
		}
		int B = a[s+1];
		if (e - s == 2) { // 三个人
			res.time = A + B + Z;
			res.q.add(A + " " + Z);
			res.q.add(String.valueOf(A));
			res.q.add(A + " " + B);
			return res;
		}
		//四个人情况
		int Y = a[e-1];
		int time1 = B + A + Z + B; // AB + A + YZ + B;
		int time2 = Z + A + Y + A;//AZ + A + AY + A;	AB不过，留在最后
		//过剩余人
		res = guoqiao(a, s, e-2);
		if (time1 < time2) {
			res.time += time1;
			res.q.addFirst(String.valueOf(B));	//倒着添加到队列最前
			res.q.addFirst(Y + " " + Z);
			res.q.addFirst(String.valueOf(A));
			res.q.addFirst(A + " " + B);
		} else {
			res.time += time2;
			res.q.addFirst(String.valueOf(A));
			res.q.addFirst(A + " " + Y);
			res.q.addFirst(String.valueOf(A));
			res.q.addFirst(A + " " + Z);
		}

		return res;
	}

	private static class TimeAndPath {
		int time;
		Deque<String> q = new LinkedList<String>();
		
		void print() {
			System.out.println(time);
			for (String str : q) {
				System.out.println(str);
			}
		}
	}
}

