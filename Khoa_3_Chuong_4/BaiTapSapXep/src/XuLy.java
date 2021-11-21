import java.util.Scanner;

public class XuLy {
	final static int MAX = 100;
	final static int MIN = -100;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Phập số phần tử cho mang A và B (m,n>0):");
		System.out.print("n = ");
		int n = inputN(scan);
		int[] a = createArr(n);

		System.out.print("m = ");
		int m = inputN(scan);
		int[] b = createArr(m);
		
		outputArr(a);
		outputArr(b);

		// Sắp xếp 2 mảng a b tăng dần
		System.out.println("");
		System.out.println("Mảng A sắp xếp tăng dần: ");
		a = interchangeSort(a);
		outputArr(a);
		System.out.println("Mảng B sắp xếp tăng dần: ");
		b = bubbleSort(b);
		outputArr(b);
		
		// Xáo trộn 2 mảng a b được sắp xếp
		System.out.println("");
		System.out.println("Mảng C sau khi trộn 2 mảng A và B lại với nhau:");
		int[] c = mix2Array(a, b);
		outputArr(c);
		
		// Sắp xếp mảng c giảm dần
		System.out.println("Mảng C giảm dần:");
		quickSort(c, 0, c.length -1);
		outputArr(c);
	}

	// Nhập n có điều kiện
	public static int inputN(Scanner scan) {
		int n = 0;
		boolean flag = true;
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n > 0) {
				flag = false;
			} else {
				System.out.println("n không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		return n;
	}

	// Nhập mảng
	public static int[] intputArr(Scanner scan) {
		int n = inputN(scan);
		int[] a = new int[n];
		System.out.println("Nhập mảng:");
		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] = ");
			a[i] = Integer.parseInt(scan.nextLine());
		}
		return a;
	}

	// Tạo mảng ngẫu nhiên
	public static int[] createArr(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
		}
		return a;
	}

	// Xuất mảng
	public static void outputArr(int a[]) {
		for (int pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Thuật toán sắp xếp Interchange Sort tăng dần
	public static int[] interchangeSort(int[] a) {
		int temp;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	// Thuật toán sắp xếp Bubble Sort tăng dần
	public static int[] bubbleSort(int[] a) {
		int temp;
		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}

	// Xóa trộn 2 mảng tăng dần theo khuynh hướng giảm dần
	public static int[] mix2Array(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int j = 0;
		int q = a.length -1;
		int k = b.length -1;
		do {
			if(q >= 0) {
				c[j] = a[q];
				q--;
				j++;
			}
			if(k >= 0) {
				c[j] = b[k];
				k--;
				j++;
			}
		} while (j <a.length + b.length);
		return c;
	}
	
	// Thuật toán sắp xếp Quick Sort giảm dần
	public static void quickSort(int[] c, int left, int right) {
		int x = c[(left + right)/2];
		int i = left;
		int j = right;
		do {
			while(c[i] > x) {
				i++;
			}
			while(c[j] < x) {
				j--;
			}
			
			if(i <= j) {
				int temp = c[i];
				c[i] = c[j];
				c[j] = temp;
				i++;
				j--;
			}
		} while(i < j);
		if(j > left) {
			quickSort(c, left, j);
		}
		if(i < right) {
			quickSort(c, i, right);
		}
	}
}
