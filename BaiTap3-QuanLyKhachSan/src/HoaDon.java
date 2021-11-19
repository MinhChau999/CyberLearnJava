import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Mục đích: Lớp super giúp quản lý hóa đơn
 * Người tạo: Châu
 * Ngày tạo: 29/7/2021
 * Version: 1.0
 * 
 * */
public class HoaDon {
	// 1. Attributes
	protected int maHoaDon;
	protected String tenKhachHang;
	protected Date ngayHoaDon;
	protected int maPhong;
	protected float donGia;
	protected float thanhTien;
	// 2. Get set methods

	/**
	 * @return the maHoaDon
	 */
	public int getMaHoaDon() {
		return maHoaDon;
	}

	/**
	 * @param maHoaDon the maHoaDon to set
	 */
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	/**
	 * @return the tenKhachHang
	 */
	public String getTenKhachHang() {
		return tenKhachHang;
	}

	/**
	 * @param tenKhachHang the tenKhachHang to set
	 */
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	/**
	 * @return the ngayHoaDon
	 */
	public Date getNgayHoaDon() {
		return ngayHoaDon;
	}

	/**
	 * @param ngayHoaDon the ngayHoaDon to set
	 */
	public void setNgayHoaDon(Date ngayHoaDon) {
		this.ngayHoaDon = ngayHoaDon;
	}

	/**
	 * @return the maPhong
	 */
	public int getMaPhong() {
		return maPhong;
	}

	/**
	 * @param maPhong the maPhong to set
	 */
	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	/**
	 * @return the donGia
	 */
	public float getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	/**
	 * @return the thanhTien
	 */
	public float getThanhTien() {
		return thanhTien;
	}

	// 3. Constructors
	public HoaDon() {

	}

	/**
	 * @param maHoaDon
	 * @param tenKhachHang
	 * @param ngayHoaDon
	 * @param maPhong
	 * @param donGia
	 */
	public HoaDon(int maHoaDon, String tenKhachHang, String ngayHoaDon, int maPhong, float donGia) {
		this.maHoaDon = maHoaDon;
		this.tenKhachHang = tenKhachHang;

		// Nhập ngày theo định dạng
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.ngayHoaDon = date.parse(ngayHoaDon);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.maPhong = maPhong;
		this.donGia = donGia;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		System.out.print("Nhập mã hóa đơn: ");
		this.maHoaDon = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập tên khách hàng: ");
		this.tenKhachHang = scan.nextLine();

		System.out.print("Nhập ngày ra hóa đơn (theo dạng dd/MM/yyyy): ");
		try {
			this.ngayHoaDon = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.print("Nhập mã phòng: ");
		this.maPhong = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập đơn giá: ");
		this.donGia = Float.parseFloat(scan.nextLine());

	}

	public void output() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Mã HD: " + String.format("%-6s", this.maHoaDon) + "Tên khách hàng: "
				+ formatTextCell(this.tenKhachHang) + "Ngày ra hóa đơn: " + formatter.format(this.ngayHoaDon)
				+ "\tMã phòng: " + String.format("%-6s", this.maPhong) + "Đơn giá: " + formatNumCell(this.donGia));
	}

	// 5. Business
	public void tinhTien() {
		this.thanhTien = 0;
	}

	public String formatNumCell(Number num) {
		// String paddLeft = "%5s";
		String paddLeft = "%-11s";
		return String.format(paddLeft, num);
	}

	public String formatTextCell(String text) {
		String paddLeft = "%-11s";
		return String.format(paddLeft, text);
	}
}
