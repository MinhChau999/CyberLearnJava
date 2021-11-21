import java.util.Scanner;

public class XuLy {
	final static int MAX = 100;
	final static int MIN = -100;
	final static int SO_MU = 2;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] a = createArr(scan);
//		int[] a = intputArr(scan);
		outputArr(a);
		int index = indexFirst(a);
		if(index ==-1) {
			System.out.println(index);
		} else {
			System.out.println("Giá trị có dạng 2^k đầu tiên trong mảng");
			System.out.println("a["+index+"] = "+a[index]);
		}
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

	// Tạo mảng ngẫu nhiên
	public static int[] createArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	// Xuất mảng
	public static void outputArr(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Kiểm tra số có dạng 2^k
	public static boolean exponential(int number) {
		if (number >= 1) {
			float a = 1.0f * ((float) Math.log(number)) / ((float) Math.log(SO_MU));
			float b = (float) Math.floor(a);
			if (a - b == 0) {
				return true;
			}
		}
		return false;
	}

	// Số đầu tiên trong mảng có dạng 2^k
	public static int indexFirst(int[] a) {
		int index = -1;
		for(int i = 0; i < a.length; i++) {
			if(exponential(a[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
}
