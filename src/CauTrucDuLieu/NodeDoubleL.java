package CauTrucDuLieu;

import QuanLy.QLSP;

public class NodeDoubleL {
	public QLSP qLSP;
	public NodeDoubleL next;
	public NodeDoubleL prev;
	
	public NodeDoubleL(QLSP qLSP) {
		this.qLSP = qLSP;
		this.next = next;
		this.prev = prev;
	}
	
	public void hienThiSanPham() {
		qLSP.hienThiThongTinSP();
	}
	
}