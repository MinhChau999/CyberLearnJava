import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập lãi suất năm r(%): "); // rate : lãi suất
		float r = input(scan);
		System.out.print("Nhập tiền vốn p: "); // principal: tiền vốn
		int p = (int) input(scan);
		System.out.print("Nhập thời hạn n(năm): ");
		int n = (int) input(scan);
		System.out.println("Lãi suất: " + r * 100 + "%");
		System.out.println("Vốn ban đầu: " + p);
		System.out.println("Thời hạn: " + n + " năm");
		System.out.println("Năm\tVốn");

		for (int i = 1; i <= n; i++) {
			float a = amount(r, p, i); // amount: vốn tích lũy được
			System.out.println(i + "\t" + (float) Math.ceil(a * 100) / 100);
		}
	}

	// Hàm nhập
	public static float input(Scanner scan) {
		float input = Float.parseFloat(scan.nextLine());
		return input;
	}

	// Hàm tính lãi suất
	public static float amount(float r, int p, int n) {
		float a = p * (float) Math.pow((1 + r), n);
		return a;
	}

}
