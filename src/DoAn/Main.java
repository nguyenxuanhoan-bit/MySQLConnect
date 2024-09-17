package DoAn;

import java.util.Scanner;

import QuanLy.QLNV;
import QuanLy.QLQL;
import QuanLy.QLSP;
import CauTrucDuLieu.*;

public class Main {
    static QLSP qLSP = new QLSP();
    static QLQL qLQL = new QLQL();
    static QLNV qLNV = new QLNV();
    static LinkedList lL = new LinkedList();
    static DoubleLinkedList dLL = new DoubleLinkedList();
    static NodeDoubleL nodeDLL = new NodeDoubleL(qLSP);
    static Tree tree = new Tree();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DAO1 dao = new DAO1();
        dao.getListSanPham(dLL);
        dao.getListQuanLy(lL);
        dao.getListNV(tree);

        int chon;
        do {
            Menu.menuQLSP();
            while (true) {
                try {
                    chon = Integer.parseInt(sc.nextLine());
                    if (chon >= 0 && chon <= 4)
                        break;
                    else
                        System.out.println("Bạn đã chọn sai!! Vui lòng chọn lại!!!");
                } catch (Exception e) {
                    System.err.println("Ban da chon sai, vui long chon lai!!!");
                }
            }

            switch (chon) {
                case 1: {
                    int luaChon;
                    do {
                        Menu.menuSanPham();
                        while (true) {
                            try {
                                luaChon = Integer.parseInt(sc.nextLine());
                                if (luaChon >= 0 && luaChon <= 7)
                                    break;
                                else
                                    System.out.println("Bạn đã chọn sai!! Vui lòng chọn lại!!!");
                            } catch (Exception e) {
                                System.err.println("Ban da chon sai, vui long chon lai!!!");
                            }
                        }
                        switch (luaChon) {
                            case 1: {
                                dLL.hamHienThiListSanPham();
                                break;
                            }
                            case 2: {
                                dLL.addSanPham(dLL, nodeDLL);
                                break;
                            }
                            case 3: {
                                dLL.removeByMaSP(nodeDLL);
                                break;
                            }
                            case 4: {
                                dLL.searchSP(nodeDLL);
                                break;
                            }
                            case 5: {
                                dLL.updateSanPham(dLL, nodeDLL);
                                break;
                            }
                            case 6: {
                                int luaChon2;
                                do {
                                    Menu.menuSortSanPham();
                                    while (true) {
                                        try {
                                            luaChon2 = Integer.parseInt(sc.nextLine());
                                            if (luaChon2 >= 0 && luaChon2 <= 4)
                                                break;
                                            else
                                                System.out.println("Bạn đã chọn sai!! Vui lòng chọn lại!!!");
                                        } catch (Exception e) {
                                            System.err.println("Ban da chon sai, vui long chon lai!!!");
                                        }
                                    }
                                    switch (luaChon2) {
                                        case 1: {
                                            dLL.sortDonGiaTang();
                                            break;
                                        }
                                        case 2: {
                                            dLL.selectionSortSoLuongSP();
                                            break;
                                        }
                                        case 3: {
                                            dLL.sortName();
                                            break;
                                        }
                                        case 4: {
                                            dLL.sortNgayNhapSP();
                                            break;
                                        }
                                    }
                                } while (luaChon2 != 0);
                                break;
                            }
                            case 0:
                                System.out.println("");
                        }

                    } while (luaChon != 0);
                    break;
                }
                case 2: {
                    int luaChon;
                    do {
                        Menu.menuQuanLy();
                        while (true) {
                            try {
                                luaChon = Integer.parseInt(sc.nextLine());
                                if (luaChon >= 0 && luaChon <= 3)
                                    break;
                                else
                                    System.out.println("Bạn đã chọn sai!! Vui lòng chọn lại!!!");
                            } catch (Exception e) {
                                System.err.println("Ban da chon sai, vui long chon lai!!");
                            }
                        }

                        switch (luaChon) {
                            case 1: {
                                lL.hamHienThiListQL();
                                break;
                            }
                            case 2: {
                                lL.removeByMaQL(null);
                                break;
                            }
                            case 3: {
                                lL.doiMatKhau(null); // Vì không có mã quản lý nên truyền null vào đây
                                break;
                            }

                        }
                    } while (luaChon != 0);
                    break;
                }
                case 3: {

                    int luaChon;
                    do {
                        Menu.menuNhanVien();
                        while (true) {
                            try {
                                luaChon = Integer.parseInt(sc.nextLine());
                                if (luaChon >= 0 && luaChon <= 5)
                                    break;
                                else
                                    System.out.println("Bạn đã chọn sai!! Vui lòng chọn lại!!!");
                            } catch (Exception e) {
                                System.err.println("Ban da chon sai, vui long chon lai!!!");
                            }
                        }

                        switch (luaChon) {
                            case 1: {
                                qLNV.hienThiTieuDeNV();
                                qLNV.InOder(tree.mRoot);
                                break;
                            }
                            case 2: {
                                qLNV.hamNhapThongTinNV(tree);
                                qLNV.hienThiTieuDeNV();
                                qLNV.InOder(tree.mRoot);
                                break;
                            }
                            case 3: {
                                qLNV.capNhatNV(tree.mRoot);
                                break;
                            }
                            case 4: {
                                int maNV;
                                while (true) {
                                    try {
                                        System.out.println("Nhập mã NV cần xóa: ");
                                        maNV = Integer.parseInt(sc.nextLine());
                                        if (qLNV.setMaNV(maNV)) {
                                            TreeNode currNode = qLNV.checkMaNV(tree.mRoot, maNV);
                                            if (currNode == null)
                                                System.out.println("Mã NV không tồn tại!!!!");
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.err.println("Ban da chon sai, vui long chon lai!!!");
                                    }
                                }
                                tree.mRoot = qLNV.xoaNV(tree.mRoot, maNV);
                                qLNV.hienThiTieuDeNV();
                                qLNV.InOder(tree.mRoot);
                                break;
                            }
                            case 5: {
                                  qLNV.searchNV(tree.mRoot);
                                  break;
                            }
                        }
                    } while (luaChon != 0);
                    break;
                }

                case 5: {
                    System.out.println("ĐĂNG XUẤT THÀNH CÔNG!!");
                    break;
                }
                case 0: {
                    System.out.println("Kết thúc chương trình thành công!!!!");
                    System.exit(0);
                }
            }
        } while (chon != 0);

    }
}
