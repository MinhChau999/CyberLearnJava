import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = 0;
		boolean flag = true;
		int n = 0;
		// Nhập số mũ n
		do {
			System.out.print("Nhập số mũ (nguyên dương): ");
			n = inputNumber(scan);
			if (n>0) {
				flag = false;
			} else {
				System.out.println("Số mũ không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		
		// Nhập cơ số x
		System.out.print("Nhập số cơ số x: ");
		int x = inputNumber(scan);
		
		// Tính tổng S(n)
		for (int i = 1; i <= N; i++) {
			total += (int) Math.pow(x, i);
		}

		System.out.println("Tổng S(n) = " + total);
	}

	// Hàm nhập số
	public static int inputNumber(Scanner scan) {
		int n = Integer.parseInt(scan.nextLine());
		return n;
	}
}
