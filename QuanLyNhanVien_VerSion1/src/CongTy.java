
import java.util.Scanner;

/*
 * Mục đích: Tạo ra để quản lý nhân viên trong công ty
 * Người tạo: Châu
 * Ngày tạo: 25/7/2021
 * Version: 1.0
 * 
 * */
public class CongTy {

	// 1. Attributes
	private DanhSachNhanVien dsnvToanCongTy;
	private DanhSachNhanVien dsnvLuongCaoNhat;
	// 2. Get, set method.
	public DanhSachNhanVien getDsnvToanCongTy() {
		return this.dsnvToanCongTy;
	}

	public void setDsnvToanCongTy(DanhSachNhanVien dsnvToanCongTy) {
		this.dsnvToanCongTy = dsnvToanCongTy;
	}

	/**
	 * @return the dsnvLuongCaoNhat
	 */
	public DanhSachNhanVien getDsnvLuongCaoNhat() {
		return dsnvLuongCaoNhat;
	}

	// 3. Constructors
	public CongTy() {
		this.dsnvToanCongTy = new DanhSachNhanVien();

	}

	// 4. Input, output method.
	public void data() {
		NhanVien nv = new NhanVien(1, "Bút Chì", "nhà trắng", 10, 9, 2002, 1.5f, 10000);
		this.dsnvToanCongTy.add(nv);

		nv = new NhanVien(2, "Thước", "nhà đen", 1, 1, 2002, 1.2f, 10000);
		this.dsnvToanCongTy.add(nv);

		nv = new NhanVien(3, "Compa", "nhà vàng", 15, 7, 1994, 1.1f, 10000);
		this.dsnvToanCongTy.add(nv);

		nv = new NhanVien(4, "Bút Bi", "nhà đỏ", 23, 10, 2000, 1, 10000);
		this.dsnvToanCongTy.add(nv);

		nv = new NhanVien(5, "Gôm", "nhà cam", 11, 3, 1996, 2f, 10000);
		this.dsnvToanCongTy.add(nv);

		nv = new NhanVien(6, "Vở", "nhà tím", 9, 2, 1999, 1, 10000);
		this.dsnvToanCongTy.add(nv);
		
		nv = new NhanVien(7, "Máy tính", "nhà đen", 9, 11, 1997, 2.0f, 10000);
		this.dsnvToanCongTy.add(nv);

	}

	public void input(Scanner scan) {
		this.dsnvToanCongTy.input(scan);
	}

	public void output() {
		this.dsnvToanCongTy.output();
	}

	public void add(NhanVien nv) {
		this.dsnvToanCongTy.add(nv);
	}

	// 5. Business methods
	public void tinhLuong() {
		this.dsnvToanCongTy.tinhLuong();
	}

	public void tinhTongLuong() {
		this.dsnvToanCongTy.tinhTongLuong();
	}

	// Nhân viên có lương cao nhất
	public DanhSachNhanVien listNVLuongCaoNhat() {
		DanhSachNhanVien list = new DanhSachNhanVien();
		
		if (this.dsnvToanCongTy.getListNV().size() > 0) {
			NhanVien nvMax = this.dsnvToanCongTy.getListNV().get(0);
			int indexMax = 0;
			
			// Nhân viên đầu tiên có lương cao nhất
			for (int i = 1; i < this.dsnvToanCongTy.getListNV().size(); i++) {
				NhanVien nvCurrent = this.dsnvToanCongTy.getListNV().get(i);
				if(nvCurrent.getLuongNV() > nvMax.getLuongNV()) {
					nvMax = nvCurrent;
					indexMax = i;
				}
			}
			
			for(int i = indexMax; i < this.dsnvToanCongTy.getListNV().size(); i++) {
				NhanVien nvCurrent = this.dsnvToanCongTy.getListNV().get(i);
				if(nvCurrent.getLuongNV() == nvMax.getLuongNV()) {
					list.add(nvCurrent);
				}
			}
		}
		return list;
	}
	
	// Xuất danh sách nhân viên lương cao nhất
	public void outputListNVLuongCaoNhat() {
//		this.dsnvLuongCaoNhat = new DanhSachNhanVien();
		this.dsnvLuongCaoNhat = listNVLuongCaoNhat();
		this.dsnvLuongCaoNhat.output();	
	}
}
