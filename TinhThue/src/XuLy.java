import java.util.Scanner;

public class XuLy {

	final static int THUE_SUAT_NHO_HON_1 = 5;
	final static int THUE_SUAT_1_2 = 10;
	final static int THUE_SUAT_2_3 = 15;
	final static int THUE_SUAT_3_4 = 20;
	final static int THUE_SUAT_4_5 = 25;
	final static int THUE_SUAT_5_6 = 30;
	final static int THUE_SUAT_LON_HON_6 = 35;

	final static int CA_NHAN = 4;
	final static float PHU_THUOC = 1.6f;

	final static int MUC_THUE_1 = 60;
	final static int MUC_THUE_2 = 120;
	final static int MUC_THUE_3 = 210;
	final static int MUC_THUE_4 = 384;
	final static int MUC_THUE_5 = 624;
	final static int MUC_THUE_6 = 960;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	// Hàm nhập họ tên
	public static char inputName(Scanner scan) {
		System.out.print("Vui lòng nhập họ tên của bạn: ");
		char name = scan.nextLine().charAt(0);
		return name;
	}

	// Hàm nhập tổng thu nhập
	public static float earnings(Scanner scan) {
		System.out.print("Vui lòng nhập tổng thu nhập 1 năm của bạn (triệu): ");
		float earnings = Float.parseFloat(scan.nextLine());
		return earnings;
	}

	// Hàm nhập số người phụ thuộc
	public static int numberOfRelatives(Scanner scan) {
		System.out.print("Vui lòng nhập số người phụ thuộc: ");
		int number = Integer.parseInt(scan.nextLine());
		return number;
	}

	// Hàm tính thu nhập chịu thuế
	public static float incomeTaxes(float earnings, int numberOfRelatives) {
		float incomeTaxes = earnings - CA_NHAN - numberOfRelatives * PHU_THUOC;
		return incomeTaxes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		char yourName = inputName(scan);
		float earnings = earnings(scan);
		int numberOfRelatives = numberOfRelatives(scan);
		float incomeTaxes = incomeTaxes(earnings, numberOfRelatives);
		float tax = tax(incomeTaxes);
		output(tax);
	}

	// Hàm tính tiền thuế
	public static float tax(float incomeTaxes) {
		float tax = 0;
		if (incomeTaxes <= MUC_THUE_1) {
			tax = incomeTaxes * 1.0f * THUE_SUAT_NHO_HON_1 / 100;
		} else if (incomeTaxes > MUC_THUE_1 && incomeTaxes <= MUC_THUE_2) {
			tax = MUC_THUE_1 * 1.0f * THUE_SUAT_NHO_HON_1 / 100
					+ (incomeTaxes - MUC_THUE_1) * 1.0f * THUE_SUAT_1_2 / 100;
		} else if (incomeTaxes > MUC_THUE_2 && incomeTaxes <= MUC_THUE_3) {
			tax = MUC_THUE_1 * 1.0f * THUE_SUAT_NHO_HON_1 / 100 + (MUC_THUE_2 - MUC_THUE_1) * 1.0f * THUE_SUAT_1_2 / 100
					+ (incomeTaxes - MUC_THUE_2) * 1.0f * THUE_SUAT_2_3 / 100;
		} else if (incomeTaxes > MUC_THUE_3 && incomeTaxes <= MUC_THUE_4) {
			tax = MUC_THUE_1 * 1.0f * THUE_SUAT_NHO_HON_1 / 100 + (MUC_THUE_2 - MUC_THUE_1) * 1.0f * THUE_SUAT_1_2 / 100
					+ (MUC_THUE_3 - MUC_THUE_2) * 1.0f * THUE_SUAT_2_3 / 100
					+ (incomeTaxes - MUC_THUE_3) * 1.0f * THUE_SUAT_3_4 / 100;
		} else if (incomeTaxes > MUC_THUE_4 && incomeTaxes <= MUC_THUE_5) {
			tax = MUC_THUE_1 * 1.0f * THUE_SUAT_NHO_HON_1 / 100 + (MUC_THUE_2 - MUC_THUE_1) * 1.0f * THUE_SUAT_1_2 / 100
					+ (MUC_THUE_3 - MUC_THUE_2) * 1.0f * THUE_SUAT_2_3 / 100
					+ (MUC_THUE_4 - MUC_THUE_3) * 1.0f * THUE_SUAT_3_4 / 100
					+ (incomeTaxes - MUC_THUE_4) * 1.0f * THUE_SUAT_4_5 / 100;
		} else if (incomeTaxes > MUC_THUE_5 && incomeTaxes <= MUC_THUE_6) {
			tax = MUC_THUE_1 * 1.0f * THUE_SUAT_NHO_HON_1 / 100 + (MUC_THUE_2 - MUC_THUE_1) * 1.0f * THUE_SUAT_1_2 / 100
					+ (MUC_THUE_3 - MUC_THUE_2) * 1.0f * THUE_SUAT_2_3 / 100
					+ (MUC_THUE_4 - MUC_THUE_3) * 1.0f * THUE_SUAT_3_4 / 100
					+ (MUC_THUE_5 - MUC_THUE_4) * 1.0f * THUE_SUAT_4_5 / 100
					+ (incomeTaxes - MUC_THUE_5) * 1.0f * THUE_SUAT_5_6 / 100;
		} else {
			tax = MUC_THUE_1 * 1.0f * THUE_SUAT_NHO_HON_1 / 100 + (MUC_THUE_2 - MUC_THUE_1) * 1.0f * THUE_SUAT_1_2 / 100
					+ (MUC_THUE_3 - MUC_THUE_2) * 1.0f * THUE_SUAT_2_3 / 100
					+ (MUC_THUE_4 - MUC_THUE_3) * 1.0f * THUE_SUAT_3_4 / 100
					+ (MUC_THUE_5 - MUC_THUE_4) * 1.0f * THUE_SUAT_4_5 / 100
					+ (MUC_THUE_6 - MUC_THUE_5) * 1.0f * THUE_SUAT_5_6 / 100 + (incomeTaxes - MUC_THUE_6)* 1.0f * THUE_SUAT_LON_HON_6 / 100;
		}
		return tax;
	}

	// Hàm xuất ra màn hình
	public static void output(float tax) {
		System.out.println("Tiền thuế bạn phải trả là: " + tax + " triệu đồng");
	}

}
