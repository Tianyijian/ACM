package dailytrain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**最长递减子序列
 *
 */
public class Day3_1 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("src/dailytrain/Day3_input.txt"));
		int count = 0;
		List<Elep> list = new ArrayList<Elep>();
		while (sc.hasNextLine()) {	//EOF判断
			count++;
			String line = sc.nextLine();
			String[] str = line.split(" ");
			Elep Elep = new Elep(count, Integer.valueOf(str[0]),
					Integer.valueOf(str[1]));
			list.add(Elep);
		}
		List<Elep> list1 = new ArrayList<Elep>();
		list1.addAll(list);
		Collections.sort(list1); // 体重升序,相同时IQ降序

		int N = list.size();
		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		int[] pre = new int[N + 1];	//前驱结点
//		for (int i = 0; i < N; i++) {
//			System.out.println(list1.get(i).toString());
//		}
		for (int i = 1; i <= N; i++) {
			a[i] = list1.get(i - 1).index;
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(a[i] + " ");
//		}
//		System.out.println();
		// 求a[i]的最长递减子序列
		for (int i = 1; i <= N; i++) {
			b[i] = 1;
		}

		int max = 0, k = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < i; j++) {
				Elep e1 = list1.get(j - 1);
				Elep e2 = list1.get(i - 1);
				if (e1.weight < e2.weight && e1.IQ > e2.IQ && b[j] + 1 > b[i]) {	//有无等号，结果不同
					b[i] = b[j] + 1;
					pre[i] = j;
					if (max <= b[i]) { 	//有无等号,结果不同
						max = b[i];
						k = i;
					}
				}
			}
		}
		System.out.println(max);
//		for (int i = 1; i <= N; i++) {
//			System.out.print(b[i] + " ");
//		}
//		System.out.println();
//		for (int i = 1; i <= N; i++) {
//			System.out.print(pre[i] + " ");
//		}
//		System.out.println();
		int i = max - 1;
		int[] res = new int[max];
		while (k != 0) {
			res[i--] = a[k];
			k = pre[k];
		}
		for (int j = 0; j < max; j++) {
			System.out.println(res[j]);
		}
	}
}

class Elep implements Comparable<Elep>{
	int index;
	int weight;
	int IQ;

	public Elep(int index, int weight, int iQ) {
		super();
		this.index = index;
		this.weight = weight;
		this.IQ = iQ;
	}

	@Override
	public String toString() {
		return index + ": " + weight + " " + IQ;
	}

	@Override
	public int compareTo(Elep arg0) {
		if (weight == arg0.weight) {
			return Integer.valueOf(arg0.IQ).compareTo(IQ);
		} else {
			return Integer.valueOf(weight).compareTo(arg0.weight);
		}
	}
}
