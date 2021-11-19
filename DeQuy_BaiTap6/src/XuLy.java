import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập n (n>0): ");
		int n = inputN(scan);
		System.out.print("Nhập x: ");
		int x = Integer.parseInt(scan.nextLine());
		System.out.println("Tính S(x,n)= x + x^2 + x^3 + ... + x^n");
		System.out.println("Cách 1 (đệ quy)  : S(" + x + "," + n + ") = " + totalSxn1(x, n));
		System.out.println("Cách 2 (vòng lặp): S(" + x + "," + n + ") = " + totalSxn2(x, n));

	}

	// hàm nhập số > 0
	public static int inputN(Scanner scan) {
		int n;
		do {
			n = Integer.parseInt(scan.nextLine());
		} while (n < 1);
		return n;
	}

	// Tính S(x,n)= x + x^2 + x^3 + ... + x^n
	// Đệ quy
	public static int totalSxn1(int x, int n) {
		if (n == 1) {
			return x;
		}
		return (int) Math.pow(x, n) + totalSxn1(x, n - 1);
	}

	// Vòng lặp for
	public static int totalSxn2(int x, int n) {
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total += (int) Math.pow(x, i);
		}
		return total;
	}
}
