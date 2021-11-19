import java.util.Scanner;

public class XuLy {
	final static int MAX = 100;
	final static int MIN = -100;
	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		float[] a = createArr(scan);
		float [] a = intputArr(scan);
		outputArr(a);
		float max = maxNumber(a);
		System.out.println("Mảng sau khi xóa phần tử lớn nhất là" + max);
		a = deleteMax(a, max);
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
		public static float[] createArr(Scanner scan) {
			int n = inputN(scan);
			float[] a = new float[n];
			for (int i = 0; i < n; i++) {
				a[i] = MIN + (float) (Math.random() * ((MAX - MIN) + 1));
			}
			return a;
		}
		
		// Nhập mảng
		public static float[] intputArr(Scanner scan) {
			int n = inputN(scan);
			float[] a = new float[n];
			System.out.println("Nhập mảng:");
			for (int i = 0; i < n; i++) {
				System.out.print("a[" + i + "] = ");
				a[i] = Float.parseFloat(scan.nextLine());
			}
			return a;
		}


		// Xuất mảng
		public static void outputArr(float[] a) {
			for (float pt : a) {
				System.out.print(pt + "\t");
			}
			System.out.println("");
		}
		
		// Số lớn nhất trong mảng
		public static float maxNumber(float[] a) {
			float max = a[0];
			for(int i = 0; i<a.length ; i++) {
				if(a[i] > max) {
					max = a[i];
				}
			}
			return max;
		}
		
		// Đếm các số lớn nhất trong mảng
		public static int countMax(float[] a, float max) {
			int count = 0;
			for(float pt :a) {
				if(pt == max) {
					count += 1;
				}
			}
			return count;
		}
		
		// Xóa các số lớn nhất trong mảng
		public static float[] deleteMax(float[] a, float max) {
			int count = countMax(a, max);
			float[] b = new float[a.length - count];
			int j = 0;
			for(int i =0; i < a.length; i++) {
				if(a[i] != max) {
					b[j] = a[i];
					j++;
				}
			}
			return b;
		}
}
