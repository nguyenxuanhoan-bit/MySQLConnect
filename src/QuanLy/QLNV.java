package QuanLy;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import CauTrucDuLieu.NodeDoubleL;
import CauTrucDuLieu.Tree;
import CauTrucDuLieu.TreeNode;
import DTO.NhanVien;
import DoAn.DAO1;

public class QLNV extends NhanVien {
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public QLNV() {
		super();
	}

	public QLNV(int maNV, String tenNV, String SDT, int tuoi, float luong, Date ngayLamViec) {
		super(maNV, tenNV, SDT, tuoi, luong, ngayLamViec);
	}

	public void hienThiThongTinNV() {
		System.out.printf("|%5s|%15s|%11s|%7s|%13s|%15s|\n", maNV, tenNV, SDT, tuoi, luong, df.format(ngayLamViec));
		System.out.println("-------------------------------------------------------------------------");
	}

	public static void hienThiTieuDeNV() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("|Mã NV|     Tên NV    |    SDT    |  Tuổi |    Lương    | Ngày làm việc  |");
		System.out.println("-------------------------------------------------------------------------");
	}

	public void nhapThongTinNV(TreeNode treeNode) {
		Scanner sc = new Scanner(System.in);
		df.setLenient(false);
		while (true) {
			try {
				System.out.println("Nhập mã nhân viên: ");
				maNV = Integer.parseInt(sc.nextLine());
				boolean check = setMaNV(maNV);
				if (check) {
					TreeNode currNode = checkMaNV(treeNode, maNV);
					if (currNode != null)
						System.err.println("Ma nhan vien da ton tai!!!");
					else
						break;
				}
			} catch (Exception e) {
				System.out.println("Bạn đã nhập sai vui lòng nhập lại!!!!");
			}
		}
		System.out.println("Nhập tên nhân viên: ");
		tenNV = sc.nextLine();
		System.out.println("Nhập số điện thoại: ");
		SDT = sc.nextLine();

		while (true) {
			try {
				System.out.println("Nhập tuổi nhân viên: ");
				tuoi = Integer.parseInt(sc.nextLine());
				if (tuoi >= 0)
					break;
				else
					System.out.println("Vui lòng nhập dạng số!!!!");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập dạng số!!!!");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập lương nhân viên: : ");
				luong = Integer.parseInt(sc.nextLine());
				if (luong >= 0)
					break;
				else
					System.out.println("Vui lòng nhập dạng số!!!!");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập dạng số!!!!");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập ngày làm việc(yyyy-MM-dd): ");
				ngayLamViec = (Date) df.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.out.println("Bạn đã nhập sai định dạng (yyyy-MM-dd): ");
			}
		}

	}

	public void nhapThongTinNVSua(TreeNode treeNode) {
		Scanner sc = new Scanner(System.in);
		df.setLenient(false);

		System.out.println("Nhập tên nhân viên: ");
		tenNV = sc.nextLine();
		System.out.println("Nhập số điện thoại: ");
		SDT = sc.nextLine();

		while (true) {
			try {
				System.out.println("Nhập tuổi nhân viên: ");
				tuoi = Integer.parseInt(sc.nextLine());
				if (tuoi >= 0)
					break;
				else
					System.out.println("Vui lòng nhập dạng số!!!!");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập dạng số!!!!");
			}
		}
		while (true) {
			try {
				System.out.println("Nhập lương nhân viên: : ");
				luong = Integer.parseInt(sc.nextLine());
				if (luong >= 0)
					break;
				else
					System.out.println("Vui lòng nhập dạng số!!!!");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập dạng số!!!!");
			}
		}

		while (true) {
			try {
				System.out.println("Nhập ngày làm việc(yyyy-MM-dd): ");
				ngayLamViec = (Date) df.parse(sc.nextLine());
				break;
			} catch (ParseException e) {
				System.out.println("Bạn đã nhập sai định dạng (yyyy-MM-dd): ");
			}
		}

	}

	public static void hamNhapThongTinNV(Tree tree){
		DAO1 dao = new DAO1();
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			try {
				System.out.println("Nhập số nhân viên nhập: ");
				n = Integer.parseInt(sc.nextLine());
				if (n >= 0 && n <= 10) {
					break;
				} else {
					System.out.println("Số nhân viên cần nhập lớn hơn 0");
				}
			} catch (Exception e) {
				System.out.println("Vui lòng nhập số lớn hơn 0");
			}
		}

		for (int i = 0; i < n; i++) {
			QLNV qLNV = new QLNV();
			qLNV.nhapThongTinNV(tree.mRoot);
			TreeNode treeNode = new TreeNode(qLNV);
			dao.insertListNV(qLNV);
			tree.mRoot = qLNV.insertIntoTree(tree.mRoot, treeNode);
		}
		System.out.println("Thêm thành công!");
	}

	public TreeNode checkMaNV(TreeNode root, int maNV) {
		if (root == null) {
			return null;
		} else {
			if (maNV < root.qLNV.getMaNV())
				return checkMaNV(root.left, maNV);
			else if (maNV > root.qLNV.getMaNV())
				return checkMaNV(root.right, maNV);
			else
				return root;
		}
	}

	public TreeNode insertIntoTree(TreeNode root, TreeNode treeNode) {
		if (root == null) {
			root = treeNode;
			return root;
		}
		if (treeNode.qLNV.getMaNV() > root.qLNV.getMaNV()) {
			if (root.right == null)
				root.right = treeNode;
			else
				insertIntoTree(root.right, treeNode);
		} else if (root.left == null)
			root.left = treeNode;
		else
			insertIntoTree(root.left, treeNode);
		return root;
	}

	// L - Node - R
	public static void InOder(TreeNode currNode) {
		if (currNode == null) {
			return;
		}
		// Duyệt bên trái
		InOder(currNode.left);

		currNode.hienThiListNV();

		InOder(currNode.right);
	}

	// Node - L - R
	public static void PreOder(TreeNode currNode) {
		if (currNode == null)
			return;
		currNode.qLNV.hienThiThongTinNV();

		// Duyệt bên trái, duyệt bên phải
		PreOder(currNode.left);
		PreOder(currNode.right);
	}

	// L - R - Node
	public static void PostOder(TreeNode currNode) {
		if (currNode == null)
			return;
		// Duyệt bên trái
		PostOder(currNode.left);

		PostOder(currNode.right);

		currNode.qLNV.hienThiThongTinNV();
	}

	// Tìm node con trái cùng của root
	public TreeNode findLeftModeNode(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftModeNode = root;
		while (leftModeNode.left != null)
			leftModeNode = leftModeNode.left;
		return leftModeNode;
	}

	// Tìm node con phải cùng của root
	public TreeNode findRightModeNode(TreeNode root) {
		if (root == null)
			return null;
		TreeNode leftModeNode = root;
		while (leftModeNode.left != null)
			leftModeNode = leftModeNode.right;
		return leftModeNode;
	}

	public TreeNode capNhatNV(TreeNode root) throws Exception {
		DAO1 dao = new DAO1();
		Scanner sc = new Scanner(System.in);
		int maNV;
		while (true) {
			try {
				System.out.println("Nhập mã nhân viên bạn muốn chỉnh sửa: ");
				maNV = Integer.parseInt(sc.next());
				if (setMaNV(maNV))
					break;
			} catch (Exception e) {
				System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
			}
		}
		if (root == null)
			return null;
		else {
			QLNV qLNV = new QLNV();
			TreeNode currNode = checkMaNV(root, maNV);
			if (currNode != null) {
				Tree tree = new Tree();
				qLNV.nhapThongTinNVSua(tree.mRoot);
				// Kiểm tra xem số người tối đa của phòng sau khi chỉnh sửa có lớn hơn số người
				// đang ở không

				currNode.qLNV.setTenNV(qLNV.getTenNV());
				currNode.qLNV.setSDT(qLNV.getSDT());
				currNode.qLNV.setTuoi(qLNV.getTuoi());
				currNode.qLNV.setLuong(qLNV.getLuong());
				currNode.qLNV.setNgayLamViec(qLNV.getNgayLamViec());
				dao.updateNV(qLNV, maNV);

			} else
				System.out.println("Không tìm thấy nhân viên để chỉnh sửa");
			qLNV.hienThiTieuDeNV();
			qLNV.InOder(root);

			return root;
		}

	}

	// gán nhân viên để xóa
	public void ganNV(TreeNode root1, TreeNode root2) {

		root1.qLNV.setMaNV(root2.qLNV.getMaNV());
		root1.qLNV.setTenNV(root2.qLNV.getTenNV());
		root1.qLNV.setSDT(root2.qLNV.getSDT());
		root1.qLNV.setTuoi(root2.qLNV.getTuoi());
		root1.qLNV.setLuong(root2.qLNV.getLuong());
		root1.qLNV.setNgayLamViec(root2.qLNV.getNgayLamViec());

	}

	public TreeNode xoaNV(TreeNode root, int maNV){
		DAO1 dao = new DAO1();
		if (root == null)
			return null;
		else {
			// B1: đi tìm node xoá
			if (maNV < root.qLNV.getMaNV())
				root.left = xoaNV(root.left, maNV);
			else if (maNV > root.qLNV.getMaNV())
				root.right = xoaNV(root.right, maNV);
			else { // root.value == key ==> xoá root
					// B2: xoá node

				dao.deleteNV(maNV);
				// Th1: Node xoá là node lá:
				if (root.left == null && root.right == null) {
					System.out.println("Xoá thành công");
					return null;
				}
				// TH2.1: Chỉ có 1 con bên trái
				if (root.left != null && root.right == null) {
					System.out.println("Xoá thành công");
					return root.left;
				}
				// TH2.2: Chỉ có 1 con bên phải
				if (root.left == null && root.right != null) {
					System.out.println("Xoá thành công!");
					return root.right;
				}
				// TH3: Tồn tại 2 con
				// Tìm node trái cùng của con bên phải
				TreeNode leftModeNode = findLeftModeNode(root.right);
				ganNV(root, leftModeNode);
				root.right = xoaNV(root.right, leftModeNode.qLNV.getMaNV());

			}
			return root;
		}
	}



	public void searchNV(TreeNode root) {

		Scanner sc = new Scanner(System.in);
		int maNV;
		while (true) {
			try {
				System.out.println("Nhập mã nhân viên bạn muốn tìm: ");
				maNV = Integer.parseInt(sc.next());
				if (setMaNV(maNV))
					break;
			} catch (Exception e) {
				System.out.println("Bạn đã nhập sai, vui lòng nhập lại");
			}
		}

		TreeNode currNode = checkMaNV(root, maNV);
		if (currNode != null) {
			System.out.println("Nhân viên cần tìm: ");
			currNode.qLNV.hienThiTieuDeNV();
			currNode.qLNV.hienThiThongTinNV();
		} else {
			System.err.println("Không tìm thấy nhân viên theo mã!!");
		}
	}
}