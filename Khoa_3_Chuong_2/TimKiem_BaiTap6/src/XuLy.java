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
		float x = findX(a);
		System.out.println("Đoạn chứa tất cả giá trị trong mảng: [" + -x + "; " + x +"]");

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
 
	// Tìm giá trị x sao cho [-x;x] chứa tất cả giá trị trong mảng
	public static float findX(float[] a) {
		float x = (float) Math.abs(a[0]);
		for(int i =1; i < a.length; i++) {
			if(Math.abs(a[i]) > x) {
				x = Math.abs(a[i]);
			}
		}
		return x;
	}
}
