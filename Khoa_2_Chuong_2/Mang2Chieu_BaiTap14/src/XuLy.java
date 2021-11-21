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
		appearTheMost(a, row, column);
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

	// Xuất mảng 1 chiều
	public static void outputArr(int[] a) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Chuyển mảng 2 chiều thành mảng 1 chiều
	public static int[] convertArr2To1(int[][] a, int row, int column) {
		int[] b = new int[row * column];
		int k = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				b[k++] = a[i][j];
			}
		}
		return b;
	}

	// Đếm phần tử
	public static int[] countElement(int[] b) {
		int[] c = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			c[i] = 0;
			for (int j = 0; j < b.length; j++) {
				if (b[i] == b[j]) {
					if (j < i) {
						break;
					} else {
						c[i] += 1;
					}
				}
			}
		}
		return c;
	}
	
	// Tìm giá trị xuất hiện nhiều nhất của mảng 2 chiều
	public static void appearTheMost(int[][] a, int row, int column) {
		int[] b =  convertArr2To1(a, row, column);
		int[]c = countElement(b);
		int max = c[0];
		for(int i = 0; i < b.length; i++) {
			if(max < c[i]) {
				max = c[i];
			}
		}
		System.out.print("\nSố xuất hiện nhiều nhất trong mảng (" + max + " lần):\t");
		for(int i = 0; i < b.length; i++) {
			if(c[i] == max) {
				System.out.print(b[i] + "\t");
			}
		}
	}
}
