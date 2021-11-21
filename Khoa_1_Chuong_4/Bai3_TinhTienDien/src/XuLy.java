import java.util.Scanner;

public class XuLy {
	
	public static int MUC_1 = 50;
	public static int MUC_2 = 100;
	public static int MUC_3 = 200;
	public static int MUC_4 = 350;

	public static int TIEN_TRA_NHO_HON_1 = 500;
	public static int TIEN_TRA_1_2 = 650;
	public static int TIEN_TRA_2_3 = 850;
	public static int TIEN_TRA_3_4 = 1100;
	public static int TIEN_TRA_LON_HON_4 = 1300;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}
	
	// Hàm nhập tên
	public static char name(Scanner scan) {
		System.out.print("Vui lòng nhập tên của bạn: ");
		char name = scan.nextLine().charAt(0);
		return name;
	}
	
	// Hàm nhập số KW
	public static int numberKw(Scanner scan) {
		System.out.print("Vui lòng nhập số Kw: ");
		int numberKw = Integer.parseInt(scan.nextLine());
		return numberKw;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		char name = name(scan);
		int numberKw = numberKw(scan);
		int payment = payment(numberKw);
		output(payment);
	}
	
	// Hàm tính tiền điện
	public static int payment(int numberKw) {
		int payment = 0;
		if (numberKw <= MUC_1) {
			payment = numberKw * TIEN_TRA_NHO_HON_1;
		} else if (numberKw > MUC_1 && numberKw <= MUC_2) {
			payment = MUC_1 * TIEN_TRA_NHO_HON_1 + (numberKw - MUC_1) * TIEN_TRA_1_2;
		} else if (numberKw > MUC_2 && numberKw <= MUC_3) {
			payment = MUC_1 * TIEN_TRA_NHO_HON_1 + (MUC_2 - MUC_1) * TIEN_TRA_1_2
					+ (numberKw  - MUC_2) * TIEN_TRA_2_3;
		} else if (numberKw > MUC_3 && numberKw <= MUC_4) {
			payment = MUC_1 * TIEN_TRA_NHO_HON_1 + (MUC_2 - MUC_1) * TIEN_TRA_1_2
					+ (MUC_3 - MUC_2) * TIEN_TRA_2_3 + (numberKw - MUC_3) * TIEN_TRA_3_4;
		} else {
			payment = MUC_1 * TIEN_TRA_NHO_HON_1 + (MUC_2 - MUC_1) * TIEN_TRA_1_2
					+ (MUC_3 - MUC_2) * TIEN_TRA_2_3 + (MUC_4 - MUC_3) * TIEN_TRA_3_4
					+ (numberKw - MUC_4) * TIEN_TRA_LON_HON_4;
		}
		return payment;
	}
	
	// Hàm xuất ra màn hình
	public static void output(int payment) {
		System.out.println("Số tiền phải trả là: " + payment + " đồng");
	}

}
