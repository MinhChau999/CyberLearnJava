import java.util.Scanner;

public class Xuly {

	public Xuly() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int n = 0;
		do {
			System.out.print("Nhập độ cao n: ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 1) {
				flag = false;
			} else {
				System.out.println("n không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);

		// Tam giác đặc
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < 2 * n; j++) {
				if (i < (int) Math.abs(j - n) + 1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println("");
		}

		// Tam giác rỗng
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < 2 * n; j++) {
				if (i == (int) Math.abs(j - n) + 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
		for (int j = 1; j < 2 * n; j++) {
			System.out.print("*");
		}
	}
}
