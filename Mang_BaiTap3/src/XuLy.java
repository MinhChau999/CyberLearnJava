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
		outputArr(a);
		listedEvenNember(a, scan);

	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n = 0;
		boolean flag = true;
		do {
			System.out.print("Nhập số nguyên dương n (n chẵn): ");
			n = Integer.parseInt(scan.nextLine());
			if (n > 1 && n % 2 == 0) {
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

	// Xuất mảng
	public static void outputArr(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Kiểm tra số chẵn có trong mảng
	public static int index(int[] a) {
		int index = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Liệt kê số chẵn trong đoạn [x,y]
	public static void listedEvenNember(int[] a, Scanner scan) {
		int index = index(a);
		if (index == -1) {
			System.out.println("Mảng không có gá trị chẵn");
		} else {
			int x = 0;
			int y = 0;
			do {
				System.out.print("Nhập số chặn trước x: ");
				x = Integer.parseInt(scan.nextLine());
				System.out.print("Nhập số chặn sau y: ");
				y = Integer.parseInt(scan.nextLine());
				if (x >= y) {
					System.out.println("x,y không hợp lệ! Vui lòng nhập lại");
				}
			} while (x >= y);
			boolean flag = true;
			System.out.println("Số chẵn trong đoạn [" + x + "," + y + "]:");
			for (int i = index; i < a.length; i++) {
				if (a[i] >= x && a[i] <= y && a[i] % 2 == 0) {
					System.out.print(a[i] + "\t");
					flag = false;
				} 
			}
			if(flag) {
				System.out.println("Không có");
			}
		}
	}
}
