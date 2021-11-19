import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		int max = 0;
		System.out.println("Tìm chữ số lớn nhất trong số nguyên dương n");
		System.out.println("Cách 1 (đệ quy)  : Chữ số lớn nhất của " + n + " = " + lagestDigit1(n, max));
		System.out.println("Cách 2 (vòng lặp): Chữ số lớn nhất của " + n + " = " + lagestDigit2(n, max));
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

	// Tìm chữ số max trong số nguyên dương n
	// Đệ quy
	public static int lagestDigit1(int n, int max) {
		if (n == 0) {
			return max;
		} else {
			if (n % 10 > max) {
				max = n % 10;
			}
		}
		return lagestDigit1(n / 10, max);
	}

	// Vòng lặp
	public static int lagestDigit2(int n, int max) {
		do {
			if (n % 10 > max) {
				max = n % 10;
			}
			n /= 10;
		} while (n > 0);
		return max;
	}
}
