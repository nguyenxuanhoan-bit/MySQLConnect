package CauTrucDuLieu;

import java.util.Date;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Scanner;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DoAn.DAO1;
import QuanLy.QLSP;

public class DoubleLinkedList {
	public int size;
	public NodeDoubleL head;
	public NodeDoubleL tail;

	public DoubleLinkedList() {
		size = 0;
		head = null;
		tail = null;
	}

	public int size() {
		return size;
	}

	// Check xem sản phẩm đã tồn tại trong danh sách hay chưa
	public NodeDoubleL checkSP(NodeDoubleL node, String maSP) {
		NodeDoubleL currNode = head;
		while (currNode != null) {
			if (currNode.qLSP.getMaSP().equalsIgnoreCase(maSP))
				return currNode;
			currNode = currNode.next;
		}
		return null;
	}

	public NodeDoubleL search(NodeDoubleL node, String maSP) {
		if (head == null)
			return null;
		else {
			NodeDoubleL currNode = head;
			int index = -1;
			while (currNode != null) {
				if (currNode.qLSP.getMaSP().equalsIgnoreCase(maSP)) {
					return currNode;
				}
				currNode = currNode.next;
			}
			return null;
		}
	}

	public void insertHead(NodeDoubleL node) {
		if (head == null)
			head = node;
		else {
			NodeDoubleL temp = head;
			head = node;
			temp.prev = node;
			node.next = temp;
		}
	}

	public void insertTail(NodeDoubleL node) {
		tail = head;
		if (head == null)
			head = node;
		else {
			while (tail.next != null) {
				tail = tail.next;
			}
			NodeDoubleL temp = tail;
			tail = node;
			node.prev = temp;
			temp.next = node;
		}
	}

	public void insertAt(NodeDoubleL node, int index) {
		if (index == 0)
			insertHead(node);
		else {
			NodeDoubleL currNode = head;
			int count = 0;
			while (currNode != null) {
				count++;
				if (count == index) {
					currNode.next.prev = node;
					node.next = currNode.next;
					currNode.next = node;
					node.prev = currNode;
					break;
				}
				currNode = currNode.next;
			}

		}
	}

	public void removeHead(NodeDoubleL node) {
		if (head == null) {
			System.out.println("List rỗng không thể xoá");
		} else {
			head = head.next;
			hamHienThiListSanPham();
		}
	}

	public void removeTail(NodeDoubleL node) {
		tail = head;
		if (head == null) {
			System.out.println("List rỗng không thể xoá");
		} else {
			NodeDoubleL currNode = null;
			while (tail.next != null) {
				currNode = tail;
				tail = tail.next;
			}
			if (currNode == null) {
				head = head.next;
			} else {
				currNode.next = tail.next;
			}
		}
	}

	public void removeAt(NodeDoubleL node, int index) {
		if (head == null)
			System.out.println("List rỗng không thể xoá");
		else {
			if (index == 0)
				removeHead(node);
			else {
				NodeDoubleL currNode = head;
				NodeDoubleL prevNode = null;
				int count = 0;
				boolean bIsFound = false;
				while (currNode != null) {
					if (count == index) {
						bIsFound = true;
						break;
					}
					prevNode = currNode;
					currNode = currNode.next;
					count++;
				}
				if (bIsFound) {
					prevNode.next = currNode.next;
//					currNode.next.prev = prevNode;
				} else {
					head = head.next;
				}
				hamHienThiListSanPham();
			}

		}
	}

	public NodeDoubleL searchSP(NodeDoubleL node) {
		if (head == null)
			return null;
		else {
			Scanner sc = new Scanner(System.in);
			String maSP;
			while (true) {
				try {
					System.out.println("Nhập mã sản phẩm");
					maSP = sc.nextLine();
					if (node.qLSP.setMaSP(maSP))
						break;
				} catch (Exception e) {
				}
			}

			NodeDoubleL currNode = checkSP(node, maSP);
			if (currNode != null) {
				System.out.println("Sản phẩm cần tìm: ");
				currNode.qLSP.hienThiTieuDe();
				currNode.qLSP.hienThiThongTinSP();
			} else
				System.err.println("Khong tim thay san pham theo ma!!");

		}
		return null;

	}

	public void removeByMaSP(NodeDoubleL node) throws Exception {
		DAO1 dao = new DAO1();
		Scanner sc = new Scanner(System.in);
		String maSP;
		while (true) {
			try {
				System.out.println("Nhập mã sản phẩm");
				maSP = sc.nextLine();
				if (maSP.length() != 5)
					System.out.println("Mã SP phải gồm 5 kí tự và có dạng 'SPxxx'!!!");
				else
					break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		NodeDoubleL currNode = head;
		int count = 0;
		int index = -1;
		while (currNode != null) {
			if (currNode.qLSP.getMaSP().equalsIgnoreCase(maSP)) {
				removeAt(node, count);
				dao.deleteSanPham(maSP);
				index = 1;
			}
			currNode = currNode.next;
			count++;
		}
		if (index == -1)
			System.out.println("Không tìm thấy mã sản phẩm để xoá");
	}

	// đang lỗi
	public void updateSanPham(DoubleLinkedList dLL, NodeDoubleL node){

		if (head == null)
			System.out.println("Danh sách sản phẩm rỗng không thể chỉnh sửa");
		else {
			Scanner sc = new Scanner(System.in);
			QLSP qLSP = new QLSP();
			String maSP;
			while (true) {
				while (true) {
					try {
						System.out.println("Nhập mã sản phẩm");
						maSP = sc.nextLine();
						if (maSP.length() != 5)
							System.out.println("Mã SP phải gồm 5 kí tự và có dạng 'SPxxx'!!!");
						else
							break;
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				boolean check = qLSP.setMaSP(maSP);
				if (check)
					break;
			}
			DAO1 dao = new DAO1();
			NodeDoubleL currNode = checkSP(node, maSP);
			if (currNode != null) {

				qLSP.nhapThongTinSua(dLL, node);

				currNode.qLSP.setTenSP(qLSP.getTenSP());
				currNode.qLSP.setSoLuong(qLSP.getSoLuong());
				currNode.qLSP.setngayNhapHang(qLSP.getngayNhapHang());
				currNode.qLSP.setDonGia(qLSP.getDonGia());

				try {
					dao.updateSanPham(qLSP, maSP);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Cập nhập thành công!!!!");
				hamHienThiListSanPham();
			} else
				System.out.println("Không tìm thấy sản phẩm theo mã sản phẩm!");
		}
	}

	public void addSanPham(DoubleLinkedList dLL, NodeDoubleL node) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n;
		DAO1 dao = new DAO1();
		while (true) {
			try {
				System.out.println("Nhập số sản phẩm cần nhập: ");
				n = Integer.parseInt(sc.nextLine());
				if (n >= 0)
					break;
				else
					System.out.println("Số sản phẩm cần nhập lớn hơn 0!!!");
			} catch (Exception e) {
				System.out.println("Vui lòng nhập số lớn hơn 0!!!!");
			}
		}
		for (int i = 0; i < n; i++) {
			QLSP qLSP = new QLSP();
			qLSP.nhapThongTin(dLL, node);
			node.qLSP.setMaSP(qLSP.getMaSP());
			node.qLSP.setTenSP(qLSP.getTenSP());
			node.qLSP.setSoLuong(qLSP.getSoLuong());
			node.qLSP.setngayNhapHang(qLSP.getngayNhapHang());
			node.qLSP.setDonGia(qLSP.getDonGia());
			dao.insertListSanPham(node);
            insertTail(node);
		}
		System.out.println("Thêm thành công!");
		hamHienThiListSanPham();
	}

	public void hamHienThiListSanPham() {
		if (head == null)
			System.out.println("Danh sách rỗng!");
		else {
			NodeDoubleL currNode = head;
			currNode.qLSP.hienThiTieuDe();
			while (currNode != null) {
				currNode.hienThiSanPham();
				currNode = currNode.next;
				System.out
						.println("---------|------------------------------|------------|---------------|------------");
			}
		}
	}
	public void swapSP(NodeDoubleL node1, NodeDoubleL node2) {
		String maSP = node1.qLSP.getMaSP();
		String tenSP = node1.qLSP.getTenSP();
		int soLuong = node1.qLSP.getSoLuong();
		Date ngayNhapHang = (Date) node1.qLSP.getngayNhapHang();
        int donGia = node1.qLSP.getDonGia();

        node1.qLSP.setMaSP(node2.qLSP.getMaSP());
		node1.qLSP.setTenSP(node2.qLSP.getTenSP());
		node1.qLSP.setSoLuong(node2.qLSP.getSoLuong());
		node1.qLSP.setngayNhapHang(node2.qLSP.getngayNhapHang());
		node1.qLSP.setDonGia(node2.qLSP.getDonGia());

		node2.qLSP.setMaSP(maSP);
		node2.qLSP.setTenSP(tenSP);
		node2.qLSP.setSoLuong(soLuong);
		node2.qLSP.setngayNhapHang(ngayNhapHang);
		node2.qLSP.setDonGia(donGia);

	}
	public void ganSP(NodeDoubleL node1, NodeDoubleL node2) {
		node1.qLSP.setMaSP(node2.qLSP.getMaSP());
		node1.qLSP.setTenSP(node2.qLSP.getTenSP());
		node1.qLSP.setSoLuong(node2.qLSP.getSoLuong());
		node1.qLSP.setngayNhapHang(node2.qLSP.getngayNhapHang());
		node1.qLSP.setDonGia(node2.qLSP.getDonGia());

	}
	//Sắp xếp theo đơn giá tăng dần insertionsort(sắp xếp chèn)
	public void insertionDonGiaTang(NodeDoubleL node) {
		if(head == null)
			System.out.println("List rỗng không thể sắp xếp!");
		else {
			NodeDoubleL currNode = head.next;
			while(currNode != null) {
				NodeDoubleL tempNode = currNode;
				NodeDoubleL prevNode = currNode.prev;
				while(prevNode != null && prevNode.qLSP.getSoLuong() > tempNode.qLSP.getSoLuong()) {
					ganSP(prevNode.next, prevNode);
					prevNode = prevNode.prev;
				}
				ganSP(prevNode.next, tempNode);
				currNode = currNode.next;
			}
		}
	}
	
	public void sortDonGiaTang() {
		if (head == null) {
			System.out.println("List rỗng không thể sắp xếp!");
		} else {
			NodeDoubleL currNode = head;
			NodeDoubleL prevNode = null;
			while (currNode != null) {
				prevNode = currNode.next;
				while (prevNode != null) {
					
						if (currNode.qLSP.getDonGia() > prevNode.qLSP.getDonGia())
							swapSP(currNode, prevNode);

					prevNode = prevNode.next;
				}
				currNode = currNode.next;
			}
			hamHienThiListSanPham();
		}
	}
	
//	Sắp xếp theo số lượng tăng dần với thuật toàn selectionsort(sắp xếp chọn)
	public void selectionSortSoLuongSP() {
		if (head == null)
			System.out.println("List rỗng không thể sắp xếp");
		NodeDoubleL currNode = head;
		while (currNode != null) {
			NodeDoubleL minNode = currNode;
			NodeDoubleL prevNode = currNode.next;
			while (prevNode != null) {
				if (prevNode.qLSP.getSoLuong() < minNode.qLSP.getSoLuong())
					minNode = prevNode;
				prevNode = prevNode.next;
			}
			if (minNode.qLSP.getSoLuong() != currNode.qLSP.getSoLuong()) {
				swapSP(minNode, currNode);
			}
			currNode = currNode.next;
		}
		hamHienThiListSanPham();
	}
	
	public void sortName() {
		if (head == null) {
			System.out.println("List rỗng không thể sắp xếp!");
		} else {
			NodeDoubleL currNode = head;
			NodeDoubleL prevNode = null;
			double mark;
			while (currNode != null) {
				prevNode = currNode.next;
				while (prevNode != null) {
					if (currNode.qLSP.getTenSP().compareToIgnoreCase(prevNode.qLSP.getTenSP()) > 0) {
						swapSP(currNode, prevNode);
					}
					prevNode = prevNode.next;
				}
				currNode = currNode.next;
			}
			hamHienThiListSanPham();
		}
	}
	public void sortNgayNhapSP() {
		if (head == null) {
			System.out.println("List rỗng không thể sắp xếp!");
		} else {
			NodeDoubleL currNode = head;
			NodeDoubleL prevNode = null;
			String name;
			int age;
			double mark;
			while (currNode != null) {
				prevNode = currNode.next;
				while (prevNode != null) {
					if (currNode.qLSP.getngayNhapHang().after(prevNode.qLSP.getngayNhapHang())) {
						swapSP(currNode, prevNode);
					}
					prevNode = prevNode.next;
				}
				currNode = currNode.next;
			}
			hamHienThiListSanPham();
		}
	}

	
}