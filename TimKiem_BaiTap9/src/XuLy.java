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
		int primeMin = primeMin(a);
		System.out.println("Số nguyên tố nhỏ nhất lớn hơn mọi giá trị trong mảng: " + primeMin);
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

	// Kiểm tra 1 số là số nguyên tố
	public static boolean prime(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i < (number - 1); i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	// Vị trí số lớn nhất trong mảng
	public static int indexMax(int[] a) {
		int index = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > a[index]) {
				index = i;
			}
		}
		return index;
	}

	// Số nguyên tố nhỏ nhất lớn hơn mọi giá trị trong mảng
	public static int primeMin(int[] a) {
		int primeMin = a[indexMax(a)] + 1;
		while (!prime(primeMin)) {
			primeMin++;
		}
		return primeMin;
	}
}
