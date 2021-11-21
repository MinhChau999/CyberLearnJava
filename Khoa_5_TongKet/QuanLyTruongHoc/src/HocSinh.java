
/*
 * Mục đích: Quản lý học sinh
 * Người tạo: Châu
 * Ngày tạo: 3/8/2021
 * Versions: 1.0
 * 
 * */

import java.util.Scanner;

public class HocSinh extends ThanhVien {
	// 1. Attributes
	private float diemToan;
	private float diemVan;
	private float diemAnh;
	private float diemTB;
	private String xepLoai;

	// 2. Get, set

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemVan() {
		return diemVan;
	}

	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	public float getDiemAnh() {
		return diemAnh;
	}

	public void setDiemAnh(float diemAnh) {
		this.diemAnh = diemAnh;
	}

	public float getDiemTB() {
		return diemTB;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	// 3. Constructor
	public HocSinh() {

	}

	public HocSinh(String hoTen, String ngaySinh, String noiSinh, String diaChi, float diemToan, float diemVan,
			float diemAnh) {
		super(hoTen, ngaySinh, noiSinh, diaChi);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemAnh = diemAnh;

	}

	// 4. Input, output
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Nhập điểm Toán: ");
		this.diemToan = Float.parseFloat(scan.nextLine());
		System.out.print("Nhập điểm Van: ");
		this.diemVan = Float.parseFloat(scan.nextLine());
		System.out.print("Nhập điểm Anh: ");
		this.diemAnh = Float.parseFloat(scan.nextLine());
	}

	@Override
	public void output() {
		super.output();
		System.out.println(" Điểm Toán: " + String.format("%-8s", this.diemToan) + " Điểm Văn: "
				+ String.format("%-8s", this.diemVan) + " Điểm Anh: " + String.format("%-8s", this.diemAnh)
				+ " Điểm TB: " + String.format("%-8s", (float) Math.round(this.diemTB*10)/10) + " Xếp loại: "
				+ String.format("%-15s", this.xepLoai));
	}

	// 5. Business methods
	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemVan + this.diemAnh) / 3;
	}

	public void xepLoai() {
		if (this.diemTB >= 9) {
			this.xepLoai = "Xuất sắc";
		} else if (this.diemTB < 9 && this.diemTB >= 8) {
			this.xepLoai = "Giỏi";
		} else if (this.diemTB < 8 && this.diemTB >= 7) {
			this.xepLoai = "Khá";
		} else if (this.diemTB < 7 && this.diemTB >= 5) {
			this.xepLoai = "Trung bình";
		} else {
			this.xepLoai = "Yếu";
		}
	}
}
