import java.util.Scanner;

public class XuLy {
	static final float KHU_VUC_A = 2;
	static final float KHU_VUC_B = 1;
	static final float KHU_VUC_C = 0.5f;

	static final float DOI_TUONG_1 = 2.5f;
	static final float DOI_TUONG_2 = 1.5f;
	static final float DOI_TUONG_3 = 1;

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập điểm chuẩn của hội đồng: ");
		float diemChuan = nhapDiem(scan);
		System.out.print("Vui lòng nhập điểm Môn 1: ");
		float diemMon1 = nhapDiem(scan);
		System.out.print("Vui lòng nhập điểm Môn 2: ");
		float diemMon2 = nhapDiem(scan);
		System.out.print("Vui lòng nhập điểm Môn 3: ");
		float diemMon3 = nhapDiem(scan);
		char khuVuc = khuVuc(scan);
		int doiTuong = (int) doiTuong(scan);

		if (diemMon1 == 0 || diemMon2 == 0 || diemMon3 == 0) {
			System.out.println("Sorry! Bạn không đủ điều kiện để trúng tuyển!\nCó ít nhất 1 môn của bạn 0 điểm.");
		} else {
			float diemUuTien = diemUuTien(khuVuc, doiTuong);
			float diemTong = diemTong(diemMon1, diemMon2, diemMon3, diemUuTien);
			ketQua(diemTong, diemChuan);
		}
	}

	// Hàm nhập điểm 3 môn
	public static float nhapDiem(Scanner scan) {
		float diem;
		diem = Float.parseFloat(scan.nextLine());
		return diem;
	}

	// Hàm nhập khu vực thi
	public static char khuVuc(Scanner scan) {
		System.out.println("Vui lòng nhập khu vực thi: ");
		System.out.println("Nhập A khi bạn ở khu vực A (2 điểm)");
		System.out.println("Nhập B khi bạn ở khu vực B (1 điểm)");
		System.out.println("Nhập C khi bạn ở khu vực C (0.5 điểm)");
		System.out.println("Nhập X khi bạn không thuộc khu vực ưu tiên");
		char khuVuc = scan.next().charAt(0);
		return khuVuc;
	}

	// Hàm nhập đối tượng thi
	public static int doiTuong(Scanner scan) {
		System.out.println("Vui lòng nhập đối tượng dự thi: ");
		System.out.println("Nhập 1 nếu bạn ở đối tượng 1 (2.5 điểm)");
		System.out.println("Nhập 2 nếu bạn ở đối tượng 2 (1.5 điểm)");
		System.out.println("Nhập 3 nếu bạn ở đối tượng 3 (1 điểm)");
		System.out.println("Nhập 0 nếu bạn không thuộc đối tượng ưu tiên ");
		int doiTuong = Integer.parseInt(scan.next());
		return doiTuong;
	}

	// Hàm tính điểm ưu tiên
	public static float diemUuTien(char khuVuc, int doiTuong) {
		float tong = 0;
		if (khuVuc == 'A') {
			tong += KHU_VUC_A;
		} else if (khuVuc == 'B') {
			tong += KHU_VUC_B;
		} else if (khuVuc == 'C') {
			tong += KHU_VUC_C;
		} else {
			tong += 0; // System.out.println("Bạn không thuộc vào khu vực ưu tiên.");
		}

		if (doiTuong == 1) {
			tong += DOI_TUONG_1;
		} else if (doiTuong == 2) {
			tong += DOI_TUONG_2;
		} else if (doiTuong == 3) {
			tong += DOI_TUONG_3;
		} else {
			tong += 0; // System.out.println("Bạn không thuộc đối tượng ưu tiên.");
		}
		return tong;
	}

	// Hàm tính điểm tổng
	public static float diemTong(float diemMon1, float diemMon2, float diemMon3, float diemUuTien) {
		float tong = 0;
		tong = diemMon1 + diemMon2 + diemMon3 + diemUuTien;
		return tong;
	}

	public static void ketQua(float diemTong, float diemChuan) {
		boolean flag = true;

		// so sánh điểm chuẩn và điểm tổng
		if (diemTong < diemChuan) {
			flag = false;
		}

		// Xuất ra màn hình kết quả đậu, rớt.
		if (flag) {
			System.out.println("Congratulation! Bạn đã trúng tuyển!");
			System.out.println("Tổng số điểm của bạn là " + diemTong + (" điểm."));
		} else {
			System.out.println("Sorry! Bạn không đủ điều kiện để trúng tuyển!");
			System.out.println("Tổng số điểm của bạn là " + diemTong + (" điểm."));
		}
	}
}
