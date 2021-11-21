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
		int index = findFisrtnalPrine(a);
		if (index == -1) {
			System.out.println(index);
		} else {
			System.out.println("Vị trí số nguyên tố cuối cùng trong mảng mảng: " + index);
			System.out.println("a[" + index + "] = " + a[index]);
		}

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

	// Vị trí số nguyên tố cuối mảng
	public static int findFisrtnalPrine(int[] a) {
		int index = -1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (prime(a[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
}
