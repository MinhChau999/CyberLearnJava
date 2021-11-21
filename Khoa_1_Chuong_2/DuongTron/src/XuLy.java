import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float xC;
		float yC;
		float R;
		float xM;
		float yM;
		float lenghtCM;

		// Nhập các giá trị đầu vào
		Scanner nhap = new Scanner(System.in);
		System.out.print("Vui lòng nhập tọa độ x của tâm đường tròn C: ");
		xC = Float.parseFloat(nhap.nextLine());

		System.out.print("Vui lòng nhập tọa độ y của tâm đường tròn C: ");
		yC = Float.parseFloat(nhap.nextLine());

		System.out.print("Vui lòng nhập bán kính R của đường tròn C: ");
		R = Float.parseFloat(nhap.nextLine());

		System.out.print("Vui lòng nhập tọa độ x của điểm M: ");
		xM = Float.parseFloat(nhap.nextLine());

		System.out.print("Vui lòng nhập tọa độ y của điểm M: ");
		yM = Float.parseFloat(nhap.nextLine());
		
		// Tính khoảng cách từ tâm đường tròn đến điểm M
		lenghtCM = (float) Math.sqrt(Math.pow(xM - xC, 2) + Math.pow(yM - yC, 2));
		
		// So sánh và in kết quả ra màn hình
		if (lenghtCM < R) {
			System.out.println("M nằm trong đường tròn C");
		} else if (lenghtCM > R) {
			System.out.println("M nằm ngoài đường tròn C");
		} else {
			System.out.println("M nằm trên đường tròn C");
		}
	}

}
