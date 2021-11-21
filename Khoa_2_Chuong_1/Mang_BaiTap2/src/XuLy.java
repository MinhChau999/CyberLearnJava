import java.util.Scanner;

public class XuLy {
	final static int MAX = 100;
	final static int MIN = -100;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = createArr(scan);
//		int[] a = intputArr(scan);
		outputArr(a);
		listedNeartest(a);
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n = 0;
		boolean flag = true;
		do {
			System.out.print("Nhập số nguyên dương n: ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 2) {
				flag = false;
			} else {
				System.out.println("n không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		return n;
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

	// Tạo mảng ngẫu nhiên
	public static int[] createArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	// Xuất mảng
	public static void outputArr(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	public static int nearest(int[] a) {
		int near = MAX - MIN;
		for (int i = 0; i < a.length - 1; i++) {
			if (Math.abs(a[i] - a[i + 1]) < near) {
				near = Math.abs(a[i] - a[i + 1]);
			}
		}
		return near;
	}

	public static void listedNeartest(int[] a) {
		int near = nearest(a);
		System.out.println("Các cặp giá trị gần nhau nhất:");
		for (int i = 0; i < a.length - 1; i++) {
			if (Math.abs(a[i] - a[i + 1]) == near) {
				System.out.print("(" + a[i] + "," + a[i + 1] + ") ");
			}
		}
	}
}
