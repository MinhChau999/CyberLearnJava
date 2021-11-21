import java.util.Scanner;

public class XuLy {
	final static int MAX = 1000;
	final static int MIN = -1000;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float[] a = createArr(scan);
		outputArr(a);
		totalPosstive(a);

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
	public static float[] createArr(Scanner scan) {
		int n = inputN(scan);
		float[] a = new float[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (float) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	// Xuất mảng
	public static void outputArr(float a[]) {
		for (float pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// kiểm tra có số dương trong mảng hay không
	public static int index(float[] a) {
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void totalPosstive(float[] a) {
		int index = index(a);
		float total = 0;
		if (index == -1) {
			System.out.println("Mảng không có số dương");
		} else {
			for (int i = index; i < a.length; i++) {
				if (a[i] > 0) {
					total += a[i];
				}
			}
			System.out.println("Tổng các số dương có trong mảng: " + total);
		}
	}
}
