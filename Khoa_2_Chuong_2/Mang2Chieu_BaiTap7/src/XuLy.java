import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập số dòng (row>1): ");
		int row = inputN(scan);
		System.out.print("Nhập số cột (column>1): ");
		int column = inputN(scan);
		int[][] a = inputArr2(row, column, scan);
		System.out.println("Mảng a:");
		outputArr2(a, row, column);
		int columnNumber = -1;
		do {
			System.out.print("Nhập số cột muốn tính tổng lẻ (số cột lớn hơn -1 và nhỏ hơn " + column + "): ");
			columnNumber = Integer.parseInt(scan.nextLine());
		} while (columnNumber < 0 || columnNumber >= column);
		if (checkColumnDecrease(a, row, column, columnNumber)) {
			System.out.println("Cột " + columnNumber + " giảm dần");
		} else {
			System.out.println("Cột " + columnNumber + " không giảm dần");
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

	// Kiểm tra 1 cột giảm dần
	public static boolean checkColumnDecrease(int[][] a, int row, int column, int j) {
		for (int i = 0; i < row - 1; i++) {
			if (a[i][j] <= a[i + 1][j]) {
				return false;
			}
		}
		return true;
	}
}
