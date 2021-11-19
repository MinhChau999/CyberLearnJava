
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DanhSachHoaDon list = new DanhSachHoaDon();
		doMenu(scan, list);
	}

	public static void printMenu() {
		System.out.println("1. Dumydata");
		System.out.println("2. Nhập hóa đơn");
		System.out.println("3. Xuất danh sách hóa đơn");
		System.out.println("4. Tổng số lượng của từng loại hóa đơn");
		System.out.println("5. Tính trung bình thành tiền của hóa đơn khách hàng nước ngoài");
		System.out.println("6. Xuất ra các hóa đơn của tháng 9 năm 2013");
		System.out.println("0. Thoát");
	}

	public static void doMenu(Scanner scan, DanhSachHoaDon list) {
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
				list.tinhTien();
				break;
			case 3:
				System.out.println("**************** DANH SÁCH HÓA ĐƠN ********************");
				list.output();
				System.out.println("*********************************************************");
				break;
			case 4:
				System.out.println("********* TỔNG SỐ LƯỢNG HÓA ĐƠN TỪNG LOẠI **********");
				list.tinhTongSoLuongHoaDon();
				System.out.println("Tổng số lượng hóa đơn khách hàng Việt Nam: " + list.getTongSoLuongHDVN()
						+ "\nTổng số lượng hóa đơn khách hàng nước ngoài: " + list.getTongSoLuongHDNN());
				System.out.println("**********************************************************");
				break;
			case 5:
				System.out.println("********* TRUNG BÌNH THÀNH TIỀN CỦA HÓA ĐƠN NƯỚC NGOÀI **********");
				list.tinhTBThanhTienHDNN();
				;
				System.out.println("**********************************************************");
				break;
			case 6:
				System.out.println("***** XUẤT CÁC GIAO DỊCH CỦA THÁNG 9 NĂM 2013 *******");
				list.outputGDTheoYeuCau();
				System.out.println("**********************************************************");
				break;
			}

		} while (flag);
	}
}
