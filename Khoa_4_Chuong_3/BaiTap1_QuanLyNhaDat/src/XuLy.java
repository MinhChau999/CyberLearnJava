import java.text.ParseException;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		DanhSachGiaoDich list = new DanhSachGiaoDich();
		doMenu(scan, list);

	}

	public static void printMenu() {
		System.out.println("1. Dumydata");
		System.out.println("2. Nhập giao dịch");
		System.out.println("3. Xuất danh sách giao dịch");
		System.out.println("4. Tổng số lượng của từng loại giao dịch");
		System.out.println("5. Tính trung bình thành tiền của giao dịch đất");
		System.out.println("6. Xuất ra các giao dịch của tháng 9 năm 2013");
		System.out.println("0. Thoát");
	}

	public static void doMenu(Scanner scan, DanhSachGiaoDich list) throws ParseException {
		boolean flag = true;
		do {
			printMenu();
			System.out.print("Mời chọn: ");
			int chose = Integer.parseInt(scan.nextLine());
			switch (chose) {
			case 0:
				flag = false;
				break;
			case 1:
				list.dumyData();
				list.tinhTien();
				break;
			case 2:
				list.input(scan);
				break;
			case 3:
				System.out.println("**************** DANH SÁCH GIAO DỊCH ********************");
				list.output();
				System.out.println("*********************************************************");
				break;
			case 4:
				System.out.println("********* TỔNG SỐ LƯỢNG GIAO DỊCH CỦA TỪNG LOẠI **********");
				list.tinhTongSoLuongGDNhaDat();
				System.out.println("Tổng số lượng giao dịch đất: " + list.getTongSoLuongGDDat()
						+ "\nTổng số lượng giao dịch nhà: " + list.getTongSoLuongGDNha());
				System.out.println("***************************************************************");
				break;
			case 5:
				System.out.println("********* TRUNG BÌNH THÀNH TIỀN CỦA GIAO DỊCH ĐẤT **********");
				list.tinhTBThanhTienGDDat();
				System.out.println("***************************************************************");
				break;
			case 6:
				System.out.println("***** XUẤT CÁC GIAO DỊCH VÀO THÁNG 9 NĂM 2013 *******");
				list.outputGDTheoYeuCau();
				System.out.println("***************************************************************");
			}

		} while (flag);
	}
}
