import java.util.Scanner;

public class XuLy {
	final static int MIN = 0;
	final static int MAX = 1;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập số dòng (row>1): ");
		int row = inputN(scan);
		System.out.print("Nhập số cột (column>1): ");
		int column = inputN(scan);
//		int[][] a = createArr2(row, column);
		int[][] a = inputArr2(row, column, scan);
		outputArr2(a, row, column);
		// Xuất ra màn hình ma trận thưa hay không thưa
		if (checkSparseMatrix(a, row, column)) {
			System.out.println("Ma trận là ma trận thưa");
		} else {
			System.out.println("Ma trận không phải là ma trận thưa");
		}

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

	// Nhập mảng 2 chiều
	public static int[][] inputArr2(int row, int column, Scanner scan) {
		int[][] a = new int[row][column];
		System.out.println("Nhập mảng a:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("a[" + i + "][" + j + "] = ");
				a[i][j] = Integer.parseInt(scan.nextLine());
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

	// Kiểm tra ma trận thưa hay không thưa
	public static boolean checkSparseMatrix(int[][] a, int row, int column) {
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (a[i][j] == 0) {
					count++;
				}
			}
		}
		if (count > row * column - count) {
			return true;
		}
		return false;
	}

}
