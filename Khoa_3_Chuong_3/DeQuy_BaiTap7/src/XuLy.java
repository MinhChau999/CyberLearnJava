import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Tính tổng Sn = 1 + 1/(1+2) + 1/(1+2+3) + ... + 1/(1+2+...+n)");
		System.out.println("Cách 1 (đệ quy)  : S(" + n + ") = " + totalSn1(n));
		System.out.println("Cách 2 (vòng lặp): S(" + n + ") = " + totalSn2(n));
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n;
		do {
			System.out.print("Nhập n (n>0): ");
			n = Integer.parseInt(scan.nextLine());
		} while (n < 1);
		return n;
	}
	
	// Tính tổng Sn = 1 + 1/(1+2) + 1/(1+2+3) + ... + 1/(1+2+...+n)
	// Đệ quy
	public static int total(int n) {
		if(n==1) {
			return 1;
		}
		return n + total(n-1);
	}
	
	public static float totalSn1(int n) {
		if(n ==1) {
			return 1;
		}
		return (float) 1.0f*1/total(n) + totalSn1(n-1);
	}
	
	// Vòng lặp for
	public static float totalSn2(int n) {
		int total = 0;
		float totalSn2 = 0;
		for(int i = 1; i <= n; i++) {
			total+=i;
			totalSn2 += (float) 1.0f* 1/total;
		}
		return totalSn2;
	}
	
	
}
