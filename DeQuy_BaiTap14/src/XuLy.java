import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tìm chữ số max trong số nguyên dương n");
		System.out.println("Cách 1 (đệ quy)  : Tổng các chữ số chẵn có trong số " + n + " = " + totalEvenNumber1(n));
		System.out.println("Cách 2 (vòng lặp): Tổng các chữ số chẵn có trong số " + n + " = " + totalEvenNumber2(n));

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

	// Tổng các chữ số chẵn của số nguyên dương n
	// đệ quy
	public static int totalEvenNumber1(int n) {
		if (n < 10) {
			if (n % 2 == 0) {
				return n;
			} else {
				return 0;
			}
		} else {
			if (n % 2 == 0) {
				return n%10 + totalEvenNumber1(n / 10);
			} else {
				return 0 + totalEvenNumber1(n / 10);
			}
		}
	}

	// vòng lặp
	public static int totalEvenNumber2(int n) {
		int total = 0;
		do {
			if (n % 2 == 0) {
				total += n%10;
			}
			n /= 10;
		} while (n > 0);
		return total;
	}
}
