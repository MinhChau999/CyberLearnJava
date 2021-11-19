import java.io.IOException;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scan = new Scanner(System.in);
		TruongHoc truong = new TruongHoc();
		doMenu(scan, truong);
	}

	public static void printMenu() {
		System.out.println("1. Tạo dữ liệu");
		System.out.println("2. Nhập thành viên");
		System.out.println("3. Xuất danh danh sách toàn trường");
		System.out.println("4. Xuất danh danh sách Giáo iên");
		System.out.println("5. Xuất danh danh sách Học sinh");
		System.out.println("6. Xuất Giáo viên có thâm niên cao nhất");
		System.out.println("7. Xuất Giáo viên trên 5 năm và chuyên môn là xã hội");
		System.out.println("8. Xuất điểm Trung bình cao nhất của Học Sinh");
		System.out.println("9. Xuất Học sinh có điểm Trung bình cao nhất");
		System.out.println("10. Sắp xếp Học sinh có số điểm Trung Bình giảm dần");
		System.out.println("11. Sắp xếp Học sinh theo thứ tự chữ cái ABC");
		System.out.println("0. Thoát");
	}

	public static void doMenu(Scanner scan, TruongHoc truong) throws NumberFormatException, IOException {
		boolean flag = true;
		do {
			printMenu();
			System.out.print("Mời chọn: ");
			int chose = Integer.parseInt(scan.nextLine());
			switch (chose) {
			case 0:
				truong.thanks();
				flag = false;
				break;
			case 1:
				truong.taoDuLieu();
				truong.tinhNamGiangDay();
				truong.tinhDiemTB();
				truong.xepLoai();
				truong.taoDSGiaoVienVaDSHocSinh();
				break;
			case 2:
				truong.input(scan);
				truong.taoDSGiaoVienVaDSHocSinh();
				break;
			case 3:
				truong.outputDSToanTruong();
				break;
			case 4:
				truong.outputDSGiaoVien();
				break;
			case 5:
				truong.outputDSHocSinh();
				break;
			case 6:
				truong.thamNienCaoNhat();
				break;
			case 7: 
				truong.thamNien5NamVaKhoiTuNhien();
				break;
			case 8:
				truong.xuatDiemTBCaoNhat();
				break;
			case 9:
				truong.hocSinhDiemTBCaoNhat();
				break;
			case 10: 
				truong.sapXepDiemTBGiamDan();
				break;
			case 11:
				truong.sapXepTenHocSinh();
				break;
			}

		} while (flag);
	}
}
