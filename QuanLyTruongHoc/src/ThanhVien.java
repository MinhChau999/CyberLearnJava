import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Mục đích: quản lý thành viên trong trường học
 * Người tạo: Châu
 * Ngày tạo: 3/8/2021
 * Version: 1.0
 * 
 * */
public class ThanhVien {
	// 1. Attributes
	protected String hoTen;
	protected Date ngaySinh;
	protected String noiSinh;
	protected String diaChi;

	// 2. Get, set methods
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	// 3. Constructors
	public ThanhVien() {
	
	}

	/**
	 * @param hoTen
	 * @param ngaySinh
	 * @param noiSinh
	 * @param diaChi
	 */
	public ThanhVien(String hoTen, String ngaySinh, String noiSinh, String diaChi) {
		this.hoTen = hoTen;
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.ngaySinh = date.parse(ngaySinh);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		System.out.print("Họ và tên: ");
		this.hoTen = scan.nextLine();

		System.out.print("Nhập ngày sinh (theo dạng dd/MM/yyyy): ");
		try {
			this.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.print("Nơi sinh: ");
		this.noiSinh = scan.nextLine();

		System.out.print("Địa chỉ: ");
		this.diaChi = scan.nextLine();
	}

	public void output() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Họ và tên: " + String.format("%-24s", this.hoTen) + " Ngày sinh: " + String.format("%-15s",formatter.format(this.ngaySinh)) + " Nơi sinh: "
				+ String.format("%-10s",this.noiSinh) + " Địa chỉ: " + String.format("%-10s",this.diaChi));
	}

	//5. Business methods
	public String getFirstName() {
		String [] fullName = this.hoTen.split(" ");
		String name = fullName[fullName.length -1];
		return name;
	}
}
