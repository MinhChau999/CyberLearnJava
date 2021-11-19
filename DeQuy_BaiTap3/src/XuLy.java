import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tính tổng S(n) = 1/2 + 1/3 + ... + 1/n");
		System.out.println("Cách 1 (đệ quy) : S(" + n + ") = " + totalSn1(n));
		System.out.println("Cách 2 (lặp for): S(" + n + ") = " + totalSn2(n));
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

	// Tính tổng S(n) = 1/2 + 1/3 + ... + 1/n
	// Đệ quy
	public static float totalSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (float) 1.0f * 1 / n + totalSn1(n - 1);
	}

	// Vòng lặp
	public static float totalSn2(int n) {
		float total = 0;
		for (int i = 1; i <= n; i++) {
			total += (float)1.0f * 1 / i ;
		}
		return total;
	}
}
