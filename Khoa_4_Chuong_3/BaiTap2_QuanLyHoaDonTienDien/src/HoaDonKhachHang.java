import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Mục đích: Lớp super giúp quản lý hóa đơn khách hàng
 * người tạo:  Châu
 * Ngày tạo:28/7/2021
 * Version: 1.0
 * */
public class HoaDonKhachHang {

	// 1. Attributes
	protected int maHoaDon;
	protected String hoTen;
	protected Date ngayRaHoaDon;
	protected float donGia;
	protected float soLuong;
	protected float thanhTien;
	// 2 Get, set

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
	 * @return the hoTen
	 */
	public String getHoTen() {
		return hoTen;
	}

	/**
	 * @param hoTen the hoTen to set
	 */
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	/**
	 * @return the ngayRaHoaDon
	 */
	public Date getNgayRaHoaDon() {
		return ngayRaHoaDon;
	}

	/**
	 * @param ngayRaHoaDon the ngayRaHoaDon to set
	 */
	public void setNgayRaHoaDon(Date ngayRaHoaDon) {
		this.ngayRaHoaDon = ngayRaHoaDon;
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
	 * @return the soLuong
	 */
	public float getSoLuong() {
		return soLuong;
	}

	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}

	/**
	 * @return the thanhTien
	 */
	public float getThanhTien() {
		return thanhTien;
	}

	// 3. Constructors
	public HoaDonKhachHang() {

	}

	/**
	 * @param maHoaDon
	 * @param hoTen
	 * @param ngayRaHoaDon
	 * @param donGia
	 * @param soLuong
	 */
	public HoaDonKhachHang(int maHoaDon, String hoTen, Date ngayRaHoaDon, float donGia, float soLuong) {
		this.maHoaDon = maHoaDon;
		this.hoTen = hoTen;
		this.ngayRaHoaDon = ngayRaHoaDon;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public HoaDonKhachHang(int maHoaDon, String hoTen, String ngayRaHoaDon, float donGia, float soLuong) {
		this.maHoaDon = maHoaDon;
		this.hoTen = hoTen;

		// Nhập ngày theo định dạng
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.ngayRaHoaDon = date.parse(ngayRaHoaDon);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	// 4. Input, output
	public void input(Scanner scan) {
		System.out.print("Nhập mã hóa đơn: ");
		this.maHoaDon = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập họ và tên: ");
		this.hoTen = scan.nextLine();

		System.out.println("Nhập ngày ra hóa đơn theo dạng dd/MM/yyyy (ví dụ 23/02/2013): ");
		try {
			this.ngayRaHoaDon = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void output() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Mã HD: " + String.format("%-5s", this.maHoaDon) + "Tên: " + formatTextCell(this.hoTen)
				+ "Ngày ra hóa đơn: " + formatter.format(this.ngayRaHoaDon) + "\t");
	}

	// 5. Business methods
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
