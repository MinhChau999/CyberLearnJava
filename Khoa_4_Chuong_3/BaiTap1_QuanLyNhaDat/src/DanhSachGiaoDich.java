
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: quản lý danh sách các giao dịch nhà đất
 * Người tạo: Châu
 * Ngày tạo: 26/07/2021
 * Version: 1.0
 * 
 * */
public class DanhSachGiaoDich {
	final int THANG = 9;
	final int NAM = 2013;
	// 1. Attributes
	private ArrayList<GiaoDich> listGiaoDich;
	private int tongSoLuongGDNha;
	private int tongSoLuongGDDat;
	private float tongThanhTienGDDat;
	// 2. Get, set methods

	/**
	 * @return the listGiaoDich
	 */
	public ArrayList<GiaoDich> getListGiaoDich() {
		return listGiaoDich;
	}

	/**
	 * @param listGiaoDich the listGiaoDich to set
	 */
	public void setListGiaoDich(ArrayList<GiaoDich> listGiaoDich) {
		this.listGiaoDich = listGiaoDich;
	}

	/**
	 * @return the tongSoLuongGDNha
	 */
	public int getTongSoLuongGDNha() {
		return tongSoLuongGDNha;
	}

	/**
	 * @return the tongSoLuongGDDat
	 */
	public int getTongSoLuongGDDat() {
		return tongSoLuongGDDat;
	}

	/**
	 * @return the tbThanhTienGDDat
	 */
	public float getTbThanhTienGDDat() {
		return tongThanhTienGDDat;
	}

	// 3. Constructors
	public DanhSachGiaoDich() {
		this.listGiaoDich = new ArrayList<GiaoDich>();
	}

	/**
	 * @param listGiaoDich
	 */
	public DanhSachGiaoDich(ArrayList<GiaoDich> listGiaoDich) {
		this.listGiaoDich = listGiaoDich;
	}

	// 4. Input, output
	public void input(Scanner scan) {
		int chose;
		boolean flag = true;
		do {
			chose = menuInputGiaoDich(scan);

			switch (chose) {
			case 1:
				GiaoDich giaoDichDat = new GiaoDichDat();
				giaoDichDat.input(scan);
				giaoDichDat.tinhTien();
				listGiaoDich.add(giaoDichDat);
				break;
			case 2:
				GiaoDich giaoDichNha = new GiaoDichNha();
				giaoDichNha.input(scan);
				giaoDichNha.tinhTien();
				listGiaoDich.add(giaoDichNha);
				break;
			case 0:
				flag = false;
				break;
			}

		} while (flag);
	}

	private int menuInputGiaoDich(Scanner scan) {
		int chose;
		do {
			System.out.println("1. Nhập giao dịch đất\n2. Nhập giao dịch nhà\n0. Thoát");
			System.out.print("Mời chọn: ");
			chose = Integer.parseInt(scan.nextLine());
			if (chose != 1 && chose != 2 && chose != 0) {
				System.out.println("Chỉ được nhập 1 hoặc 2. Vui lòng nhập lại.");
			}
		} while (chose != 1 && chose != 2 && chose != 0);
		return chose;
	}

	public void output() {
		for (GiaoDich gd : listGiaoDich) {
			gd.output();
		}
	}

	public void dumyData() throws ParseException {
		GiaoDich gd = new GiaoDichDat(1, 27, 2, 2013, 100, 1500, "A");
		listGiaoDich.add(gd);

		gd = new GiaoDichDat(2, 20, 9, 2013, 200, 2200, "B");
		listGiaoDich.add(gd);

		gd = new GiaoDichDat(3, 02, 06, 2013, 210, 1800, "A");
		listGiaoDich.add(gd);

		gd = new GiaoDichNha(4, 02, 02, 2013, 1000, 200, 1, "Quận 1");
		listGiaoDich.add(gd);

		gd = new GiaoDichDat(5, 15, 9, 2013, 200, 2200, "B");
		listGiaoDich.add(gd);

		gd = new GiaoDichDat(6, 30, 07, 2013, 220, 5000, "A");
		listGiaoDich.add(gd);

		gd = new GiaoDichDat(7, 28, 02, 2013, 200, 3100, "B");
		listGiaoDich.add(gd);

		gd = new GiaoDichNha(8, 11, 9, 2013, 1000, 250, 2, "Quận 1");
		listGiaoDich.add(gd);

		gd = new GiaoDichNha(9, 9, 01, 2013, 1000, 260, 2, "Quận 10");
		listGiaoDich.add(gd);

		gd = new GiaoDichNha(10, 16, 07, 2013, 900, 170, 1, "Quận 12");
		listGiaoDich.add(gd);
	}

	// 5. Business methods
	public void tinhTien() {
		for (GiaoDich gd : listGiaoDich) {
			gd.tinhTien();
		}
	}

	/*
	 * 1. Tính tổng số lượng cho từng loại + Tính tổng số lượng giao dịch đất + Tính
	 * tổng số lượng giao dịch nhà + Xuất tổng số lượng từng loại
	 * 
	 */
	public void tinhTongSoLuongGDNhaDat() {
		this.tongSoLuongGDDat = 0;
		this.tongSoLuongGDNha = 0;
		for (GiaoDich gd : listGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				this.tongSoLuongGDDat++;
			}
			if (gd instanceof GiaoDichNha) {
				this.tongSoLuongGDNha++;
			}
		}
	}

	/**
	 * 2. Tính trung bình thành tiền của Giao dịch đất + Tính tổng số lượng giao
	 * dịch đất + Tính tổng thành tiền của Giao dịch đất + Tính trung bình thành
	 * tiền của giao dịch đất
	 */

	public void tinhTBThanhTienGDDat() {
		this.tongThanhTienGDDat = 0;
		tinhTongSoLuongGDNhaDat();
		for (GiaoDich gd : listGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				this.tongThanhTienGDDat += gd.thanhTien;
			}
		}
		System.out.println("Trung bình thành tiền của Giao dịch đất: " + this.tongThanhTienGDDat / this.tongSoLuongGDDat
				+ " $/giaodich");
	}

	/*
	 * 3. Xuất các giao dich vào tháng 9 năm 2013
	 * 
	 */

	@SuppressWarnings("deprecation")
	public void outputGDTheoYeuCau() {
		boolean flag = true;
		for (GiaoDich gd : listGiaoDich) {
			if ( gd.ngayGiaoDich.getMonth()+1 == THANG && (int) gd.ngayGiaoDich.getYear()+1900 == NAM) {
				gd.output();
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Không có giao dịch trong tháng 9 năm 2013.");
		}
	}
}
