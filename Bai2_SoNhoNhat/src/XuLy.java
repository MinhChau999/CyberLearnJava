
public class XuLy {
	final static int MAX_TOTAL = 10000;
	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int n = 0;
		int total = 0;
		while (total <= MAX_TOTAL) {
			n += 1;
			total += n;
		}

		System.out.println("Số nguyên dương nhỏ nhất: " + n);
		System.out.println("Với tổng các chữ số: " + total);
	}

}
