import java.util.Scanner;

public class XuLy {
	final static int MAX = 10;
	final static int MIN = -10;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = intputArr(scan);
//		int[] a = createArr(scan);
		System.out.println("Mảng a:");
		outputArr(a);
		// Đếm số lần phần tử xuất hiện trong mảng
		int[] b = countElement(a);
//		outputArr(b);
		System.out.println("");
		countAppearSame(a, b);
		System.out.println("");
		outputMax(a, b);
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n = 0;
		boolean flag = true;
		do {
			System.out.print("Nhập số nguyên dương n: ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 0) {
				flag = false;
			} else {
				System.out.println("n không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		return n;
	}

	// Tạo mảng ngẫu nhiên
	public static int[] createArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	// Nhập mảng
	public static int[] intputArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		System.out.println("Nhập mảng:");
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = Integer.parseInt(scan.nextLine());
		}
		return a;
	}

	// Xuất mảng
	public static void outputArr(int[] a) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Đếm phần tử
	public static int[] countElement(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[i] == a[j]) {
					if (j < i) {
						break;
					} else {
						b[i] += 1;
					}
				}
			}
		}
		return b;
	}

	// Xuất phần tử có số lần xuất hiện là như nhau
	public static void countAppearSame(int[] a, int[] b) {
		int[] c = countElement(b);
//		outputArr(c);
		for (int i = 0; i < b.length; i++) {
			if (c[i] > 1 && b[i] != 0) {
				System.out.println("Các số cùng xuất hiện " + b[i] + " lần:");
				for (int j = 0; j < b.length; j++) {
					if (b[i] == b[j]) {
						if (j < i) {
							break;
						} else {
							System.out.print(a[j] + "\t");
						}
					}
				}
				System.out.println("");
			}

		}
	}

	public static int countMax(int[] b) {
		int max = b[0];
		for (int i = 0; i < b.length; i++) {
			if (b[i] > max) {
				max = b[i];
			}
		}
		return max;
	}

	// Xuất phần tử có số lần xuất hiện nhiều nhất
	public static void outputMax(int[] a, int[] b) {
		int max = countMax(b);
		System.out.print("Phần tử xuất hiện nhiều nhất: ");
		for (int i = 0; i < a.length; i++) {
			if (b[i] == max) {
				System.out.print(a[i] + "[" + max + " lần]\t");
			}
		}
	}
}
