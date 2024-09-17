package QuanLy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import CauTrucDuLieu.DoubleLinkedList;
import CauTrucDuLieu.NodeDoubleL;
import DTO.SanPham;
import DoAn.DAO1;

public class QLSP extends SanPham {
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public QLSP() {
		super();
	}

	public QLSP(String maSP, String tenSP, int soLuong, Date ngayNhapHang, int donGia) {
		super(maSP, tenSP, soLuong, ngayNhapHang, donGia);
	}

	public void hienThiThongTinSP() {
		System.out.printf("|%8s|%30s|%12s|%15s|%11s|\n", maSP, tenSP, soLuong, df.format(ngayNhapHang), donGia);
	}

	public static void hienThiTieuDe() {
		System.out.println("=--------------------------------------------------------------------------------=");
		System.out.println("| Mã SP  |            Tên SP            |  Số lượng  | Ngày nhập hàng |  Đơn giá |");
		System.out.println("=--------------------------------------------------------------------------------=");
	}

	public void nhapThongTin(DoubleLinkedList dLL, NodeDoubleL node) {
		df.setLenient(false);
		Scanner sc = new Scanner(System.in);

		while (true) {
			while (true) {
				try {
					System.out.println("Nhập mã sản phẩm :");
					maSP = sc.nextLine();
					if (maSP.length() != 5)
						System.out.println("Mã SP phải gồm 5 kí tự và có dạng 'SPxxx'!!!");
					else
						break;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			boolean check = setMaSP(maSP);
			if (check) {
				NodeDoubleL currNode = dLL.checkSP(node, maSP);
				if (currNode != null)
					System.err.println("Da ton tai!!");
				else
					break;
			}
		}

		System.out.println("Nhập tên sản phẩm: ");
		tenSP = sc.nextLine();
		while (true) {
			try {
				System.out.println("Nhập số lượng sản phẩm: ");
				soLuong = Integer.parseInt(sc.nextLine());
				if (soLuong >= 0)
					break;
				else
					System.out.println("Vui lòng nhập dạng số!!!!");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập dạng số!!!!");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập ngày nhập hàng(yyyy-MM-dd): ");
				ngayNhapHang = df.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.err.println("Ban da nhap sai!!!! ");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập đơn giá sản phẩm: ");
				donGia = Integer.parseInt(sc.nextLine());
				if (donGia >= 0)
					break;
				else
					System.err.println("Vui lòng nhập dạng số!!!!");
			} catch (Exception e) {
				System.err.println("Vui lòng nhập dạng số!!!!");
			}
		}

	}
	public void nhapThongTinSua(DoubleLinkedList dLL, NodeDoubleL node) {
		df.setLenient(false);
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập tên sản phẩm: ");
		tenSP = sc.nextLine();
		System.out.println("Nhập số lượng: ");
		soLuong = sc.nextInt();
		sc.nextLine();
		while (true) {
			try {
				System.out.println("Nhập ngày nhập hàng(yyyy-MM-dd): ");
				ngayNhapHang = df.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.err.println("Ban da nhap sai!!! ");
			}
		}
		System.out.println("Nhập đơn giá: ");
		donGia = sc.nextInt();

	}

	public static void hamNhapThongTin(DoubleLinkedList dLL, NodeDoubleL node) {
		QLSP qLSP = new QLSP();
		qLSP.nhapThongTin(dLL, node);
		NodeDoubleL nodeDLL = new NodeDoubleL(qLSP);
		dLL.insertTail(nodeDLL);

	}
}