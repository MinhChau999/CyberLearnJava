import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: quản lý danh sách hóa đơn tiền điện
 * Người tạo: Châu
 * Ngày tạo: 28/07/2021
 * Version: 1.0
 * */
public class DanhSachHoaDon {
	// 1. Attributes
	private ArrayList<HoaDonKhachHang> listHoaDon;
	private int tongSoLuongHDVN;
	private int tongSoLuongHDNN;
	private float tongThanhTienHDNN;
	// 2. Get set methods

	/**
	 * @return the listHoaDon
	 */
	public ArrayList<HoaDonKhachHang> getListHoaDon() {
		return listHoaDon;
	}

	/**
	 * @param listHoaDon the listHoaDon to set
	 */
	public void setListHoaDon(ArrayList<HoaDonKhachHang> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}

	/**
	 * @return the tongSoLuongHDVN
	 */
	public int getTongSoLuongHDVN() {
		return tongSoLuongHDVN;
	}

	/**
	 * @return the tongSoLuongHDNN
	 */
	public int getTongSoLuongHDNN() {
		return tongSoLuongHDNN;
	}

	/**
	 * @return the tongThanhTienHDNN
	 */
	public float getTongThanhTienHDNN() {
		return tongThanhTienHDNN;
	}

	// 3. Constructor

	public DanhSachHoaDon() {
		this.listHoaDon = new ArrayList<HoaDonKhachHang>();
	}

	/**
	 * @param listHoaDon
	 */
	public DanhSachHoaDon(ArrayList<HoaDonKhachHang> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		int chose;
		boolean flag = true;
		do {
			chose = menuInputHoaDon(scan);

			switch (chose) {
			case 1:
				HoaDonKhachHang hoaDonVN = new KhachHangVietNam();
				hoaDonVN.input(scan);
				listHoaDon.add(hoaDonVN);
				break;
			case 2:
				HoaDonKhachHang hoaDonNN = new KhachHangNuocNgoai();
				hoaDonNN.input(scan);
				listHoaDon.add(hoaDonNN);
				break;
			case 0:
				flag = false;
				break;
			}

		} while (flag);
	}

	private int menuInputHoaDon(Scanner scan) {
		int chose;
		do {
			System.out.println("1. Nhập hóa đơn khách hàng Việt Nam\n2. Nhập hóa đơn khách hàng nước ngoài\n0. Thoát");
			System.out.print("Mời chọn: ");
			chose = Integer.parseInt(scan.nextLine());
			if (chose != 1 && chose != 2 && chose != 0) {
				System.out.println("Chỉ được nhập 1, 2 hoặc 0. Vui lòng nhập lại.");
			}
		} while (chose != 1 && chose != 2 && chose != 0);
		return chose;
	}

	public void output() {
		for (HoaDonKhachHang hd : listHoaDon) {
			hd.output();
		}
	}

	public void dumyData() {
		HoaDonKhachHang hd = new KhachHangVietNam(1, "Cam", "20/07/2013", "Sinh hoạt", 200, 120, 100);
		listHoaDon.add(hd);

		hd = new KhachHangVietNam(2, "Quýt", "01/09/2013", "Kinh doanh", 200, 400, 100);
		listHoaDon.add(hd);

		hd = new KhachHangVietNam(3, "Ổi", "28/03/2013", "Sản xuất", 200, 250, 100);
		listHoaDon.add(hd);

		hd = new KhachHangVietNam(4, "Nhãn", "18/02/2014", "Sinh hoạt", 200, 75, 100);
		listHoaDon.add(hd);

		hd = new KhachHangVietNam(5, "Vải", "25/12/2013", "Sản xuất", 200, 99, 100);
		listHoaDon.add(hd);

		hd = new KhachHangVietNam(6, "Bơ", "20/07/2013", "Sinh hoạt", 200, 145, 100);
		listHoaDon.add(hd);

		hd = new KhachHangVietNam(7, "Xoài", "29/01/2014", "Sinh hoạt", 200, 54, 100);
		listHoaDon.add(hd);

		hd = new KhachHangNuocNgoai(8, "Apple", "22/09/2013", "Argentina", 250, 300);
		listHoaDon.add(hd);

		hd = new KhachHangNuocNgoai(9, "Cherry", "15/11/2013", "Brazil", 250, 120);
		listHoaDon.add(hd);

		hd = new KhachHangNuocNgoai(10, "Mango", "11/09/2013", "Italy", 250, 88);
		listHoaDon.add(hd);

		hd = new KhachHangNuocNgoai(11, "Plum", "22/09/2013", "Hungary", 250, 240);
		listHoaDon.add(hd);

		hd = new KhachHangNuocNgoai(12, "Lychee", "30/01/2014", "Poland", 250, 300);
		listHoaDon.add(hd);

	}

	// 5. Business method
	public void tinhTien() {
		for (HoaDonKhachHang hd : listHoaDon) {
			hd.tinhTien();
		}
	}

	public void tinhTongSoLuongHoaDon() {
		this.tongSoLuongHDVN = 0;
		this.tongSoLuongHDNN = 0;
		for (HoaDonKhachHang gd : listHoaDon) {
			if (gd instanceof KhachHangVietNam) {
				this.tongSoLuongHDVN++;
			}
			if (gd instanceof KhachHangNuocNgoai) {
				this.tongSoLuongHDNN++;
			}
		}
	}

	public void tinhTBThanhTienHDNN() {
		this.tongThanhTienHDNN = 0;
		tinhTongSoLuongHoaDon();
		for (HoaDonKhachHang gd : listHoaDon) {
			if (gd instanceof KhachHangNuocNgoai) {
				this.tongThanhTienHDNN += gd.thanhTien;
			}
		}
		System.out.println("Trung bình thành tiền của hóa đơn khách hàng nước ngoài: "
				+ this.tongThanhTienHDNN / this.tongSoLuongHDNN + " $/hoadon");
	}
	
	@SuppressWarnings("deprecation")
	public void outputGDTheoYeuCau() {
		boolean flag = true;
		for (HoaDonKhachHang gd : listHoaDon) {
			if ( gd.ngayRaHoaDon.getMonth()+1 == 9 && (int) gd.ngayRaHoaDon.getYear() + 1900 == 2013) {
				gd.output();
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Không có giao dịch trong tháng 9 năm 2013.");
		}
	}
}
