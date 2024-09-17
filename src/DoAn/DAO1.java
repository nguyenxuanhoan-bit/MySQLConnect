package DoAn;

import java.text.SimpleDateFormat;
import CauTrucDuLieu.DoubleLinkedList;
import CauTrucDuLieu.LinkedList;
import CauTrucDuLieu.NodeDoubleL;
import CauTrucDuLieu.NodeLinkedList;
import CauTrucDuLieu.Tree;
import CauTrucDuLieu.TreeNode;
import QuanLy.QLNV;
import QuanLy.QLQL;
import QuanLy.QLSP;

public class DAO1 {

    public void getListSanPham(DoubleLinkedList dll) throws Exception {
        // Phương thức này trả về danh sách sản phẩm từ DoubleLinkedList
    }

    public void insertListSanPham(NodeDoubleL node) throws Exception {
        // Phương thức này chèn một sản phẩm vào danh sách sản phẩm trong DoubleLinkedList
    }

    public void updateSanPham(QLSP qLSP, String maSP) throws Exception {
        // Phương thức này cập nhật thông tin của một sản phẩm trong danh sách sản phẩm của DoubleLinkedList
    }

    public void deleteSanPham(String maSP) throws Exception {
        // Phương thức này xoá một sản phẩm khỏi danh sách sản phẩm trong DoubleLinkedList
    }

    public void getListQuanLy(LinkedList lL) throws Exception {
        // Phương thức này trả về danh sách quản lý từ LinkedList
    }

    public void deleteQuanLi(String maQL) throws Exception {
        // Phương thức này xoá một bản ghi quản lý từ LinkedList
    }

    public void getListNV(Tree tree) {
        // Phương thức này trả về danh sách nhân viên từ Tree
    }

    public void insertListNV(QLNV qLNV) {
        // Phương thức này chèn một nhân viên vào cây nhị phân
    }

    public void deleteNV(int maNV) {
        // Phương thức này xoá một nhân viên khỏi cây nhị phân dựa trên mã nhân viên
    }

    public void updateNV(QLNV qLNV, int maNV) throws Exception {
        // Phương thức này cập nhật thông tin của một nhân viên trong cây nhị phân dựa trên mã nhân viên
    }
}
