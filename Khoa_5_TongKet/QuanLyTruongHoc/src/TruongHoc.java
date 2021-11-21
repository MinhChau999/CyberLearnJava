
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: quản lý trường học với danh sách thành viên
 * Người tạo: Châu
 * Ngày tạo: 3/8/2021
 * Version: 1.0
 * */
public class TruongHoc {

	// .1 Attributes
	DanhSachThanhVien objDSThanhVien;
	DanhSachThanhVien listGiaoVien;
	DanhSachThanhVien listHocSinh;
	// 2. Get, set methods

	public DanhSachThanhVien getObjDSThanhVien() {
		return objDSThanhVien;
	}

	public void setObjDSThanhVien(DanhSachThanhVien objDSThanhVien) {
		this.objDSThanhVien = objDSThanhVien;
	}

	public DanhSachThanhVien getListGiaoVien() {
		return listGiaoVien;
	}

	public DanhSachThanhVien getListHocSinh() {
		return listHocSinh;
	}

	// 3. Constructors
	public TruongHoc() {
		this.objDSThanhVien = new DanhSachThanhVien();
		this.listGiaoVien = new DanhSachThanhVien();
		this.listHocSinh = new DanhSachThanhVien();
	}

	// 4. Input, output
	public void input(Scanner scan) {
		this.objDSThanhVien.input(scan);
	}

	public void outputDSToanTruong() {
		this.objDSThanhVien.output();
	}

	public void outputDSGiaoVien() {
		System.out.println("Danh Sách Giáo Viên");
		this.listGiaoVien.output();
	}

	public void outputDSHocSinh() {
		System.out.println("Danh Sách Học Sinh");
		this.listHocSinh.output();
	}

	// 5. Business methods
	public void taoDuLieu() throws NumberFormatException, IOException {
		this.objDSThanhVien = new DanhSachThanhVien();
		this.objDSThanhVien.taoDuLieu();
	}

	public void taoDSGiaoVienVaDSHocSinh() {
		this.listGiaoVien.listThanhVien.clear();
		this.listHocSinh.listThanhVien.clear();
		for (ThanhVien tv : this.objDSThanhVien.listThanhVien) {
			if (tv instanceof GiaoVien) {
				this.listGiaoVien.listThanhVien.add(tv);
			}
			if (tv instanceof HocSinh) {
				this.listHocSinh.listThanhVien.add(tv);
			}
		}
	}

	// Câu 6. Viết phương thức tính năm giảng dạy của Giáo viên
	public void tinhNamGiangDay() {
		this.objDSThanhVien.tinhNamGiangDay();
	}

	// Câu 9. Viết phương thức tính điểm Trung bình của học sinh
	public void tinhDiemTB() {
		this.objDSThanhVien.tinhDiemTB();
	}

	// Câu 12. Phương thức xếp loại học sinh
	public void xepLoai() {
		this.objDSThanhVien.xepLoai();
	}

	// Câu 7. Phương thức tìm giáo viên có thâm niên cao nhất
	public void thamNienCaoNhat() {
		// Tìm giáo viên đầu tiên thâm niên cao nhất
		ThanhVien gvMax = this.listGiaoVien.listThanhVien.get(0);
		int indexMax = 0;
		int i = 0;
		for (ThanhVien gv : this.listGiaoVien.listThanhVien) {

			if (((GiaoVien) gv).getThamNien() > ((GiaoVien) gvMax).getThamNien()) {
				gvMax = gv;
				indexMax = i;
			}
			i++;
		}
		// Xuất các giáo viên có thâm niên cao nhất
		System.out.println("***** Giáo viên có thâm niên cao nhất ******");
		for (int j = indexMax; j < this.listGiaoVien.listThanhVien.size(); j++) {
			ThanhVien gv = this.listGiaoVien.listThanhVien.get(j);
			if (((GiaoVien) gv).getThamNien() == ((GiaoVien) gvMax).getThamNien()) {
				gv.output();
			}
		}
	}

	// Câu 8. Phương thức tìm giáo viên có thâm niên > 5 năm và chuyên môn tự nhiên
	public void thamNien5NamVaKhoiTuNhien() {
		System.out.println("***** Giáo viên có thâm niên hơn 5 năm và thuộc khối tự nhiên *****");
		for (ThanhVien gv : listGiaoVien.listThanhVien) {
			if (((GiaoVien) gv).getThamNien() > 5 && ((GiaoVien) gv).getChuyenMon().equalsIgnoreCase("Tự nhiên")) {
				gv.output();
			}
		}
	}

	// Câu 10. Phương thức tìm điểm trung bình cao nhất của Học Sinh
	private int diemTBCaoNhat() {
		int indexMax = 0;
		ThanhVien hsMax = this.listHocSinh.listThanhVien.get(0);
		for (int i = 1; i < this.listHocSinh.listThanhVien.size(); i++) {
			if (((HocSinh) hsMax).getDiemTB() < ((HocSinh) listHocSinh.listThanhVien.get(i)).getDiemTB()) {
				hsMax = listHocSinh.listThanhVien.get(i);
				indexMax = i;
			}
		}
		return indexMax;
	}

	public void xuatDiemTBCaoNhat() {
		int index = diemTBCaoNhat();
		System.out.println("Điểm trung bình cao nhất: " + ((HocSinh) listHocSinh.listThanhVien.get(index)).getDiemTB());
	}

	// Câu 11. Phương thức tìm Học Sinh có điểm trung bình cao nhất
	public void hocSinhDiemTBCaoNhat() {
		int indexMax = diemTBCaoNhat();
		System.out.println("***** Học sinh có điểm Trung Bình cao nhất ******");
		ThanhVien hsMax = this.listHocSinh.listThanhVien.get(indexMax);
		for (int i = indexMax; i < this.listHocSinh.listThanhVien.size(); i++) {
			if (((HocSinh) hsMax).getDiemTB() == ((HocSinh) listHocSinh.listThanhVien.get(i)).getDiemTB()) {
				listHocSinh.listThanhVien.get(i).output();
			}
		}
	}

	// 11. Sắp xết điểm trung bình giảm dần
	public void sapXepDiemTBGiamDan() {
		listHocSinh.sapXepDiemTBGiamDan();
		;
		System.out.println("Học Sinh được sắp xếp theo điểm Trung Bình giảm dần");
		this.listHocSinh.output();
	}

	// 12. Sắp xếp tên học sinh theo AlphaBeta
	public void sapXepTenHocSinh() {
		listHocSinh.sapXepTenAB();
		System.out.println("Tên học sinh sắp xếp theo thứ tự AlphaBeta");
		this.listHocSinh.output();
	}

	public void thanks() {
		System.out.println("LỜI CẢM ƠN");
		System.out.println(
				"Cám ơn anh/chị mentor đã đồng hành cùng em trong thời gian qua!\nEm dự tính sẽ theo mảng AI hoặc BackEnd trong thời gian sắp tới.\nChúc các anh chị luôn mạnh khỏe ạ, đặc biệt là trong mùa dịch này.\nMong CyberLearn ngày càng phát triển hơn để giúp đỡ thật nhiều người bước trên con đường IT;))\nThanks very much!\nPs : Do em đang trong mùa ôn thi nên dự án cuối khóa không làm hoành tá tràng được...code hơi dở tý xếu...mong mentor chấm nương tay^^");
	}
}
