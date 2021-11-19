import java.util.Scanner;

public class XuLy {
	final static int MAX = 1000;
	final static int MIN = -1000;

	public XuLy() {

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float[] a = createArr(scan);
		outputArr(a);
		total(a);

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

	// Xuất mảng
	public static void outputArr(float[] a) {
		for (float pt : a) {
			System.out.print(pt + "\t");
		}
		System.out.println("");
	}

	// Kiểm tra giá trị lớn hơn trị tuyệt đối của số đứng sau nó
	public static int index(float[] a) {
		int index = -1;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > (float) Math.abs(a[i + 1])) {
				index = i;
				break;
			}
		}
		return index;
	}

	// Tính tổng giá trị lớn hơn trị tuyệt đối của giá trị số đứng sau nó
	public static void total(float[] a) {
		int index = index(a);
		float total = 0;
		if (index == -1) {
			System.out.println("Không có giá trị lớn hơn trị tuyệt đối của giá trị số đứng sau nó");
		} else {
			System.out.println("Các cặp giá trị thỏa yêu cầu:");
			for (int i = index; i < a.length - 1; i++) {
				if (a[i] > (float) Math.abs(a[i + 1])) {
					total += a[i];
					System.out.print("("+a[i]+", "+a[i+1]+")\t");
				}
			}
			System.out.println("\nTổng giá trị lớn hơn trị tuyệt đối của giá trị số đứng sau nó: " + total);
		}
	}
}
