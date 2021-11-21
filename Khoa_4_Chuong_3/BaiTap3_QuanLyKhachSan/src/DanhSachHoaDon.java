import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHoaDon {

	// 1. Attributes
	private ArrayList<HoaDon> listHoaDon;
	private ArrayList<HoaDon> listHDGioChuyenSangNgay;
	private int tongSoLuongHDNgay;
	private int tongSoLuongHDGio;

	// 2. Get set methods
	/**
	 * @return the listHoaDon
	 */
	public ArrayList<HoaDon> getListHoaDon() {
		return listHoaDon;
	}

	/**
	 * @param listHoaDon the listHoaDon to set
	 */
	public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
		this.listHoaDon = listHoaDon;
	}
	

	public ArrayList<HoaDon> getListHDGioChuyenSangNgay() {
		return listHDGioChuyenSangNgay;
	}

	public int getTongSoLuongHDNgay() {
		return tongSoLuongHDNgay;
	}

	public int getTongSoLuongHDGio() {
		return tongSoLuongHDGio;
	}

	// 3. Constructors
	public DanhSachHoaDon() {
		this.listHoaDon = new ArrayList<HoaDon>();
		this.listHDGioChuyenSangNgay = new ArrayList<HoaDon>();
	}

	/**
	 * @param listHoaDon
	 */
	public DanhSachHoaDon(ArrayList<HoaDon> listHoaDon) {
		this.listHoaDon = new ArrayList<HoaDon>();
		this.listHDGioChuyenSangNgay = new ArrayList<HoaDon>();
		this.listHoaDon = listHoaDon;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		int chose;
		boolean flag = true;
		do {
			// In menu
			chose = printMenu(scan);

			switch (chose) {
			case 0:
				flag = false;
				break;
			case 1:
				HoaDon hd = new HoaDonNgay();
				hd.input(scan);
				listHoaDon.add(hd);
				break;
			case 2:
				HoaDon hdGio = new HoaDonGio();
				hdGio.input(scan);
				if (((HoaDonGio) hdGio).getSoGioThue() <= 30) {
					listHoaDon.add(hdGio);
				} else {
					this.listHDGioChuyenSangNgay.add(hdGio);
					System.out.println("Chuyển đổi từ 'hóa đơn giờ' sang 'hóa đơn ngày'");
					HoaDon hdNgay = new HoaDonNgay();
					hdNgay = ((HoaDonGio) hdGio).chuyenHDGioSangHDNgay(scan);
					listHoaDon.add(hdNgay);
				}
				break;
			}
		} while (flag);

	}

	private int printMenu(Scanner scan) {
		int chose;
		boolean check = true;
		do {
			System.out.println("Nhập 1: Để nhập hóa đơn theo ngày");
			System.out.println("Nhập 2: Để nhập hóa đơn theo giờ");
			System.out.println("Nhập 0: Thoát");
			System.out.print("Mời chọn: ");
			chose = Integer.parseInt(scan.nextLine());
			if (chose == 1 || chose == 2 || chose == 0) {
				check = false;
			} else {
				System.out.println("Chỉ được nhập 1, 2 hoặc 0. Vui lòng nhập lại.");
			}
		} while (check);
		return chose;
	}

	public void output() {
		for (HoaDon hd : listHoaDon) {
			hd.output();
		}
	}

	public void dumyData() {
		HoaDon hd = new HoaDonNgay(1, "Tý", "22/07/2021", 101, 100, 3);
		this.listHoaDon.add(hd);

		hd = new HoaDonNgay(2, "Sửu", "12/06/2021", 103, 100, 2);
		this.listHoaDon.add(hd);

		hd = new HoaDonNgay(5, "Ngọ", "01/07/2021", 105, 100, 5);
		this.listHoaDon.add(hd);

		hd = new HoaDonNgay(7, "Hợi", "30/05/2021", 103, 100, 1);
		this.listHoaDon.add(hd);

		hd = new HoaDonNgay(10, "Ngũ", "03/07/2021", 102, 100, 2);
		this.listHoaDon.add(hd);

		hd = new HoaDonNgay(11, "Lục", "16/06/2021", 101, 100, 5);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(3, "Tam", "05/07/2021", 101, 5, 21);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(4, "Thất", "01/06/2021", 104, 5, 5);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(6, "Bát", "15/06/2021", 103, 5, 59);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(8, "Nhị", "14/07/2021", 102, 5, 18);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(9, "Nhất", "23/07/2021", 104, 5, 27);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(13, "BánhTT", "19/07/2021", 105, 5, 10);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(14, "BúnBGH", "20/6/2021", 105, 5, 34);
		this.listHoaDon.add(hd);

		hd = new HoaDonGio(12, "BòKBM", "29/07/2021", 103, 5, 30);
		this.listHoaDon.add(hd);
	}

	// 5. Business methods
	public void chuyenHDGioSangHDNgay(Scanner scan) {
		HoaDon hdNgay = new HoaDonNgay();
		for (int i = 0; i < this.listHoaDon.size(); i++) {
			HoaDon hd = this.listHoaDon.get(i);
			if (hd instanceof HoaDonGio) {
				if (((HoaDonGio) hd).getSoGioThue() > 30) {
					this.listHDGioChuyenSangNgay.add(hd);
					System.out.println("Mã HD " + hd.maHoaDon);
					System.out.println("Chuyển đổi từ 'hóa đơn giờ' sang 'hóa đơn ngày'");
					hdNgay = ((HoaDonGio) hd).chuyenHDGioSangHDNgay(scan);
					this.listHoaDon.add(hdNgay);
					this.listHoaDon.remove(i);
				}
			}
		}
	}

	public void tinhTien() {
		for (HoaDon hd : listHoaDon) {
			hd.tinhTien();
		}
	}

	public void tinhTongSoLuongHoaDon() {
		this.tongSoLuongHDNgay = 0;
		this.tongSoLuongHDGio = 0;
		for (HoaDon hd : listHoaDon) {
			if (hd instanceof HoaDonNgay) {
				this.tongSoLuongHDNgay++;
			}
			if (hd instanceof HoaDonGio) {
				this.tongSoLuongHDGio++;
			}
		}
	}
	
	public void outputTongTungLoaiHoaDon() {
		tinhTongSoLuongHoaDon();
		System.out.println("********* TỔNG TỪNG LOẠI HÓA ĐƠN *********");
		System.out.println("Tổng hóa đơn theo ngày: " +this.tongSoLuongHDNgay);
		System.out.println("Tổng hóa đơn theo giờ: " +this.tongSoLuongHDGio);
		System.out.println("******************************************");
	}
	
	public void outputTungLoaiHoaDon() {
		System.out.println("****** DANH SÁCH HÓA ĐƠN THEO NGÀY *******");
		for (HoaDon hd : listHoaDon) {
			if (hd instanceof HoaDonNgay) {
				hd.output();
			}
		}
		System.out.println("******************************************");
		System.out.println("****** DANH SÁCH HÓA ĐƠN THEO GIỜ ********");
		for (HoaDon hd : listHoaDon) {
			if (hd instanceof HoaDonGio) {
				hd.output();
			}
		}
		System.out.println("******************************************");
	}

	
	public void outputDSHDChuyenDoi() {
		for(HoaDon hd : listHDGioChuyenSangNgay) {
			hd.output();
		}
	}
}
