import java.util.Scanner;

public class XuLy {
	
	final static float BILL_FEE_1 = 4.5f;
	final static float BILL_FEE_2 = 15;
	final static float SERVICE_CHAGRE_1 = 20.5f;
	final static float SERVICE_CHAGRE_2 = 75;
	final static float CHANNEL_FEE_1 = 7.5f;
	final static float CHANNEL_FEE_2 = 50;
	
	final static float EXTRA_CONECTION_FEE_2 = 5;
	
	
	public XuLy() {
		// TODO Auto-generated constructor stub
	}
	// Hàm nhập mã khách hàng
	public static char customerCode(Scanner scan) {
		System.out.print("Vui lòng nhập mã khách hàng của bạn: ");
		char code = scan.nextLine().charAt(0);
		return code;
	}
	
	// Hàm nhập số tài khoản
	public static char accountNumber(Scanner scan) {
		System.out.print("Vui lòng nhập số tài khoản của bạn: ");
		char number = scan.nextLine().charAt(0);
		return number;
	}
	
	// Hàm nhập loại khách hàng
	public static int custumerType(Scanner scan) {
		System.out.println("Vui lòng nhập loại khách hàng: \nNhập 1 với khách hàng nhà dân \nNhập 2 với khách hàng doanh nghiệp");
		int type = Integer.parseInt(scan.nextLine());
		return type;
	}
	
	// Hàm nhập số kênh thuê cao cấp
	public static int premiumChannel(Scanner scan) {
		System.out.print("Vui lòng nhập số kênh thuê cao cấp: ");
		int number = Integer.parseInt(scan.nextLine());
		return number;
	}
	
	// Hàm nhập kết nối thêm cho doanh nghiệp
	public static int addConection(Scanner scan, int custumerType) {
		int add=0;
		if (custumerType == 2) {
			System.out.print("Vui lòng nhập số kết nối thêm cho doanh nghiệp của bạn: ");
			add = Integer.parseInt(scan.nextLine());
		} else {
			add = 0;
		}
		return add;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		char custumerCode = customerCode(scan);
		char accountNumber = accountNumber(scan);
		int custumerTyppe = custumerType(scan);
		int premiumChannel = premiumChannel(scan);
		int addConection = addConection(scan, custumerTyppe);
		float finalFee = finalFee(custumerTyppe, premiumChannel, addConection);
		output(finalFee);
		
	}
	
	// Hàm tính chi phí tổng
	public static float finalFee(int custumerType, int premiumChannel, int addConection) {
		float fee = 0;
		if(custumerType == 1) {
			fee = BILL_FEE_1 + SERVICE_CHAGRE_1 + premiumChannel*CHANNEL_FEE_1;
		} else {
			fee = BILL_FEE_2 + SERVICE_CHAGRE_2 + premiumChannel*CHANNEL_FEE_2 + addConection*EXTRA_CONECTION_FEE_2;
		}
		return fee;
	}
	
	// Hàm hiện kết quả phí hóa đơn khách hàng
	public static void output(float finalFee) {
		System.out.println("Chi phí bạn phải trả là: "+ finalFee +"$");
	}

}
