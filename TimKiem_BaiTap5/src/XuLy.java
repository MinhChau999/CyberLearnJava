import java.util.Scanner;

public class XuLy {
	final static int MAX = 100;
	final static int MIN = -100;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float[] a = createArr(scan);
//		float[] a = intputArr(scan);
		outputArr(a);
		System.out.println("Nhập x:");
		float x = Float.parseFloat(scan.nextLine());
		nearX(a, x);
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
	public static float[] intputArr(Scanner scan) {
		int n = inputN(scan);
		float[] a = new float[n];
		System.out.println("Nhập mảng:");
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = Float.parseFloat(scan.nextLine());
		}
		return a;
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

	// Số thực gần giá trị x nhất
	public static void nearX(float[] a, float x) {
		float[] b = new float[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = (float) Math.abs(a[i] - x);
		}
		// So sánh các giá trị gần vs x nhất
		int indexMin = 0;
		for (int i = 1; i < a.length; i++) {
			if (b[i] < b[indexMin]) {
				indexMin = i;
			}
		}
		// In ra tất cả các giá trị gần x nhất
		System.out.println("Giá trị gần " + x + " nhất:");
		for (int i = 0; i < a.length; i++) {
			if (b[i] == b[indexMin]) {
				System.out.print("a["+i+"] = "+a[i] + "\t");
			}
		}
	}
}
