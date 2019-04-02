package dailytrain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 翻煎饼 PC/UVa IDs: 110402/120, Popularity: B, Success rate:high Level: 2 测试地址：
 * https://vjudge.net/problem/UVA-120
 */
public class Day2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] str = line.split(" ");
			int[] a = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				a[i] = Integer.valueOf(str[i]);
			}
			System.out.println(line);
			fan(a);
		}
	}

	static void fan(int[] a) {
		int len = a.length;
		int[] target = new int[len];
		System.arraycopy(a, 0, target, 0, len);
		Arrays.sort(target); // 升序目标数组

		for (int i = len - 1; i >= 0; i--) {
			if (a[i] != target[i]) { // 与预期不同，进行翻转
				for (int j = 0; j < len; j++) {
					if (a[j] == target[i]) {
						if (j == 0) {
							fanzhuan(a, len - i); // 在最上方，只需翻转至最下即可
						} else {
							fanzhuan(a, len - j); // 翻转至最上
							fanzhuan(a, len - i); // 翻转至最下
						}
						break;
					}
				}
			}
		}
		System.out.print("0");
		System.out.println();
	}

	static void fanzhuan(int[] a, int k) {
		System.out.print(k + " "); // 输出翻转下标
		int len = a.length - k + 1;
		int[] b = new int[len];
		System.arraycopy(a, 0, b, 0, len);
		for (int t = 0; t < len; t++) {
			a[t] = b[len - 1 - t];
		}
	}
}
