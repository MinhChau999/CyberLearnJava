import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = input(scan);
		int x = 0; // Mệnh giá 1000
		int y = 0; // Mệnh giá 2000
		int z = 0; // Mệnh giá 5000
		int tong = 0; // Tổng số tờ tiền

		int tong1 = n;
		int x1 = 0;
		int y1 = 0;
		int z1 = 0;
		for (y = n / 2; y >= 1; y--) {
			z = (n - 2 * y) / 5;
			x = (n - 2 * y) % 5;
			tong = x + y + z;
			if (tong < tong1 && y > x + z) {
				tong1 = tong;
				x1 = x;
				y1 = y;
				z1 = z;
			}
		}

		System.out.println(
				"(1000d, 2000d, 5000d) = " + "(" + x1 + (",") + y1 + (",") + z1 + (")") + " số tờ tiền: " + tong1);

	}

	// Hàm nhập số tiền n (n>5) nếu sai yêu cầu nhập lại
	public static int input(Scanner scan) {
		boolean flag = true;
		int n = 0;
		do {
			System.out.print("Nhập số tiền n (n>5): ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 5) {
				flag = false;
			} else {
				System.out.println("Số tiền nhập không hợp lê! Vui lòng nhập lại.");
			}
		} while (flag);
		return n;
	}

}
