import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Tạo ra để quản lý danh sách nhân viên
 * Người tạo: Châu
 * Ngày tạo: 25/7/2021
 * Version: 1.0
 * 
*/
public class DanhSachNhanVien {

	// 1. Thuộc tính
	private ArrayList<NhanVien> listNV;
	private float tongTienLuong;
	
	// 2. Get, set method
	
	/**
	 * @return the listNV
	 */
	public ArrayList<NhanVien> getListNV() {
		return listNV;
	}

	/**
	 * @param listNV the listNV to set
	 */
	public void setListNV(ArrayList<NhanVien> listNV) {
		this.listNV = listNV;
	}
	
	// 3. Constructor method

	/**
	 * @return the tongTienLuong
	 */
	public float getTongTienLuong() {
		return tongTienLuong;
	}

	public DanhSachNhanVien() {
		thietLapDefaut();
		
	}
	
	private void thietLapDefaut() {
		this.listNV = new ArrayList<NhanVien>();
	}
	
	// 4. Input, output method
	public void input(Scanner scan) {
		for(NhanVien nv : this.listNV) {
			nv.input(scan);
		}
	}
	public void add(NhanVien nv) {
		this.listNV.add(nv);
	}
	
	public void output() {
		for(NhanVien nv : this.listNV) {
			nv.output();
		}
	}
	
	// 5. Business method
	public void tinhLuong() {
		for(NhanVien nv : this.listNV) {
			nv.tinhLuong();
		}
	}
	
	public void tinhTongLuong() {
		for(NhanVien nv : this.listNV) {
			this.tongTienLuong += nv.getLuongNV();
		}
	}

}
