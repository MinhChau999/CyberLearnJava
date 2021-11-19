import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int win = 0;
		int lose = 0;
		int draw = 0;
		boolean flag = true;
		do {
			int man = man(scan);
			int bot = bot();

			// so sánh và kết luận
			if (man == bot) {
				draw += 1;
				youBot(man, bot);
				System.out.println("Draw result!");
			} else if (man == 1 && bot == 2 || man == 2 && bot == 3 || man == 3 && bot == 1) {
				lose += 1;
				youBot(man, bot);
				System.out.println("You Lose!");
			} else {
				win += 1;
				youBot(man, bot);
				System.out.println("You Win!");
			}

			// Nhập số bất kì để chơi tiếp hoặc 0 để dừng lại
			System.out.println("Nhập số bất kì để chơi tiếp hoặc 0 để dừng lại.");
			int chose = Integer.parseInt(scan.nextLine());
			if (chose == 0) {
				flag = false;
			}
		} while (flag);

		if (win > lose) {
			System.out.println("Bạn đã chiến thắng!\nVới tỷ số:\nWin:" + win + " Lose:" + lose + " Draw:" + draw);
		} else if (win < lose) {
			System.out.println("Bạn đã thất bại!\nVới tỷ số:\nWin:" + win + " Lose:" + lose + " Draw:" + draw);
		} else {
			System.out.println("Kết quả hòa!\nVới tỷ số:\nWin:" + win + " Lose:" + lose + " Draw:" + draw);
		}

	}

	public static int man(Scanner scan) {
		boolean flag = true;
		int man = 0;
		do {
			System.out.println("Lựa chọn:");
			System.out.println("1.Kéo 2.Búa 3.Bao");
			man = Integer.parseInt(scan.nextLine());
			if(man == 1 || man == 2|| man ==3) {
				flag = false;
			} else {
				System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập lại");
			}
		} while (flag);
		return man;
	}

	public static int bot() {
		return (int) Math.floor(Math.random() * 3) + 1;
	}

	// hàm in ra "kéo búa bao"
	public static void display(int man) {
		if (man == 1) {
			System.out.println("Kéo");
		} else if (man == 2) {
			System.out.println("Búa");
		} else {
			System.out.println("Bao");
		}
	}

	public static void youBot(int man, int bot) {
		System.out.print("You: ");
		display(man);
		System.out.print("Bot: ");
		display(bot);
	}
}
