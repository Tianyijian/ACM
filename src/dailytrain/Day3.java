package dailytrain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 越大越聪明  最长公共子序列
 * PC/UVa IDs: 111101/10131, Popularity: B, Success rate: high Level: 2
 **/
public class Day3 {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("src/dailytrain/Day3_input.txt"));
		int count = 0;
		List<Ele> list = new ArrayList<Ele>();
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			count++;
			String[] str = line.split(" ");
			Ele ele = new Ele(count, Integer.valueOf(str[0]),
					Integer.valueOf(str[1]));
			list.add(ele);
		}
		int N = list.size();
		// for (int i = 0; i < N ; i++) {
		// System.out.println(list.get(i).toString());
		// }
		List<Ele> list1 = new ArrayList<Ele>();
		List<Ele> list2 = new ArrayList<Ele>();
		list1.addAll(list);
		list2.addAll(list);
		Collections.sort(list1, new Comparator<Ele>() {
			@Override
			public int compare(Ele arg0, Ele arg1) {
				if (arg0.weight == arg1.weight) {
					return Integer.valueOf(arg1.IQ).compareTo(arg0.IQ);
				} else {
					return Integer.valueOf(arg0.weight).compareTo(arg1.weight);
				}

			}
		});
		// System.err.println(list1.size());
		// for (int i = 0; i < N ; i++) {
		// System.out.println(list1.get(i).toString());
		// }
		Collections.sort(list2, new Comparator<Ele>() {

			@Override
			public int compare(Ele arg0, Ele arg1) {
				if (arg0.IQ == arg1.IQ) {
					return Integer.valueOf(arg0.weight).compareTo(arg1.weight);
				} else {
					return Integer.valueOf(arg1.IQ).compareTo(arg0.IQ);
				}
			}
		});
		// System.err.println(list2.size());
		// for (int i = 0; i < N ; i++) {
		// System.out.println(list2.get(i).toString());
		// }
		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			a[i] = list1.get(i - 1).index;
			b[i] = list2.get(i - 1).index;
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(a[i] + " ");
//		}
//		System.out.println();
//		for (int i = 1; i <= N; i++) {
//			System.out.print(b[i] + " ");
//		}
//		System.out.println();
		int[][] c = new int[N + 1][N + 1];
		int[][] s = new int[N + 1][N + 1];
		int W = list1.get(0).weight - 1;
		int I = list2.get(0).IQ +1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int nW = list.get(a[i] - 1).weight;
				int nI = list.get(b[j] - 1).IQ;
				if (a[i] == b[j] && nW > W && nI < I) {
					c[i][j] = c[i - 1][j - 1] + 1;
					s[i][j] = 1; // 斜向上
					W = nW;
					I = nI;
				} else if (c[i - 1][j] > c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					s[i][j] = 2; // 向上
				} else {
					c[i][j] = c[i][j - 1];
					s[i][j] = 3; // 向左
				}
			}
		}
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.print(c[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= N; j++) {
//				System.out.print(s[i][j] + " ");
//			}
//			System.out.println();
//		}
		int[] res = new int[N];
		int i = N, j = N, k = 0;
		while (i > 0 && j > 0) {
			if (s[i][j] == 1) { // 斜向上回访
				res[k] = a[i];
				k++;
				i--;
				j--;
			} else if (s[i][j] == 2) { // 向上回访
				i--;
			} else if (s[i][j] == 3) { // 向左回访
				j--;
			}
		}
		System.out.println(c[N][N]);
		for (i = k - 1; i >= 0; i--) {
			System.out.println(res[i]);
		}
	}
}

class Ele {
	int index;
	int weight;
	int IQ;

	public Ele(int index, int weight, int iQ) {
		super();
		this.index = index;
		this.weight = weight;
		this.IQ = iQ;
	}

	@Override
	public String toString() {
		return index + ": " + weight + " " + IQ;
	}
}
