
/*
 * Mục đích: quản lý hóa đơn khách hàng việt nam
 * Người tạo: Châu
 * Ngày tạo: 28/7/2021
 * Version: 1.0
 * 
 * */
import java.util.Date;
import java.util.Scanner;

public class KhachHangVietNam extends HoaDonKhachHang {
	final float TY_GIA_VUOT_DINH_MUC = 2.5f;
	// 1. Attributes
	private String doiTuong;
	private float dinhMuc;

	// 2. Get, set
	/**
	 * @return the doiTuong
	 */
	public String getDoiTuong() {
		return doiTuong;
	}

	/**
	 * @param doiTuong the doiTuong to set
	 */
	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}

	/**
	 * @return the dinhMuc
	 */
	public float getDinhMuc() {
		return dinhMuc;
	}

	/**
	 * @param dinhMuc the dinhMuc to set
	 */
	public void setDinhMuc(float dinhMuc) {
		this.dinhMuc = dinhMuc;
	}

	// 3. Constructor
	public KhachHangVietNam() {
		// TODO Auto-generated constructor stub
	}

	public KhachHangVietNam(int maHoaDon, String hoTen, Date ngayRaHoaDon, String doiTuong, float donGia, float soLuong,
			float dinhMuc) {
		super(maHoaDon, hoTen, ngayRaHoaDon, donGia, soLuong);
		this.doiTuong = doiTuong;
		this.dinhMuc = dinhMuc;
	}

	public KhachHangVietNam(int maHoaDon, String hoTen, String ngayRaHoaDon, String doiTuong, float donGia,
			float soLuong, float dinhMuc) {
		super(maHoaDon, hoTen, ngayRaHoaDon, donGia, soLuong);
		this.doiTuong = doiTuong;
		this.dinhMuc = dinhMuc;
	}

	// 4. Input, output
	@Override
	public void input(Scanner scan) {
		super.input(scan);

		boolean flag = true;
		do {
			System.out
					.println("Nhập 1, 2 hoặc 3\n1. Đối tượng sinh hoạt\n2. Đối tượng kinh doanh\n3. Đối tượng sản xuất");
			int doiTuong = Integer.parseInt(scan.nextLine());
			if (doiTuong == 1) {
				this.doiTuong = "Sinh hoạt";
				flag = false;
			} else if (doiTuong == 2) {
				this.doiTuong = "Sinh hoạt";
				flag = false;
			} else if (doiTuong == 3) {
				this.doiTuong = "Sinh hoạt";
				flag = false;
			} else {
				System.out.println("Chỉ được nhập 1, 2 hoặc 3. Vui lòng nhập lại");
			}
		} while (flag);

		System.out.print("Nhập đơn giá: ");
		this.donGia = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập số lượng: ");
		this.soLuong = Float.parseFloat(scan.nextLine());

		System.out.print("Nhập định mức: ");
		this.dinhMuc = Float.parseFloat(scan.nextLine());
	}

	@Override
	public void output() {
		super.output();
		System.out.println("Đối tượng: " + String.format("%-13s",this.doiTuong) + "Đơn giá: " + formatNumCell(this.donGia) + "Số lượng: " + formatNumCell(this.soLuong)
				 + "Thành tiền: " + formatNumCell(this.thanhTien)+ "Định mức: " + formatNumCell(this.dinhMuc));
	}

	// 5. Business
	@Override
	public void tinhTien() {
		if (this.soLuong <= this.dinhMuc) {
			this.thanhTien = this.soLuong * this.donGia;
		} else {
			this.thanhTien = this.dinhMuc * this.donGia + (this.soLuong - this.dinhMuc) * this.donGia * TY_GIA_VUOT_DINH_MUC;
		}
	}
}
