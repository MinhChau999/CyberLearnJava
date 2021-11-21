import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Đếm chữ số lẻ của số nguyên dương n");
		System.out.println("Cách 1 (đệ quy)  : Số chữ số lẻ có trong số (" + n + ") = " + countOddNumber1(n));
		System.out.println("Cách 2 (vòng lặp): Số chữ số lẻ có trong số (" + n + ") = " + countOddNumber2(n));
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

	// Đếm chữ số lẻ của số nguyên dương n
	// đệ quy
	public static int countOddNumber1(int n) {
		if (n < 10) {
			if (n % 2 != 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if (n % 2 != 0) {
				return 1 + countOddNumber1(n / 10);
			} else {
				return 0 + countOddNumber1(n / 10);
			}
		}
	}
	// vòng lặp
	public static int countOddNumber2(int n) {
		int count = 0;
		do {
			if(n%2 != 0) {
				count +=1;
			}
			n /= 10;
		} while(n > 0);
		return count;
	}
}
