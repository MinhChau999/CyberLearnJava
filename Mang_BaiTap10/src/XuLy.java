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
		float x = inputX(scan);
		average(a, x);

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
	public static void outputArr(float[] a) {
		for (float pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Nhập x
	public static float inputX(Scanner scan) {
		float n = 0;
		boolean flag = true;
		do {
			System.out.print("Nhập x: ");
			n = Float.parseFloat(scan.nextLine());
			if (n > MIN && n < MAX) {
				flag = false;
			} else {
				System.out.println("x không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		return n;
	}

	// Kiểm tra phần tử trong mảng lớn hơn x
	public static int index(float[] a, float x) {
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > x) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Tính trung bình cộng của các số lớn hơn x
	public static void average(float[] a, float x) {
		int index = index(a, x); // Phần tử đầu tiên lớn hơn x
		int count = 0; // Biến đếm
		float total = 0; // Biến tổng
		if (index == -1) {
			System.out.println("Không có phần tử trong mảng lớn hơn " + x);
		} else {
			System.out.println("Các phần tử lớn hơn " + x + ":");
			for (int i = index; i < a.length; i++) {
				if (a[i] > x) {
					count += 1;
					total += a[i];
					System.out.print(a[i] + "  ");
				}
			}
			System.out.println("\n\nCó " + count + " phần tử lớn hơn " + x);
			float average = total / count;
			System.out.println("Trung bình cộng của số lớn hơn " + x + ": " + average);
		}
	}
}
