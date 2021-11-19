
import java.util.Date;
import java.util.Scanner;

/*
 * Mục đích: Quản lý giao dịch
 * Người tạo: Châu
 * Ngày tạo: 26/07/2021
 * Version: 1.0
 * 
 * */
public class GiaoDich {
	// 1. Attributes
	protected int maGiaoDich;
	protected Date ngayGiaoDich;
	protected float donGia;
	protected float dienTich;
	protected float thanhTien;
	// 2. Get, Set methods

	/**
	 * @return the maGiaoDich
	 */
	public int getMaGiaoDich() {
		return maGiaoDich;
	}

	/**
	 * @param maGiaoDich the maGiaoDich to set
	 */
	public void setMaGiaoDich(int maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	/**
	 * @return the ngayGiaoDich
	 */
	public Date getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	/**
	 * @param ngayGiaoDich the ngayGiaoDich to set
	 */
	public void setNgayGiaoDich(Date ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
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
	 * @return the dienTich
	 */
	public float getDienTich() {
		return dienTich;
	}

	/**
	 * @param dienTich the dienTich to set
	 */
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}

	/**
	 * @return the thanhTien
	 */
	public float getThanhTien() {
		return thanhTien;
	}

	// 3. Constructors
	public GiaoDich() {
		this.ngayGiaoDich = new Date();
	}

	/**
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 */
	@SuppressWarnings("deprecation")
	public GiaoDich(int maGiaoDich, int ngay, int thang, int nam, float donGia, float dienTich) {
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = new Date();
		this.ngayGiaoDich.setDate(ngay);
		this.ngayGiaoDich.setMonth(thang - 1);
		this.ngayGiaoDich.setYear(nam - 1900);
		this.donGia = donGia;
		this.dienTich = dienTich;
	}

	// 4. Input, output methods
	@SuppressWarnings("deprecation")
	public void input(Scanner scan) {
		System.out.print("Nhập mã: ");
		this.maGiaoDich = Integer.parseInt(scan.nextLine());

		System.out.println("Nhập ngày giao dịch: ");
		System.out.print("Ngày: ");
		int ngay = Integer.parseInt(scan.nextLine());
		this.ngayGiaoDich.setDate(ngay);
		System.out.print("Tháng: ");
		int thang = Integer.parseInt(scan.nextLine());
		this.ngayGiaoDich.setMonth(thang - 1);
		System.out.print("Năm: ");
		int nam = Integer.parseInt(scan.nextLine());
		this.ngayGiaoDich.setYear(nam - 1900);

		System.out.print("Nhập đơn giá: ");
		this.donGia = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập diện tích: ");
		this.dienTich = Float.parseFloat(scan.nextLine());

	}

	public void output() {
		System.out.print("Mã GD: " + String.format("%-4s", this.maGiaoDich));
		System.out.printf("%1$s %2$td/%2$tm/%2$tY", "Ngày GD:", this.ngayGiaoDich);
		System.out.print("\t  ");
	}

	// 5. Business Methods
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
