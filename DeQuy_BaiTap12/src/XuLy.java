import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tìm chữ số đầu tiên của số nguyên dương n");
		System.out.println("Cách 1 (đệ quy)  : Số đầu tiên của số " + n + " = " + findFirstNumber1(n));
		System.out.println("Cách 2 (vòng lặp): Số đầu tiên của số " + n + " = " + findFisrtNumber2(n));

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

	// Tìm chữ số đầu tiên của số nguyên dương n
	// Đệ quy
	public static int findFirstNumber1(int n) {
		if (n / 10 == 0) {
			return n;
		} else {
			return findFirstNumber1(n / 10);
		}
	}

	// Vòng lặp
	public static int findFisrtNumber2(int n) {
		do {
			if (n / 10 == 0) {
				return n;
			}
			n /= 10;
		} while (n > 0);
		return n;
	}
}
