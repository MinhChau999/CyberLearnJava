import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Cách 1 (đệ quy)  : R(" + n + ") = " + squareRootRn1(n));
		System.out.println("Cách 2 (vòng lặp): R(" + n + ") = " + squareRootRn2(n));
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
	
	// Tính R(n) = Căn(n + căn(n-1+...))
	// đệ quy
	public static float squareRootRn1(int n) {
		if(n==1) {
			return 1;
		}
		return (float) Math.sqrt(n + squareRootRn1(n-1));
	}
	
	// vòng lặp
	public static float squareRootRn2(int n) {
		float square = 0;
		for(int i = 1; i <=n; i++) {
			square = (float) Math.sqrt(i + square);
		}
		return square;
	}
}


