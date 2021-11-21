import java.util.Scanner;

public class XuLy {
	final static int MAX = 1000;
	final static int MIN = -1000;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = createArr(scan);
		outputArr(a);
		outputOdd(a);

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

	// Xuất mảng
	public static void outputArr(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Kiểm tra toàn chữ số có lẻ không
	public static boolean checkOdd(int number) {
		number = Math.abs(number);
		do {
			if (number % 2 == 0) {
				return false;
			}
			number = number / 10;
		} while (number > 0);
		return true;
	}

	// Kiểm tra trong mảng có số toàn lẻ
	public static int index(int[] a) {
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if (checkOdd(a[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Xuất phần tử toàn lẻ
	public static void outputOdd(int[] a) {
		int index = index(a);
		if (index == -1) {
			System.out.println("Không có số chữ số toàn lẻ trong mảng");
		} else {
			System.out.println("Số chữ số toàn lẻ:");
			for (int i = index; i < a.length; i++) {
				if (checkOdd(a[i])) {
					System.out.print(a[i] + "\t");
				}
			}
		}
	}
}
