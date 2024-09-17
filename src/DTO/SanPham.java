package DTO;

import java.util.Date;
import java.util.regex.Pattern;

public class SanPham {
	public String maSP;
	public String tenSP;
	public int soLuong;
	public Date ngayNhapHang;
	public int donGia;

	public SanPham() {
		super();
	}

	public SanPham(String maSP, String tenSP, int soLuong, Date ngayNhapHang, int donGia) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.ngayNhapHang = ngayNhapHang;
		this.donGia = donGia;
	}

	public String getMaSP() {
		return maSP;
	}

//    public boolean setMaSP(String maSP) {
//		Pattern p = Pattern.compile("^C[0-9]{7}$");
//		if(p.matcher(maSP).find()) {
//			this.maSP = maSP;
//			return true;
//		} 
//		else {
//			System.err.println("Mã sản phẩm có dạng (SPxxxxxx) (x là số): ");
//			return false;
//		}
//    }
	public boolean setMaSP(String maSP) {
		this.maSP = maSP;
		return true;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getngayNhapHang() {
		return ngayNhapHang;
	}

	public void setngayNhapHang(Date ngayNhapHang) {
		this.ngayNhapHang = ngayNhapHang;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
}