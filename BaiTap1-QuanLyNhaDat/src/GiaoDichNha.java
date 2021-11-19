import java.text.ParseException;
import java.util.Scanner;

/*
 * Mục đích: Quản lý giao dịch nhà
 * Người tạo: Châu
 * Ngày tạo: 26/7/2021
 * Veesion: 1.0
 * 
 * */
public class GiaoDichNha extends GiaoDich {
	final float TY_GIA_NHA_THUONG = 0.9f;
	// 1. Attributes
	private int loaiNha;
	private String diaChi;
	// 2. Get, set methods

	/**
	 * @return the loaiNha
	 */
	public int getLoaiNha() {
		return loaiNha;
	}

	/**
	 * @param loaiNha the loaiNha to set
	 */
	public void setLoaiNha(int loaiNha) {
		this.loaiNha = loaiNha;
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

	// 3. Constructors
	public GiaoDichNha() {

	}

	public GiaoDichNha(int maGiaoDich, int ngay, int thang, int nam, float donGia, float dienTich, int loaiNha,
			String diaChi) throws ParseException {
		super(maGiaoDich, ngay, thang, nam, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	// 4. Input, output
	@Override
	public void input(Scanner scan) {
		super.input(scan);

		boolean flag = true;
		do {
			System.out.print("Nhập loại nhà \n1. Nhà cao cấp. \n2. Nhà thường\n");
			this.loaiNha = Integer.parseInt(scan.nextLine());
			if (this.loaiNha == 1 || this.loaiNha == 2) {
				flag = false;
			} else {
				System.out.println("Chỉ được nhập 1 hoặc 2. Vui lòng nhập lại.");
			}
		} while (flag);

		System.out.print("Địa chỉ: ");
		this.diaChi = scan.nextLine();
	}

	@Override
	public void output() {
		super.output();
		if (this.loaiNha == 1) {
			System.out.println("Đơn giá: " + formatNumCell(this.donGia) + "Loại nhà: " + formatTextCell("Cao cấp")
					+ "Diện tích: " + formatNumCell(this.dienTich) + "Giá: " + formatNumCell(this.thanhTien)
					+ "Địa chỉ: " + formatTextCell(this.diaChi));
		} else {
			System.out.println("Đơn giá: " + formatNumCell(this.donGia) + "Loại nhà: " + formatTextCell("Thường")
					+ "Diện tích: " + formatNumCell(this.dienTich) + "Giá: " + formatNumCell(this.thanhTien)
					+ "Địa chỉ: " + formatTextCell(this.diaChi));
		}
	}

	// 5. Business
	@Override
	public void tinhTien() {
		if (this.loaiNha == 1) {
			this.thanhTien = this.dienTich * this.donGia;
		} else {
			this.thanhTien = this.dienTich * this.donGia * TY_GIA_NHA_THUONG;
		}
	}
}
