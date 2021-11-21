import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final int NUMBER_OF_ENTRIES = 5;
		int n1;
		int n2;
		int n3;
		int n4;
		int n5;
		float average;

		Scanner nhap = new Scanner(System.in);
		System.out.print("Vui lòng nhập số thứ nhất: ");
		n1 = Integer.parseInt(nhap.nextLine());

		System.out.print("Vui lòng nhập số thứ hai: ");
		n2 = Integer.parseInt(nhap.nextLine());

		System.out.print("Vui lòng nhập số thứ ba: ");
		n3 = Integer.parseInt(nhap.nextLine());

		System.out.print("Vui lòng nhập số thứ bốn: ");
		n4 = Integer.parseInt(nhap.nextLine());

		System.out.print("Vui lòng nhập số thứ năm: ");
		n5 = Integer.parseInt(nhap.nextLine());
		
		// Tính giá trị trung bình của 5 số
		average = 1.0f * (n1 + n2 + n3 + n4 + n5) / NUMBER_OF_ENTRIES;
		
		// In ra kết quả
		System.out.println("Trung bình cộng của 5 số là: " + average);

	}

}
