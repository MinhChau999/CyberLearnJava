import java.util.Scanner;

public class XuLy {
	final static int MAX = 10;
	final static int MIN = -10;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int[] a = createArr(scan);
		int[] a = intputArr(scan);
		outputArr(a);
		int[] b = countElement(a);
		outputArr(b);
		outputMaxMin(a, b);

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

	// Số lần phần tử xuất hiện nhiều nhất
	public static int countMax(int[] b) {
		int max = b[0];
		for (int i = 0; i < b.length; i++) {
			if (b[i] > max) {
				max = b[i];
			}
		}
		return max;
	}

	// Số lần phần tử xuất hiện ít nhất
	public static int countMin(int[] b) {
		int min = b[0];
		for (int i = 0; i < b.length; i++) {
			if (b[i] < min && b[i] != 0) {
				min = b[i];
			}
		}
		return min;
	}

	// In ra màn hình phần tử xuất hiện nhiều nhất và ít nhất
	public static void outputMaxMin(int[] a, int[] b) {
		int max = countMax(b);
		int min = countMin(b);

		System.out.print("Phần tử xuất hiện nhiều nhất: ");
		for (int i = 0; i < a.length; i++) {
			if (b[i] == max) {
				System.out.print(a[i] + "[" + max + " lần]\t");
			}
		}
		System.out.print("\nPhần tử xuất hiện ít nhất: ");
		for (int i = 0; i < a.length; i++) {
			if (b[i] == min) {
				System.out.print(a[i] + "[" + min + " lần]\t");
			}
		}
	}
}
