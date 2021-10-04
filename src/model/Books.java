package model;

import java.util.Date;

public class Books {
    private String masach, tensach, tacgia, nhaxb, gthieu;
    private int dongia;
	private Date ngayxb;
	
    public String getmasach() {
   	 return masach;
    }
    
    public void setmasach(String masach) {
   	 this.masach = masach;
    }

	public String gettensach() {
   	 return tensach;
    }
    
    public void settensach(String tensach) {
   	 this.tensach = tensach;
    }
    
    public String gettacgia() {
   	 return tacgia;
    }
    
    public void settacgia(String tacgia) {
   	 this.tacgia = tacgia;
    }
    
    public String getnhaxb() {
   	 return nhaxb;
    }
    
    public void setnhaxb(String nhaxb) {
   	 this.nhaxb = nhaxb;
    }
    
    public String getgthieu() {
   	 return gthieu;
    }
    public void setgthieu(String gthieu) {
   	 this.gthieu = gthieu;
    }
    
    public int getdongia() {
   	 return dongia;
    }
    
    public void setdongia(int dongia) {
   	 this.dongia = dongia;
    }
    
    public Date getngayxb() {
   	 return ngayxb;
    }
    
    public void setngayxb(Date ngayxb) {
   	 this.ngayxb = ngayxb;
    }

}
