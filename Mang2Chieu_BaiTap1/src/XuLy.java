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
		findFirstEvenNumber(a, row, column);
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n;
		do {
			n = Integer.parseInt(scan.nextLine());
			if(n<=1) {
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
	
	// Tìm phần tử chẵn đầu tiên
	public static void findFirstEvenNumber(int[][] a, int row, int column) {
		int rowNum = -1;
		int columnNum = -1;
		for(int i =0; i < row; i++) {
			for(int j = 0; j<column; j++) {
				if(a[i][j] % 2 == 0) {
					rowNum = i;
					columnNum = j;
					break;
				}
			}
			if(columnNum != -1) {
				break;
			}
		}
		if(columnNum == -1) {
			System.out.println("Mảng không có phần tử chẵn");
		} else {
			System.out.println("Phần tử chẵn đầu tiên trong mảng a[" + rowNum + "][" + columnNum + "]= "+ a[rowNum][columnNum]);
		}
	}
}
