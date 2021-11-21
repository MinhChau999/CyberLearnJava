import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int n = 0;
		do {
			System.out.print("Vui lòng nhập số n: ");
			n = Integer.parseInt(scan.nextLine());
			if (n>0) {
				flag = false;
			} else {
				System.out.println("n không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);

		int factorial = 1; // factorial: giai thừa
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}

		System.out.println(n + "! = " + factorial);
	}

}
