import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = 0;
		int n = 0;
		// Nhập số nguyên dương n (nhập lại nếu < 0 thì yêu cầu nhập lại)
		boolean flag = true;
		do {
			System.out.print("Vui lòng nhập số nguyên dương: ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 0) {
				flag = false;
			} else {
				System.out.println("Số không hợp lệ! Xin nhập lại.");
			}
		} while (flag);

		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				total += i;
			}
		}

		System.out.println("Tổng các số lẻ nhỏ hơn n: " + total);
	}

}
