import java.util.Scanner;

/*
 * Mục đích: Quản lý hóa đơn theo giờ
 * Người tạo: Châu
 * Ngày tạo: 29/07/2021
 * Version: 1.0
 * 
 * */
public class HoaDonGio extends HoaDon {
	public static final int SO_GIO_CHUYEN = 30;
	// 1. Attributes
	private int soGioThue;
	// 2. Get, set methods

	/**
	 * @return the soGioThue
	 */
	public int getSoGioThue() {
		return soGioThue;
	}

	/**
	 * @param soGioThue the soGioThue to set
	 */
	public void setSoGioThue(int soGioThue) {
		this.soGioThue = soGioThue;
	}

	// 3. Constructor
	public HoaDonGio() {

	}

	public HoaDonGio(int maHoaDon, String tenKhachHang, String ngayHoaDon, int maPhong, float donGia, int soGioThue) {
		super(maHoaDon, tenKhachHang, ngayHoaDon, maPhong, donGia);
		this.soGioThue = soGioThue;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Nhập giờ thuê: ");
		this.soGioThue = Integer.parseInt(scan.nextLine());

	}

	@Override
	public void output() {
		super.output();
		System.out.println("Số giờ thuê: " + this.soGioThue + "\t Thành tiền: " + this.thanhTien);
	}

	// 5. Business methods
	public HoaDon chuyenHDGioSangHDNgay(Scanner scan) {
		HoaDon hd = new HoaDonNgay();
		if (this.soGioThue > SO_GIO_CHUYEN) {
			hd.maHoaDon = this.maHoaDon;
			hd.tenKhachHang = this.tenKhachHang;
			hd.ngayHoaDon = this.ngayHoaDon;
			hd.maPhong = this.maPhong;
			System.out.print("Vui lòng nhập lại đơn giá tính theo ngày: ");
			hd.donGia = Integer.parseInt(scan.nextLine());
			((HoaDonNgay) hd).setSoNgayThue((int) Math.round(this.soGioThue / 24));
			System.out.println("Hoàn tất chuyển đổi!");
			System.out.println("--------------------");
		}
		return hd;
	}

	@Override
	public void tinhTien() {
		if (this.soGioThue < 24) {
			this.thanhTien = this.donGia * this.soGioThue;
		} else {
			this.thanhTien = this.donGia * 24;
		}
	}
}
