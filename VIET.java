package SANPHAM;

import java.util.Scanner;

public class VIET extends DUNGCUHOCTAP {
    private String mauSac;
    private String loaiViet;
    Scanner sc = new Scanner(System.in);
    public VIET() {
    }
     public VIET(SANPHAM sanpham,String maDungCu,String chucNang, String loaiDungCu, String mauSac,String loaiViet) {
        super(sanpham,maDungCu,chucNang,loaiDungCu);
        this.mauSac =mauSac;
        this.loaiViet = loaiViet;
    }
    public VIET(String maSP,String tenSP,String NSX,long giaBan, long giaNhap,String loai,String maDungCu, String chucNang,String loaiDungCu, String mauSac,String loaiViet) {
        super(maSP,tenSP,NSX,giaBan, giaNhap,loai,maDungCu,chucNang,loaiDungCu);
        this.mauSac =mauSac;
        this.loaiViet = loaiViet;
    }

    public String getMauSac() {
        return mauSac;
    }
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public String getLoaiViet() {
        return loaiViet;
    }
    public void setLoaiViet(String loaiViet) {
        this.loaiViet = loaiViet;
    }
    @Override
    public void input(){
        super.input();
        System.out.println("Nhap mau sac cua viet:");
        mauSac=sc.nextLine();
        System.out.println("Nhap loai viet:");
        loaiViet=sc.nextLine();
    }
    @Override
    public void output(){
        System.out.format("| %6s | %13s | %12s | %14s | %13s | %20s  | %10s | %13s|%12s|\n", this.getMaSP(),this.getNSX(),this.getTenSP(),this.getGiaBan(),this.getGiaNhap(),this.getLoai(),this.getChucNang(),this.getMaDungCu(),this.getMauSac(),this.getLoaiViet());
    }
    @Override
    public String toString(){
        return getMauSac()+","+getLoaiViet();
    }

    
}
