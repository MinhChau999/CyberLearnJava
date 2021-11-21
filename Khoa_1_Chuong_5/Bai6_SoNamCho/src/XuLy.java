import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập số tiền gửi: ");
		float principal = inputMoney(scan); // tiền vốn
		System.out.print("Nhập số tiền mong muốn: ");
		float desiredMoney = inputMoney(scan); // tiền mong muốn
		System.out.print("Nhập tiền lãi năm đầu tiên: ");
		float interest = inputMoney(scan); // tiền lãi
		// Tính lãi suất tiết kiệm
		float rate = 1.0f * interest / principal; // rate: lãi suất

		int count = 1; // biến đếm
		float mount = principal + interest; // tổng tiền sau khi tính lãi
		while (mount < desiredMoney) {
			count ++;
			interest = mount * rate;
			mount += interest;	
		}

		System.out.println("Số năm phải chờ đợi là: " + count);
		System.out.println("Số tiền sau " + count + " năm là " + mount);
	}

	public static float inputMoney(Scanner scan) {
		float money = Integer.parseInt(scan.nextLine());
		return money;
	}

}
