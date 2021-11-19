import java.util.Scanner;

public class XuLy {
	final static int MAX = 100;
	final static int MIN = -100;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = createArr(scan);
//		int[] a = intputArr(scan);
		outputArr(a);
		a = turnRight(a, scan);
		outputArr(a);

	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n = 0;
		boolean flag = true;
		do {
			System.out.print("Nhập số nguyên dương n: ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 0) {
				flag = false;
			} else {
				System.out.println("n không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		return n;
	}

	// Tạo mảng ngẫu nhiên
	public static int[] createArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	// Nhập mảng
	public static int[] intputArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		System.out.println("Nhập mảng:");
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = Integer.parseInt(scan.nextLine());
		}
		return a;
	}

	// Xuất mảng
	public static void outputArr(int[] a) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}
	
	// Xoay phải k lần
	public static int[] turnRight(int[] a, Scanner scan) {
		int k = 0;
		int temp;
		
		//Nhập k lớn hơn 0
		do {
			System.out.print("Nhập k: ");
			k = Integer.parseInt(scan.nextLine());
			if(k < 0) {
				System.out.println("k không hợp lệ! vui lòng nhập lại");
			}
		} while (k < 0);
		
		// Xoay phải k lần
		k = k % a.length;
		for(int i = 0; i < k; i++) {
			temp = a[a.length -1];
			for(int j=a.length -1; j > 0; j--) {
				a[j]=a[j-1];
			}
			a[0]= temp;
		}
		return a;
	}
}
