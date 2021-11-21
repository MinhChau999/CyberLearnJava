import java.util.Scanner;

public class XuLy {
	final static int MAX = 10;
	final static int MIN = 0;
	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = createArr(scan);
		outputArr(a);
		a = reverseArr(a);
		System.out.println("Mảng đảo ngược:");
		outputArr(a);

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
	
	// Đảo ngược mảng ban đầu
	public static int[] reverseArr(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = a[a.length - 1 -i];
		}
		return b;
	}
	
}
