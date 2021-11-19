import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final int NUMBER_OF_ENTRIES = 5;
		int n;
		float average;
		int tong = 0;

		Scanner nhap = new Scanner(System.in);

		for (int i = 1; i <= NUMBER_OF_ENTRIES; i++) {
			System.out.print("Vui lòng nhập số thứ " + i + " : ");
			n = Integer.parseInt(nhap.nextLine());
			tong += n;
		}
		average = 1.0f * tong / NUMBER_OF_ENTRIES;
		System.out.println("Giá trị trung bình của 5 số là: " + average);
	}

}
