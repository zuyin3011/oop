package SANPHAM;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
///*import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;*/
import java.util.Scanner;
public class SANPHAM {
    private String maSP;
    private String tenSP;
    private String NSX;
    private long giaBan;
    private long giaNhap;
    private String loai;
    Scanner sc= new Scanner (System.in);

    public SANPHAM(String maSP,String tenSP, String NSX, long giaBan, long giaNhap,String loai) {
        this.maSP=maSP;
        this.tenSP = tenSP;
        this.NSX = NSX;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.loai=loai;
    }



    /**
     *
     */
    public SANPHAM() {
        
    }
//    SanPham(String NSX, String tenSP, double giaBan, double giaNhap) {
//          this.NSX = NSX;
//        this.tenSP = tenSP;
//        this.giaBan = giaBan;
//        this.giaNhap = giaNhap;
//    }


 
    public String getNSX() {
        return NSX;
    }

    public void setNSX(String NSX) {
        while(NSX.length() < 2 || NSX.length() > 30 ){
         System.out.println("Nhap lai Nha san Xuat");
         NSX=sc.nextLine();
        }
        this.NSX = NSX;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        while(tenSP.length() < 2 || tenSP.length() > 30 ){
         System.out.println("Nhap lai Ten San Pham");
         tenSP=sc.nextLine();
        }
        this.tenSP = tenSP;
    }
     public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long GiaBan) {
        while( giaBan<0 || giaBan>1000000000){
            System.out.println("Nhap lai gia Ban cua San Pham");
            giaBan=sc.nextLong();
        }
        this.giaBan = GiaBan;
    }
    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long GiaNhap) {
        while( giaNhap<0 || giaNhap>1000000000){
            System.out.println("Nhap lai gia Nhap cua San Pham");
            giaNhap=sc.nextLong();
        }
        this.giaNhap = GiaNhap;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }


    public void input(){
            System.out.println("Nhap ma SP: ");
            maSP = sc.nextLine();
            System.out.println("Nhap NSX: ");
            NSX = sc.nextLine();
            System.out.println("Nhap ten San Pham: ");
            tenSP = sc.nextLine();
            System.out.println("Nhap gia Ban: ");
            giaBan = sc.nextLong();
            System.out.println("Nhap gia Nhap: ");
            giaNhap =sc.nextLong();
             boolean k = true;
             while (k==true){
                                    System.out.println("Moi nhap loai san pham");
                                    System.out.println("1. Sach");
                                    System.out.println("2.Dung cu hoc tap");
                                    int choice =sc.nextInt();
            
                                    switch (choice) {
			case 1: {
				setLoai("Sach");
				System.out.println("Sach");
				k = false;
				break;
			}
			case 2: {
				setLoai("Dung Cu Hoc Tap");
				System.out.println("Dung Cu Hoc Tap");
				k = false;
				break;
			}
			default:{
				System.out.println("Lua chon khong dung yeu cau ! Vui long chon lai");
			}
            
          
        
            }
             }
    }
    public void output() {
       System.out.format("| %20s | %10s | %13s | %13s |%10s|\n", this.getMaSP(),this.tenSP,
				this.NSX, this.giaBan, this.giaNhap,this.loai);
   }
 
    @Override
   public String toString() {
      return this.getMaSP()+","+ this.getTenSP() + "," + this.getNSX() + "," + this.getGiaBan() + "," + this.getGiaNhap()+","+this.getLoai() ;
   } 
   

   
}