package SANPHAM;

import java.util.Scanner;

public class THUOC extends DUNGCUHOCTAP{
    private String kichCoThuoc;
    private String loaiThuoc;
    Scanner sc = new Scanner(System.in);
    public THUOC() {
    }

    public THUOC(SANPHAM sanpham,String maDungCu,String chucNang, String loaiDungCu, String kichCoThuoc, String loaiThuoc) {
        super(sanpham, maDungCu,chucNang,loaiDungCu);
        this.kichCoThuoc = kichCoThuoc;
        this.loaiThuoc = loaiThuoc;
    }
    public THUOC(String maSP,String tenSP,String NSX,long giaBan, long giaNhap,String loai,String maDungCu, String chucNang,String loaiDungCu, String kichCoThuoc, String loaiThuoc) {
        super(maSP,tenSP,NSX,giaBan, giaNhap,loai,maDungCu,chucNang,loaiDungCu);
        this.kichCoThuoc =kichCoThuoc;
        this.loaiThuoc = loaiThuoc;
    }

    public String getLoaiThuoc(){
        return this.loaiThuoc;
    }
    public void setLoaiThuoc(String loaiThuoc){
        this.loaiThuoc=loaiThuoc;
    }
     public String getKichCoThuoc(){
        return kichCoThuoc;
    }
    public void setKichCoThuoc (String kichCoThuoc){
        this.kichCoThuoc=kichCoThuoc;
    }
    @Override
    public void input(){
        super.input();
        System.out.println("nhap kich co cua thuoc");
        kichCoThuoc=sc.nextLine();
        System.out.println("Nhap loai thuoc");
        loaiThuoc=sc.nextLine();
    }
    @Override
    public void output() {
        System.out.format("| %12s | %5s | %14s | %13s | %20s  | %10s | %13s|%12s| \n", this.getMaSP(),this.getNSX(),this.getTenSP(),this.getGiaBan(),this.getGiaNhap(),this.getLoai(),
        this.getChucNang(),this.getMaDungCu(),this.getKichCoThuoc(),this.getLoaiThuoc());
    }
    @Override
    public String toString() {
        return getKichCoThuoc()+","+getLoaiThuoc();
    }
}