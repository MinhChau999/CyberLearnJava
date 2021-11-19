import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Khai báo các biến.
		final int TY_GIA = 23500;
		int tienUSD;
		int tienVND;

		// Nhập tiền USD
		Scanner nhap = new Scanner(System.in);
		System.out.print("Vui lòng nhập tiền USD muốn quy đổi: ");
		tienUSD = Integer.parseInt(nhap.nextLine());

		// Chuyển đổi sang VND
		tienVND = TY_GIA * tienUSD;

		// In ra màn hình kết quả
		System.out.println(tienUSD + " USD có thể đổi được thành " + tienVND + " VND");

	}

}
