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
		listedColumnIncrease(a, row, column);
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

	// Liệt kê các cột tăng dần trong ma trận
	public static void listedColumnIncrease(int[][] a, int row, int column) {
		boolean check = false;
		for (int i = 0; i < column; i++) {
			boolean flag = true;
			for (int j = 0; j < row - 1; j++) {
				if (a[j][i] >= a[j + 1][i]) {
					flag = false;
					check = true;
					break;
				}
			}
			if (flag) {
				System.out.println("Cột " + i + " tăng dần!");
			}
		}
		if (check) {
			System.out.println("Không có cột tăng dần trong ma trận");
		}
	}
}
