import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tính tích của các chữ số của số dương n");
		System.out.println("Cách 1 (đệ quy)  : Tích các chữ số của số " + n + " = " + multipAmountN1(n));
		System.out.println("Cách 2 (vòng lặp): Tích các chữ số của số " + n + " = " + multipAmountN2(n));

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

	// Tính tích của các chữ số của số dương n
	// đệ quy
	public static int multipAmountN1(int n) {
		if (n < 10) {
			return n;
		}
		return (n % 10) * multipAmountN1(n / 10);
	}

	// vòng lặp
	public static int multipAmountN2(int n) {
		int multip = 1;
		do {
			multip *= n % 10;
			n /= 10;
		} while (n > 0);
		return multip;
	}
}
