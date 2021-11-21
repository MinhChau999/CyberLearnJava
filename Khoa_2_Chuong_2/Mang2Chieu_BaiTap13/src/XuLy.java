import java.util.Scanner;

public class XuLy {
	final static int MIN = -50;
	final static int MAX = 50;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập số dòng (row>1): ");
		int row = inputN(scan);
		System.out.print("Nhập số cột (column>1): ");
		int column = inputN(scan);
		int[][] a = createArr2(row, column);
		System.out.println("Mảng a:");
		outputArr2(a, row, column);
		totalPrime(a, row, column);
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
	public static int[][] createArr2(int row, int column) {
		int[][] a = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				a[i][j] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
			}
		}
		return a;
	}

	// Xuất mảng 2 chiều
	public static void outputArr2(int[][] a, int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	// Kiểm tra 1 số là số nguyên tố
	public static boolean prime(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}

		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i < (number - 1); i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	// Tính tổng các số nguyên tố có trong mảng
	public static void totalPrime(int[][] a, int row, int column) {
		int total = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (prime(a[i][j])) {
					total += a[i][j];
				}
			}
		}
		if (total == 0) {
			System.out.println("Không có số nguyên tố trong mảng");
		} else {
			System.out.println("Tổng các số nguyên tố trong mảng: " + total);
		}
	}
}
