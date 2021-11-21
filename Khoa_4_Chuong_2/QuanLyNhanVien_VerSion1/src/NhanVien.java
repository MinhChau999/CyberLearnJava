/*
 * Mục đích: quản lý các nghiệp vụ liên quan đến nhân viên
 * Người tạo: Châu
 * Ngày tạo: 25/07/2021
 * Vertion: 1.0
 * 
 * */

import java.util.Date;
import java.util.Scanner;

public class NhanVien {

	// 1. Thuộc tính
	private int maNV;
	private String tenNV;
	private Date ngaySinh;
	private String diaChi;
	private float heSoLuong;
	private float luongCoBan;
	private float luongNV;

	// 2. Get, set method
	/**
	 * @return the maNV
	 */
	public int getMaNV() {
		return maNV;
	}

	/**
	 * @param maNV the maNV to set
	 */
	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	/**
	 * @return the tenNV
	 */
	public String getTenNV() {
		return tenNV;
	}

	/**
	 * @param tenNV the tenNV to set
	 */
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	/**
	 * @return the ngaySinh
	 */
	public Date getNgaySinh() {
		return ngaySinh;
	}

	/**
	 * @param ngaySinh the ngaySinh to set
	 */
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	/**
	 * @return the diaChi
	 */
	public String getDiaChi() {
		return diaChi;
	}

	/**
	 * @param diaChi the diaChi to set
	 */
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/**
	 * @return the heSoLuong
	 */
	public float getHeSoLuong() {
		return heSoLuong;
	}

	/**
	 * @param heSoLuong the heSoLuong to set
	 */
	public void setHeSoLuong(float heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	/**
	 * @return the luongCoBan
	 */
	public float getLuongCoBan() {
		return luongCoBan;
	}

	/**
	 * @param luongCoBan the luongCoBan to set
	 */
	public void setLuongCoBan(float luongCoBan) {
		this.luongCoBan = luongCoBan;
	}

	/**
	 * @return the luongNV
	 */
	public float getLuongNV() {
		return luongNV;
	}

	// 3. Constructors method (5 Constructors cho lớp NhanVien)
	public NhanVien() {
		this.ngaySinh = new Date(); 
	}
	
	public NhanVien(int ma) {
		this.ngaySinh = new Date(); 
		this.maNV = ma;
	}
	
	public NhanVien(String ten) {
		this.ngaySinh = new Date(); 
		this.tenNV = ten;
	}

	public NhanVien(int ma, String diachi) {
		this.ngaySinh = new Date(); 
		this.maNV = ma;
		this.diaChi = diachi;
	}

	@SuppressWarnings("deprecation")
	public NhanVien(int ma, String ten, String diaChi, int ngay, int thang, int nam, float heSoLuong, float luongCoBan) {
		this.ngaySinh = new Date(); 
		this.maNV = ma;
		this.tenNV = ten;
		this.diaChi = diaChi;
		this.ngaySinh = new Date();
		this.ngaySinh.setDate(ngay);
		this.ngaySinh.setMonth(thang);
		this.ngaySinh.setYear(nam);
		this.heSoLuong = heSoLuong;
		this.luongCoBan = luongCoBan;
	}

	// 4. Input, output method
	@SuppressWarnings("deprecation")
	public void input(Scanner scan) {
		System.out.print("Nhập mã nhân viên: ");
		this.maNV = Integer.parseInt(scan.nextLine());

		System.out.print("Nhập tên nhân viên: ");
		this.tenNV = scan.nextLine();

		System.out.println("Nhập ngày/tháng/năm sinh:");
		System.out.print("Ngày: ");
		int date = Integer.parseInt(scan.nextLine());
		this.ngaySinh.setDate(date);
		System.out.print("Tháng: ");
		int month = Integer.parseInt(scan.nextLine());
		this.ngaySinh.setMonth(month);
		System.out.print("Năm: ");
		int year = Integer.parseInt(scan.nextLine());
		this.ngaySinh.setYear(year);

		System.out.print("Nhập địa chỉ: ");
		this.diaChi = scan.nextLine();

		System.out.print("Nhập lương cơ bản: ");
		this.luongCoBan = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập hệ số lương: ");
		this.heSoLuong = Float.parseFloat(scan.nextLine());

	}

	public void output() {
		System.out.println("Mã NV: " + formatNumCell(this.maNV) + "Tên:" + formatTextCell(this.tenNV) + "Ngày sinh:"
				+ formatTextCell(this.ngaySinh.getDate() + "/" + this.ngaySinh.getMonth() + "/" + this.ngaySinh.getYear())
				+ "Địa chỉ:" + formatTextCell(this.diaChi) + "Tiền lương: " + formatNumCell(this.luongNV));
		System.out.println("-------------------------------------------------------------------------------------------------");
	}

	// 5. Business method
	public void tinhLuong() {
		this.luongNV = this.heSoLuong * this.luongCoBan;
	}

	private String formatNumCell(Number num) {
		//String paddLeft = "%5s";
		String paddLeft = "%-6s";
		return String.format(paddLeft, num);
	}
	
	private String formatTextCell(String text) {
		String paddLeft = "%-14s";
		return String.format(paddLeft, " " + text);
	}
}
