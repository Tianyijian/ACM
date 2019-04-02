package dailytrain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����� PC/UVa IDs: 110402/120, Popularity: B, Success rate:high Level: 2 ���Ե�ַ��
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
		Arrays.sort(target); // ����Ŀ������

		for (int i = len - 1; i >= 0; i--) {
			if (a[i] != target[i]) { // ��Ԥ�ڲ�ͬ�����з�ת
				for (int j = 0; j < len; j++) {
					if (a[j] == target[i]) {
						if (j == 0) {
							fanzhuan(a, len - i); // �����Ϸ���ֻ�跭ת�����¼���
						} else {
							fanzhuan(a, len - j); // ��ת������
							fanzhuan(a, len - i); // ��ת������
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
		System.out.print(k + " "); // �����ת�±�
		int len = a.length - k + 1;
		int[] b = new int[len];
		System.arraycopy(a, 0, b, 0, len);
		for (int t = 0; t < len; t++) {
			a[t] = b[len - 1 - t];
		}
	}
}
