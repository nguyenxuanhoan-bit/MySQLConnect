package DTO;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NhanVien {
	public int maNV;
	public String tenNV;
	public String SDT;
	public int tuoi;
	public float luong;
	public Date ngayLamViec;

	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int maNV, String tenNV, String SDT, int tuoi, float luong, Date ngayLamViec) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.SDT = SDT;
		this.tuoi = tuoi;
		this.luong = luong;
		this.ngayLamViec = ngayLamViec;
	}

	public int getMaNV() {
		return maNV;
	}

	public boolean setMaNV(int maNV) {
		if(maNV >= 100 && maNV <= 999) {
			this.maNV = maNV;
			return true;
		} else {
			System.err.println("Mã nhân viên phải gồm 3 số!!!!");
			return false;
		}
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
    public String getSDT() {
    	return SDT;
    }
    public void setSDT(String SDT) {
    	this.SDT = SDT;
    	
    }

	

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	public Date getNgayLamViec() {
		return ngayLamViec;
	}

	public void setNgayLamViec(Date ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}

}