import java.util.Scanner;

public class XuLy {
	final static int MIN = -50;
	final static int MAX = 50;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scanr = new Scanner(System.in);
		System.out.print("Nhập số dòng (row>1): ");
		int row = inputN(scanr);
		System.out.print("Nhập số cột (column>1): ");
		int column = inputN(scanr);
		int[][] a = createArr2(row, column);
		outputArr2(a, row, column);
		totalEvenNumber(a, row, column);

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
	
	// Tính tổng số chẵn trong mảng 2 chiều
	public static void totalEvenNumber(int[][] a, int row, int column) {
		int total = 0;
		boolean flag = true;
		for (int i = 0; i <row; i++) {
			for(int j = 0; j<column; j++) {
				if(a[i][j] % 2 == 0) {
					total += a[i][j];
					flag = false;
				}
			}
		}
		if(flag) {
			System.out.println("Mảng không có số chẵn");
		} else {
			System.out.println("Tổng số chẵn có trong mảng: " + total);
		}
	}

}
