package CauTrucDuLieu;

import java.util.Scanner;
import DoAn.DAO1;
import QuanLy.QLQL;

public class LinkedList {
	int size;
	NodeLinkedList head;
	NodeLinkedList tail;
	
	public LinkedList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public int size() {
		return size;
	}
	
	public void insertHead(NodeLinkedList node) {
		if(head != null) {
			node.next = head;
		}
		head = node;
	}
	public void insertTail(NodeLinkedList node) {
		tail = head;
		if(head == null) {
			head = node;
		}
		else {
			while(tail.next != null) {
				tail = tail.next;
			}
			tail.next = node;
		}
	
	}
	
	public void insertAt(NodeLinkedList node, int position) {
		if(position == 0) {
			insertHead(node);
		}
		else {
			NodeLinkedList currentNode = head;
			int count = 0;
			while(currentNode != null) {
				count ++;
				if(count == position) {
					node.next = currentNode.next;
					currentNode.next = node;
					break;
				}
				currentNode = currentNode.next;
			}
		}
	}
	
	public void removeHead(NodeLinkedList node) {
		if(head != null) {
			head = head.next;
		}
		else {
			System.out.println("List rỗng không thể xoá");
		}
	}
	
	public void removeTail(NodeLinkedList node) {
		tail = head;
		if(head == null)
			System.out.println("List rỗng không thể xoá");
		else {
			NodeLinkedList prevNode = null;
			while(tail.next != null) {
				prevNode = tail;
				tail= tail.next;
			}
			if(prevNode == null)
				head = head.next;
			else {
				prevNode.next = tail.next;
			}
		}
	}
	
	public void removeAt(NodeLinkedList node, int position) {
		if(head == null) 
			System.out.println("List trống k thể xoá");
		if(position == 0) {
			removeHead(node);
		} else {
			NodeLinkedList currentNode = head;
			NodeLinkedList prevNode = null;
			int count = 0;
			boolean bIsFound = false;
			while(currentNode != null) {
				if(count == position) {
					bIsFound = true;
					break;
				}
				prevNode = currentNode;
				currentNode = currentNode.next;
				count++;
			}
			if(bIsFound)
				if(prevNode == null)
					head = head.next;
				else
					prevNode.next = currentNode.next;
		}
	}
	public void removeByMaQL(NodeLinkedList node) throws Exception {
		DAO1 dao = new DAO1();
		Scanner sc = new Scanner(System.in);
		String maQL;
		while (true) {
			try {
				System.out.println("Nhập mã quản lí: ");
				maQL = sc.nextLine();
				if (maQL.length() != 5)
					System.out.println("Mã QL phải gồm 5 kí tự");
				else
					break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		NodeLinkedList currNode = head;
		int count = 0;
		int index = -1;
		while (currNode != null) {
			if (currNode.qLQL.getMaQL().equalsIgnoreCase(maQL)) {
				removeAt(node, count);
				dao.deleteQuanLi(maQL);
				index = 1;
			}
			currNode = currNode.next;
			count++;
		}
		if (index == -1)
			System.out.println("Không tìm thấy mã sản phẩm để xoá");
	}
	public NodeLinkedList checkMaQL(String maQL) {
		NodeLinkedList currNode = head;
		while(currNode != null) {
			if(currNode.qLQL.getMaQL().equals(maQL)) 
				return currNode;
			currNode = currNode.next;
		}
		return null;
	}
	
	public String checkMatKhauQL(String matKhau, String maQL) {
		NodeLinkedList checkNode = checkMaQL(maQL);
		if(checkNode != null) 
			if(checkNode.qLQL.getMatKhau().equals(matKhau)) {
				System.out.println("ĐĂNG NHẬP THÀNH CÔNG!!");
				return maQL;
			} 
		return null;
	}
	
	public void doiMatKhau(String maQL) {
		DAO1 dao = new DAO1();
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mật khẩu cũ:");
		String matKhauCu = sc.nextLine();
		NodeLinkedList currNode = searchQuanLy(maQL);
		if(currNode.qLQL.getMatKhau().equals(matKhauCu)) {
			System.out.println("Nhập mật khẩu mới:");
			String matKhauMoi = sc.nextLine();
			System.out.println("Nhập lại mật khẩu mới: ");
			String matKhauMoi2 = sc.nextLine();
			if(matKhauMoi.equals(matKhauMoi2)) {
				currNode.qLQL.setMatKhau(matKhauMoi);
//				dao.updateQuanLy(currNode.qLQL, maQL);
				System.out.println("Đổi mật khẩu thành công!");
			}
			else 
				System.err.println("Mật khẩu nhập lại không đúng!");
		} else 
			System.err.println("Mật khẩu cũ không đúng!");
	}
	
	public NodeLinkedList searchQuanLy(String maQL) {
		NodeLinkedList currNode = head;
		while(currNode != null) {
			if(currNode.qLQL.getMaQL().equalsIgnoreCase(maQL))
					return currNode;
			currNode = currNode.next;
		}
		return null;
	}
	
	public void hamHienThiListQL() {
		QLQL.hienThiTieuDe();
		NodeLinkedList currNode = head;
		while(currNode != null) {
			currNode.hienThiQuanLy();
			currNode = currNode.next;
			System.out.println(
					"|--------|------------------|-----------------|-----------|-----------|------------|");
		}
	}
}

