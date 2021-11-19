import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tính tổng T(n) = 1/2 + 2/3 + ... + n/(n+1)");
		System.out.println("Cách 1 (đệ quy) : Tổng T(" + n + ") = " + totalTn1(n));
		System.out.println("Cách 2 (lặp for): Tổng T(" + n + ") = " + totalTn2(n));

	}
	
	//Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n;
		do {
			System.out.print("Nhập n (n>0): ");
			n = Integer.parseInt(scan.nextLine());
		} while(n < 1);
		return n;
	}
	
	// Tính tổng T(n) = 1/2 +2/3 + ... + n/(n+1)
	// Đệ quy
	public static float totalTn1(int n) {
		if(n == 1) {
			return (float) 1/2;
		} 
		return (float) 1.0f* n/(n+1) + totalTn1(n-1);
	}
	
	// Vòng lặp
	public static float totalTn2(int n) {
		float total = 0;
		for (int i = 1; i <= n; i++) {
			total += (float)1.0f * i/(i+1);
		}
		return total;
	}

}
