import java.util.Date;
import java.util.Scanner;

public class KhachHangNuocNgoai extends HoaDonKhachHang {
	// 1. Attributes
	private String quocTich;
	// 2. Get set method

	/**
	 * @return the quocTich
	 */
	public String getQuocTich() {
		return quocTich;
	}

	/**
	 * @param quocTich the quocTich to set
	 */
	public void setQuocTich(String quocTich) {
		this.quocTich = quocTich;
	}

	// 3. Constructor

	public KhachHangNuocNgoai() {
		// TODO Auto-generated constructor stub
	}

	public KhachHangNuocNgoai(int maHoaDon, String hoTen, Date ngayRaHoaDon, String quocTich, float donGia,
			float soLuong) {
		super(maHoaDon, hoTen, ngayRaHoaDon, donGia, soLuong);
		this.quocTich = quocTich;
	}

	public KhachHangNuocNgoai(int maHoaDon, String hoTen, String ngayRaHoaDon, String quocTich, float donGia,
			float soLuong) {
		super(maHoaDon, hoTen, ngayRaHoaDon, donGia, soLuong);
		this.quocTich = quocTich;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Nhập quốc tịch: ");
		this.quocTich = scan.nextLine();

		System.out.print("Nhập đơn giá: ");
		this.donGia = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập số lượng: ");
		this.soLuong = Float.parseFloat(scan.nextLine());
	}

	@Override
	public void output() {
		super.output();
		System.out.println("Quốc tịch: " + String.format("%-13s",this.quocTich) + "   Đơn giá: " + formatNumCell(this.donGia) + "Số lượng: " + formatNumCell(this.soLuong)
				+ "Thành tiền: " + formatNumCell(this.thanhTien));
	}

	// 5. Business
	@Override
	public void tinhTien() {
		this.thanhTien = this.donGia * this.soLuong;
	}
}
