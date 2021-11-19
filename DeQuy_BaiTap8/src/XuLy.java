import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = inputN(scan);
		System.out.println("Đếm số lượng chữ số nguyên dương n");
		System.out.println("Cách 1 (đệ quy)  : Số lượng chữ số của số " + n + " = " + countAmountN1(n));
		System.out.println("Cách 2 (vòng lặp): Số lượng chữ số của số " + n + " = " + countAmountN2(n));

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
	
	// Đếm số lượng chữ số nguyên dương n
	// Đệ quy
	public static int countAmountN1(int n) {
		if(n<10) {
			return 1;
		}
		return 1 + countAmountN1(n/10);
	} 
	
	
	// Vòng lặp while
	public static int countAmountN2(int n) {
		int count = 0;
		do {
			count +=1;
			n /= 10;
		} while(n>0);
		return count;
	}
}
