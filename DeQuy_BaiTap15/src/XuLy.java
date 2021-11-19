import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tính S(n) = 1 +1/3 +1/5 + ... + 1/(2n+1)");
		System.out.println("Cách 1 (đệ quy)  : Tổng S(" + n + ") = " + totalSn1(n));
		System.out.println("Cách 2 (vòng lặp): Tổng S(" + n + ") = " + totalSn2(n));
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n;
		do {
			System.out.print("Nhập n (n>0): ");
			n = Integer.parseInt(scan.nextLine());
		} while (n < 1);
		return n;
	}

	// Tính S(n) = 1 +1/3 +1/5 + ... + 1/(2n+1)
	// Đệ quy
	public static float totalSn1(int n) {
		if (n == 0) {
			return 1;
		}
		return (float) 1.0f * 1 / (2 * n + 1) + totalSn1(n - 1);
	}

	// vòng lặp
	public static float totalSn2(int n) {
		float total = 0;
		for (int i = 0; i <= n; i++) {
			total += (float) 1.0f * 1 / (2 * i + 1);
		}
		return total;
	}
}
