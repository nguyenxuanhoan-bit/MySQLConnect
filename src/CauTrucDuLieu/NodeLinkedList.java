package CauTrucDuLieu;

import QuanLy.QLQL;

public class NodeLinkedList {
	public QLQL qLQL;
	public NodeLinkedList next;
	
	public NodeLinkedList(QLQL qLQL) {
		this.qLQL = qLQL;
		this.next = null;
	}
	
	public void hienThiQuanLy() {
		qLQL.hienThiThongTinQL();
	}
}
