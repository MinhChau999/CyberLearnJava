import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// Khai báo các biến
		final float PI = (float) 3.1414;
		float lenghtYard;
		float rTree;
		float space2Tree;
		float numberOfTree;
		float totalOfSpace;
		float range2Tree;

		// Nhập giá trị đầu vào
		Scanner nhap = new Scanner(System.in);

		System.out.print("Nhập chiều dài của sân (m): ");
		lenghtYard = Float.parseFloat(nhap.nextLine());

		System.out.print("Nhập bán kính của một cây phát triển đầy đủ (m): ");
		rTree = Float.parseFloat(nhap.nextLine());

		System.out.print("Nhập không gian cần thiết giữa các cây phát triển đầy đủ (m): ");
		space2Tree = Float.parseFloat(nhap.nextLine());

		// Tính khoảng cách thực của 2 cây trưởng thành
		range2Tree = 2 * rTree + space2Tree;

		// Tính số cây có thể trồng
		numberOfTree = (int) Math.floor(1.0f * lenghtYard / range2Tree);

		// Tính tổng không gian có thể chiếm của cây trồng hoàn toàn
		totalOfSpace = numberOfTree * (PI * (float) Math.pow(space2Tree + rTree,2));

		// In kết quả ra màn hình
		System.out.println("Số cây có thể trồng trong sân: " + numberOfTree);
		System.out.println("Tổng không gian được chiếm bởi cây trồng hoàn toàn: " + totalOfSpace + " m2");
	}

}
