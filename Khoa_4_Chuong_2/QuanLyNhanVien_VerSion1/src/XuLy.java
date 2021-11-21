
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CongTy congty = new CongTy();
		doMenu(scan, congty);

	}

	public static void printMenu() {
		System.out.println("1. Data nhân viên.");
		System.out.println("2. Nhập thêm nhân viên.");
		System.out.println("3. Xuất danh sách nhân viên.");
		System.out.println("4. Tổng lương của tất cả nhân viên.");
		System.out.println("5. Lương nhân viên cao nhất.");
		System.out.println("0. Thoát");
	}

	public static void doMenu(Scanner scan, CongTy congty) {
		boolean flag = true;
		do {
			printMenu();
			System.out.print("Mời chọn: ");
			int chose = Integer.parseInt(scan.nextLine());
			switch (chose) {
			case 1:
				congty.data();
				congty.tinhLuong();
				break;
			case 2:
				NhanVien nv = new NhanVien();
				nv.input(scan);
				congty.add(nv);
				break;			
			case 3:
				System.out.println("**** Danh sách nhân viên toàn công ty ******");
				congty.tinhLuong();
				congty.output();
				break;
			case 4: 
				congty.tinhLuong();
				congty.tinhTongLuong();
				System.out.println("Tổng tiền lương của tất cả nhân viên trong công ty: " + congty.getDsnvToanCongTy().getTongTienLuong());
				break;
			case 5:
				System.out.println("**** Nhân viên có lương cao nhất *****");
				congty.tinhLuong();
				congty.outputListNVLuongCaoNhat();
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}
}
