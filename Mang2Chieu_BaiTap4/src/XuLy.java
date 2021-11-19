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
		System.out.println("Mảng a:");
		int[][] a = createArr2(row, column);
		outputArr2(a, row, column);
		maxNeativeNumber(a, row, column);

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

	// Tìm số âm lớn nhất trong mảng 2 chiều
	public static void maxNeativeNumber(int[][] a, int row, int column) {
		int rowNegative = -1;
		int columnNegative = -1;

		// Tìm số âm đầu tiên
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (a[i][j] < 0) {
					rowNegative = i;
					columnNegative = j;
					break;
				}
			}
			if (columnNegative != -1) {
				break;
			}
		}

		if (columnNegative == -1) {
			System.out.println("Mảng không có số âm");
		} else {
			// Tìm số âm lớn nhất trong mảng 2 chiều
			int maxNegativeNumber = a[rowNegative][columnNegative];
			for (int i = rowNegative; i < row; i++) {
				for (int j = 0; j < column; j++) {
					if (maxNegativeNumber < a[i][j] && a[i][j] < 0) {
						maxNegativeNumber = a[i][j];
						rowNegative = i;
						columnNegative = j;
					}
				}
			}
			System.out.println("Số âm lớn nhất trong mảng: a["+ rowNegative + "][" + columnNegative + "]= " + maxNegativeNumber);
		}
	}
}
