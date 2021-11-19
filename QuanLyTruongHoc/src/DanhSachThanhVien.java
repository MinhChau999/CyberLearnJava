import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachThanhVien {
	// 1. Attributes
	ArrayList<ThanhVien> listThanhVien;
	// 2. Get set methods

	public ArrayList<ThanhVien> getListThanhVien() {
		return listThanhVien;
	}

	public void setListThanhVien(ArrayList<ThanhVien> listThanhVien) {
		this.listThanhVien = listThanhVien;
	}

	// 3. Constructors
	public DanhSachThanhVien() {
		this.listThanhVien = new ArrayList<ThanhVien>();
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		boolean flag = true;
		int chose;
		do {
			chose = choseScan(scan);
			switch (chose) {
			case 1:
				ThanhVien gv = new GiaoVien();
				gv.input(scan);
				((GiaoVien) gv).tinhNamGiangDay();
				listThanhVien.add(gv);
				break;
			case 2:
				ThanhVien hs = new HocSinh();
				hs.input(scan);
				((HocSinh) hs).tinhDiemTB();
				((HocSinh) hs).xepLoai();
				listThanhVien.add(hs);
				break;
			case 0:
				flag = false;
				break;
			}

		} while (flag);
	}

	private int choseScan(Scanner scan) {
		int chose;
		do {
			System.out.println("Chọn: ");
			System.out.println("1. Nhập Giáo viên.");
			System.out.println("2. Nhập Học sinh.");
			System.out.println("0. Thoát");
			chose = Integer.parseInt(scan.nextLine());
			if (chose != 1 && chose != 2 && chose != 0) {
				System.out.println("Chỉ được nhập 1, 2 hoặc 0. Vui lòng nhập lại");
			}
		} while (chose != 1 && chose != 2 && chose != 0);
		return chose;
	}

	public void output() {
		for (ThanhVien tv : listThanhVien) {
			tv.output();
		}
	}

	// 5. Business
	public void taoDuLieu() throws NumberFormatException, IOException {
		try {
			FileReader reader = new FileReader("src/DSTV.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" ; ");

				ThanhVien tv;
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {
					tv = new GiaoVien(listInfo[0], listInfo[1], listInfo[2], listInfo[3], Integer.parseInt(listInfo[4]),
							listInfo[5]);
					this.listThanhVien.add(tv);
				} else {
					tv = new HocSinh(listInfo[0], listInfo[1], listInfo[2], listInfo[3], Float.parseFloat(listInfo[4]),
							Float.parseFloat(listInfo[5]), Float.parseFloat(listInfo[6]));
					this.listThanhVien.add(tv);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void tinhNamGiangDay() {
		for (ThanhVien tv : this.listThanhVien) {
			if (tv instanceof GiaoVien) {
				((GiaoVien) tv).tinhNamGiangDay();
			}
		}
	}

	public void tinhDiemTB() {
		for (ThanhVien tv : this.listThanhVien) {
			if (tv instanceof HocSinh) {
				((HocSinh) tv).tinhDiemTB();
			}
		}
	}

	public void xepLoai() {
		for (ThanhVien tv : this.listThanhVien) {
			if (tv instanceof HocSinh) {
				((HocSinh) tv).xepLoai();
			}
		}
	}

	// Thuật toán Bubble Sort
	public void bubbleSort(ArrayList<ThanhVien> _list) {
		int i, j;
		boolean haveSwap = false;
		for (i = 0; i < _list.size() - 1; i++) {
			haveSwap = false;
			for (j = 0; j < _list.size() - i - 1; j++) {
				if (_list.get(j).getFirstName()
						.compareToIgnoreCase(_list.get(j + 1).getFirstName()) > 0) {
					Collections.swap(_list, j, j+1);
					haveSwap = true;
				}

			}
			if (haveSwap == false) {
				break;
			}
		}
	}
	
	// Sắp sếp tên ABC
	public void sapXepTenAB() {
		bubbleSort(this.listThanhVien);
	}

	
	// Thuật toán Quick Sort
	private void quickSort(ArrayList<ThanhVien> _list, int left, int right) {
		ThanhVien hs = new HocSinh();
		hs = _list.get((right + left) / 2);
		float x = ((HocSinh) hs).getDiemTB();
		int i = left;
		int j = right;
		do {
			while (((HocSinh) _list.get(i)).getDiemTB() > x) {
				i++;
			}
			while (((HocSinh) _list.get(j)).getDiemTB() < x) {
				j--;
			}

			if (i <= j) {
				ThanhVien temp = _list.get(i);
				_list.set(i, _list.get(j));
				_list.set(j, temp);
				i++;
				j--;
			}
		} while (i < j);
		if (j > left) {
			quickSort(_list, left, j);
		}
		if (i < right) {
			quickSort(_list, i, right);
		}
	}
	
	// Sắp xếp điểm TB giảm dần
	public void sapXepDiemTBGiamDan() {
		quickSort(listThanhVien, 0, listThanhVien.size()-1);
	}
}
