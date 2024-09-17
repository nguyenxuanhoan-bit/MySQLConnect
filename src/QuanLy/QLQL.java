package QuanLy;

import java.util.Scanner;

import CauTrucDuLieu.LinkedList;
import DTO.QuanLy;

public class QLQL extends QuanLy {

	public QLQL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QLQL(String maQL, String hoTen, String sDT, String diaChi, String phuTrach, String matKhau) {
		super(maQL, hoTen, sDT, diaChi, phuTrach, matKhau);
		// TODO Auto-generated constructor stub
	}

	public static void hienThiTieuDe() {
		System.out.println("=----------------------------------------------------------------------------------=");
		System.out.println("| Ma QL  |      Họ tên      |  Số điện thoại  |  Dia chi  |  Chức vụ  |  Mật khẩu  | ");
		System.out.println("|----------------------------------------------------------------------------------|");
	}

	public void hienThiThongTinQL() {
		System.out.printf("|%8s|%18s|%17s|%11s|%11s|%12s|\n", maQL, hoTen, SDT, diaChi, phuTrach, matKhau);
	}

	public String dangNhapQuanLy(LinkedList lL) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=================Form Login=================");
		System.out.print("Vui lòng nhập mã quản lý (QLxxx): ");
		String maQL = sc.next();
		System.out.println("============================================");
		System.out.print("Vui lòng nhập mật khẩu: ");
		String matKhau = sc.next();
		System.out.println("============================================");

		if (lL.checkMatKhauQL(matKhau, maQL) != null)
			return maQL;
		else {
			System.err.println("Tai khoan hoac mat khau khong dung, vui long nhap lai!!!!");
			return null;
		}
	}

}