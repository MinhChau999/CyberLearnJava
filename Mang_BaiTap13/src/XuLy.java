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
//		int [] a = intputArr(scan);
		outputArr(a);
		System.out.println("Mảng sau khi xóa số chẵn");
		a = deleteEvenNumber(a);
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

		// Đếm các số chẵn trong mảng
		public static int count(int[] a) {
			int count = 0;
			for (int pt : a) {
				if (pt%2 == 0) {
					count += 1;
				}
			}
			return count;
		}
		// Xóa các số chẵn trong mảng
		public static int[] deleteEvenNumber(int[] a) {
			int count = count(a);
			int[] b = new int[a.length - count];
			int j = 0;
			for(int i =0; i < a.length; i++) {
				if(a[i] %2 != 0) {
					b[j++] = a[i];
				}
			}
			return b;
		}
}
