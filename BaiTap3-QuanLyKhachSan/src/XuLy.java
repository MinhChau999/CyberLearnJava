import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
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
		System.out.println("5. Xuất danh sách từng loại hóa đơn");
		System.out.println("6. Các hóa đơn giờ được chuyển đổi từ giờ sang ngày");
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
				list.chuyenHDGioSangHDNgay(scan);
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
				list.outputTongTungLoaiHoaDon();
				break;
			case 5:
				list.outputTungLoaiHoaDon();
				break;
			case 6:
				System.out.println("*********** DANH SÁCH HÓA ĐƠN ĐƯỢC CHUYỂN ĐỔI **************");
				list.outputDSHDChuyenDoi();
				System.out.println("************************************************************");
				break;
			}
		} while (flag);
	}
}
