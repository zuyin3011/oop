package SANPHAM;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class GIAOKHOA extends SACH {
    private int lop;
    private String mon;
    Scanner sc=new Scanner(System.in);

//    public giaokhoa(String tenSP,String NSX, double giaBan, double giaNhap, String maSach, TacGia tacGia, int namXB,String loaiSach) {
//        super(tacGia, namXB, maSach, NSX, giaBan, giaNhap, tenSP, loaiSach);
//    }
    public GIAOKHOA(String maSP,String tenSP,String NSX, long giaBan, long giaNhap, String loai, String maSach ,TACGIA tacGia, int namXB,String loaiSach,int lop, String mon) {
        super(maSP,tenSP,NSX,giaBan,giaNhap,loai,maSach ,tacGia,namXB,loaiSach);
        this.lop = lop;
        this.mon = mon;
    }
    

  

    public GIAOKHOA( String maSach,TACGIA tacGia, int namXB,String loaiSach,int lop, String mon) {
        super(maSach,tacGia, namXB, loaiSach);
        this.lop = lop;
        this.mon = mon;
    }

    GIAOKHOA() {
        
    }

   public GIAOKHOA(SACH sach,int lop, String mon){
        super(sach.getSanPham(),sach.getMaSach(),sach.getTacGia(),sach.getNamXB(),sach.getLoaiSach());
       this.lop = lop;
        this.mon = mon;
    } 



    


    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
         while(lop<1 && lop>12){
         System.out.println("Nhap lai lop cua sach");
         lop=sc.nextInt();
        }
        this.lop = lop;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }


    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public TACGIA getTacGia() {
        return tacGia;
    }

    public void setTacGia(TACGIA tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }
   

         @Override
        public void input(){
        super.input();
       
        System.out.println("nhap lop cua sach giao khoa:");
        lop=sc.nextInt();
         sc.nextLine();
         System.out.println("nhap mon cua sach giao khoa:");
        mon=sc.nextLine();
        }
    @Override
   	public void output () {
            System.out.format("| %6s | %20s | %10s | %13s | %13s | %20s | %12s | %6s | %12s | %12s|%12s| \n",  this.getMaSP(),this.getTenSP(),
				this.getNSX(), this.getGiaBan(), this.getGiaNhap(),this.getLoai(),this.getMaSach(),this.getTacGia(),this.getNamXB(),this.getLoaiSach(),this.mon,this.lop);
	} 
  
    @Override
        public String toString() {
        return getLop()+","+getMon();
        }
  
}
