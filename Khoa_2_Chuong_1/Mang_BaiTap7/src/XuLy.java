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
//		int[] a = intputArr(scan);
		outputArr(a);
		total(a);

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

	// Kiểm tra hàng chục là số 5
	public static boolean check(int number) {
		boolean check;
		number /= 10;
		if (Math.abs(number) % 10 == 5) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	// Kiểm tra trong mảng có số mà hàng chục là 5
	public static int index(int[] a) {
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if (check(a[i])) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Tính tổng các số có chữ số hàng chục là số 5
	public static void total(int[] a) {
		int index = index(a);
		int total = 0;
		if (index == -1) {
			System.out.println("Không có số có chữ số hàng chục bằng 5 trong mảng");
		} else {
			System.out.println("Các số có số 5 hàng chục:");
			for (int i = index; i < a.length; i++) {
				if (check(a[i])) {
					System.out.print(a[i] + "\t");
					total += a[i];
				}
			}
			System.out.println("\nTổng các số có chữ số hàng chục là số 5: " + total);
		}
	}
}
