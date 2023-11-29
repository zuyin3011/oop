package SANPHAM;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 * 
 */
import java.util.Scanner;
public class SACH extends SANPHAM{
    String maSach;
    TACGIA tacGia;
    int namXB;
    String loaiSach;
    private SANPHAM sanPham;
    private static Scanner sc=new Scanner(System.in);

    public SACH(TACGIA tacGia, int namXB,String maSP, String NSX, String tenSP, long giaBan, long giaNhap,String loai,String loaiSach,String maSach) {
        super(maSP,tenSP, NSX, giaBan, giaNhap,loai);
        this.maSach=maSach;
        this.tacGia = tacGia;
        this.namXB = namXB;
        this.loaiSach=loaiSach;

    }

    public SACH() {
    }

   public SACH(String maSP,String tenSP, String NSX, long giaBan, long giaNhap,String loai,String maSach,TACGIA tacGia, int namXB, String loaiSach, String ngonNgu, String loaiTruyen) {
        
    }

    public SACH(String maSP,String tenSP, String NSX, long giaBan, long giaNhap, String loai,String maSach, TACGIA tacGia, int namXB, String loaiSach, int Lop, String mon) {
      
    }

     


    public SANPHAM getSanPham() {
        return this.sanPham;
    }
    public SACH(String maSach,TACGIA tacGia, int namXB,String loaiSach) {
        this.maSach=maSach;
        this.tacGia = tacGia;
        this.namXB = namXB;
        this.loaiSach=loaiSach;

    }

//    Sach(SanPham sp, String string, TacGia tacGia, int parseInt) {
//        this(sp, string, tacGia, parseInt, txt[7]);
//    }
        public SACH(String maSP,String tenSP, String NSX, long giaBan, long giaNhap,String loai,String maSach, TACGIA tacGia, int namXB, String loaiSach) {
        super(maSP,tenSP,NSX,giaBan,giaNhap,loai);
        this.maSach=maSach;
        this.tacGia=tacGia;
        this.namXB=namXB;
        this.loaiSach=loaiSach;
    }
    
    public SACH(SANPHAM sp, String string, TACGIA tacGia, int parseInt, String par1) {
       
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
        while(namXB<1900 && namXB>2023){
         System.out.println("Nhap lai nam xuat ban");
         namXB=sc.nextInt();
        }
        this.namXB = namXB;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }


    @Override
        public void input(){
        super.input();
        tacGia = new TACGIA();
//         tacGia.input1();
         setTacGia(tacGia);
        System.out.println("Nam Xuat Ban cua Sach:");
        namXB=sc.nextInt();
        boolean k = true;
	while (k == true) {
			System.out.println("Chon loai Sach:");
			System.out.println("  1. Truyen");
			System.out.println("  2. Giao Khoa");
			System.out.println("Moi ban chon: ");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				setLoaiSach("Truyen");
				System.out.println("Truyen");
				k = false;
				break;
			}
			case 2: {
				setLoaiSach("Giao Khoa");
				System.out.println("GiaoKhoa");
				k = false;
				break;
			}
			default:{
				System.out.println("Lua chon khong dung yeu cau ! Vui long chon lai");
			}
		}
	}
        }
       
    @Override
    public void output () {
            System.out.format("| %6s | %20s | %10s | %13s | %20s | %12s | %12s |%12s |\n", this.getMaSP(),this.getTenSP(),
				this.getNSX(), this.getGiaBan(), this.getGiaNhap(),this.maSach, this.namXB,this.tacGia,this.loaiSach);
	}
  
    @Override
        public String toString() {
        return getMaSach()+","+getTacGia()+","+getNamXB()+","+getLoaiSach();
    }

  

    
    
}
