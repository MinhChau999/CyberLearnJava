import java.util.Scanner;

public class XuLy {
	final static int MIN = -100;
	final static int MAX = 100;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập bậc ma trận (n>1): ");
		int n = inputN(scan);
		int[][] a = createArr2(n);
		outputArr2(a, n);
		auxiliary(a, n);
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n;
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n <= 1) {
				System.out.println("Số nhập không hợp lệ! Vui lòng nhập lại.");
			}
		} while (n <= 1);
		return n;
	}

	// Tạo mảng 2 chiều ngẫu nhiên
	public static int[][] createArr2(int n) {
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
			}
		}
		return a;
	}

	// Xuất mảng 2 chiều
	public static void outputArr2(int[][] a, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	// In ra giá trị song song với đường chéo phụ
	public static void auxiliary(int[][] a, int n) {
		System.out.println("Phần tử song song với đường chéo phụ: ");
		for (int i = 0; i < 2 * n - 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (j < n && i - j < n) {
					System.out.print(a[j][i - j] + "\t");
				}	
			}
			System.out.println("");
		}
	}
}
