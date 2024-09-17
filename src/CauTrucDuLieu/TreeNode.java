package CauTrucDuLieu;

import QuanLy.QLNV;

public class TreeNode {
	public QLNV qLNV;
  	public TreeNode left;
  	public TreeNode right;
  	public TreeNode(QLNV qLNV) {
  		this.qLNV = qLNV;
  	}
  	public void hienThiListNV() {
  		qLNV.hienThiThongTinNV();
  	}
}