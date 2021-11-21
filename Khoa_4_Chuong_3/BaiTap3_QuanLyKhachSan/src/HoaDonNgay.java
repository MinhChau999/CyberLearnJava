import java.util.Scanner;

/*
 * Mục đích: Quản lý hóa đơn tính theo ngày
 * Người tạo: Châu
 * Ngày tạo: 29/07/2021
 * Version: 1.0
 * 
 * */
public class HoaDonNgay extends HoaDon {
	// 1. Attributes
	private int soNgayThue;

	// 2. Get set method
	/**
	 * @return the soNgayThue
	 */
	public int getSoNgayThue() {
		return soNgayThue;
	}

	/**
	 * @param soNgayThue the soNgayThue to set
	 */
	public void setSoNgayThue(int soNgayThue) {
		this.soNgayThue = soNgayThue;
	}

	// 3. Constructors
	public HoaDonNgay() {

	}

	public HoaDonNgay(int maHoaDon, String tenKhachHang, String ngayHoaDon, int maPhong, float donGia, int soNgayThue) {
		super(maHoaDon, tenKhachHang, ngayHoaDon, maPhong, donGia);
		this.soNgayThue = soNgayThue;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Nhập số ngày thuê: ");
		this.soNgayThue = Integer.parseInt(scan.nextLine());
	}

	@Override
	public void output() {
		super.output();
		System.out.println("Số ngày thuê: " + this.soNgayThue + "\t Thành tiền: " + formatNumCell(this.thanhTien));
	}

	// 5. Business methods
	@Override
	public void tinhTien() {
		this.thanhTien = this.donGia * this.soNgayThue;
	}
}
