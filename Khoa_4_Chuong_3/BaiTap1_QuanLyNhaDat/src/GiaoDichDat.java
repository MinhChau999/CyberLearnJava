import java.text.ParseException;
import java.util.Scanner;

/**
 * Mục đích: quản lý giao dịch đất. Người tạo: Châu. Ngày tạo: 26/7/2021.
 * Version: 1.0
 *
 */
public class GiaoDichDat extends GiaoDich {
	final float TY_GIA_DAT_A = 1.5f;
	final float TY_GIA_DAT_B = 1f;
	final float TY_GIA_DAT_C = 1f;

	// 1. Attributes
	private String loaiDat;

	// 2. Get, set
	/**
	 * @return the loaiDat
	 */
	public String getLoaiDat() {
		return loaiDat;
	}

	/**
	 * @param loaiDat the loaiDat to set
	 */
	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}

	// 3. Constructors
	public GiaoDichDat() {

	}

	/**
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 * @throws ParseException
	 */
	public GiaoDichDat(int maGiaoDich, int ngay, int thang, int nam, float donGia, float dienTich, String loaiDat)
			throws ParseException {
		super(maGiaoDich, ngay, thang, nam, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	// 4. Input, output
	@Override
	public void input(Scanner scan) {
		super.input(scan);

		boolean flag = true;
		do {
			System.out.print("Nhập loại đất (A, B, C): ");
			this.loaiDat = scan.nextLine();
			if (this.loaiDat.equals("A") || this.loaiDat.equals("B")
					|| this.loaiDat.equals("C")) {
				flag = false;
			} else {
				System.out.println("Chỉ được nhập 'A', 'B' hoặc 'C'. Vui lòng nhập lại.");
			}
		} while (flag);
	}

	@Override
	public void output() {
		super.output();
		System.out.println("Đơn giá: " + formatNumCell(this.donGia) + "Loại đất: " + formatTextCell(this.loaiDat)
				+ "Diện tích: " + formatNumCell(this.dienTich) + "Giá: " + formatNumCell(this.thanhTien));
	}

	// 5. Business method
	@Override
	public void tinhTien() {
		if (this.loaiDat.equals("A")) {
			this.thanhTien = this.dienTich * this.donGia * TY_GIA_DAT_A;
		} else if (this.loaiDat.equals("B")) {
			this.thanhTien = this.dienTich * this.donGia * TY_GIA_DAT_B;
		} else {
			this.thanhTien = this.dienTich * this.donGia * TY_GIA_DAT_C;
		}
	}
}
