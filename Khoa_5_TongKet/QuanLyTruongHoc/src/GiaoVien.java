
/*
 * Mục đích: Quản lý giáo viên
 * Người tạo: Châu
 * Ngày tạo: 3/8/2021
 * Version: 1.0
 * */
import java.util.Date;
import java.util.Scanner;

public class GiaoVien extends ThanhVien {
	// 1. Attributes
	private int namBatDauDay;
	private String chuyenMon;
	private int thamNien;
	// 2. Get, set methods

	public int getNamBatDauDay() {
		return namBatDauDay;
	}

	public void setNamBatDauDay(int namBatDauDay) {
		this.namBatDauDay = namBatDauDay;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public int getThamNien() {
		return thamNien;
	}

	// 3. Constructors
	public GiaoVien() {

	}

	public GiaoVien(String hoTen, String ngaySinh, String noiSinh, String diaChi, int namBatDauDay, String chuyenMon) {
		super(hoTen, ngaySinh, noiSinh, diaChi);
		this.namBatDauDay = namBatDauDay;
		this.chuyenMon = chuyenMon;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Nhập năm bắt đầu dạy: ");
		this.namBatDauDay = Integer.parseInt(scan.nextLine());

		System.out.println("Nhập chuyên môn: ");
		boolean flag = true;
		int chose;
		do {
			System.out.println("Chọn 1 hoặc 2");
			System.out.println("1. Tự nhiên");
			System.out.println("2. Xã hội");
			chose = Integer.parseInt(scan.nextLine());
			switch (chose) {
			case 1:
				this.chuyenMon = "Tự nhiên";
				flag = false;
				break;
			case 2:
				this.chuyenMon = "Xã hội";
				flag = false;
				break;
			default:
				System.out.println("Chỉ được nhập 1 hoặc 2. Vui lòng nhập lại.");
			}
		} while (flag);
	}

	@Override
	public void output() {
		super.output();
		System.out.println(" Năm bắt đầu dạy: " + String.format("%-8s", this.namBatDauDay) + " Chuyên môn: "
				+ String.format("%-18s", this.chuyenMon) + " Thâm niên: " + String.format("%-8s", this.thamNien));
	}

	// 5. Business methods
	@SuppressWarnings("deprecation")
	public void tinhNamGiangDay() {
		Date today = new Date();
		this.thamNien = today.getYear() + 1900 - this.namBatDauDay;
	}
}
