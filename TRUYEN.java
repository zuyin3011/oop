package SANPHAM;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
import SANPHAM.SACH;
import java.util.Scanner;
public class TRUYEN extends SACH{
    private String ngonNgu;
    private String loaiTruyen;
    Scanner sc= new Scanner(System.in);


   public TRUYEN(String maSach, TACGIA tacGia, int namXB,String loaiSach, String ngonNgu, String loaiTruyen) {
    super(maSach,tacGia, namXB, loaiSach);
    this.ngonNgu = ngonNgu;
    this.loaiTruyen = loaiTruyen;
}


    public TRUYEN(SACH sach,String ngonNgu,String loaiTruyen){
        super(sach.getSanPham(),sach.getMaSach(),sach.getTacGia(),sach.getNamXB(),sach.getLoaiSach());
        this.ngonNgu=ngonNgu;
        this.loaiTruyen=loaiTruyen;
    }

    public TRUYEN() { 
    }
    
    public TRUYEN(String maSP,String tenSP, String NSX, long giaBan, long giaNhap,String loai,String maSach, TACGIA tacGia, int namXB, String loaiSach, String ngonNgu, String loaiTruyen) {
        super(maSP,tenSP, NSX, giaBan, giaNhap,loai,maSach, tacGia, namXB, loaiSach);
        this.ngonNgu = ngonNgu;
        this.loaiTruyen = loaiTruyen;
    }
    


    
    
    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getLoaiTruyen() {
        return loaiTruyen;
    }

    public void setLoaiTruyen(String loaiTruyen) {
        this.loaiTruyen = loaiTruyen;
    }
        @Override
        public void input(){
        
        super.input();
       
        System.out.println("nhap ngon ngu cua truyen:");
        ngonNgu=sc.nextLine();
        sc.nextLine();
        System.out.println("nhap loai truyen cua truyen:");
        loaiTruyen=sc.nextLine();
        
        }
    @Override
   	public void output () {
            System.out.format("| %6s | %20s | %10s | %13s | %13s | %20s | %12s | %6s | %12s | %12s| %10s|\n",  this.getMaSP(),this.getTenSP(),
				this.getNSX(), this.getGiaBan(), this.getGiaNhap(),this.getLoai(),this.getMaSach(),this.getTacGia(),this.getNamXB(),this.getLoaiSach(),this.ngonNgu,this.loaiTruyen);
	}  
    @Override
        public String toString() {
        return getNgonNgu()+","+getLoaiTruyen();
        }
  

    
     
    
}
