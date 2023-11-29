/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SANPHAM;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;
public class menu {
    private DS_SANPHAM dsSanPham;
    Scanner sc = new Scanner(System.in);

   public menu(){
      dsSanPham = new DS_SANPHAM();
   }
   private void hienThiMenu() {
    System.out.println("---- MENU ----");
    System.out.println("1. Them San Pham");
    System.out.println("2. Xoa San Pham");
    System.out.println("3. Sua thong tin San Pham");
    System.out.println("4. Hien thi danh sach San Pham");
    System.out.println("5. Tim kiem ten dung cu");
    System.out.println("6. Ghi vao file");
    System.out.println("7.Đoc file dung cu");
    System.out.println("0. Thoat");
}
public void runsp() {
    dsSanPham = new DS_SANPHAM();
    int luaChon;
    do {
        hienThiMenu();
        System.out.print("Nhap lua chon cua ban: ");
        luaChon = sc.nextInt();
        sc.nextLine(); 

        switch (luaChon) {
            case 1: 
               dsSanPham.Them();
               break;
            case 2:
               dsSanPham.Xoa();
               break;
            case 3:
               dsSanPham.Sua();
                break;
            case 4:
                dsSanPham.hienThiDanhSach();
                break;
            case 5:
                dsSanPham.timKiem();
                break;
            case 6:
                dsSanPham.writeToFile("SanPham.txt");
                break;
            case 7:
                dsSanPham.readFromFile("SanPham.txt");
                break;
             case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
              default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
            }
        } while (luaChon != 0);
    }
}
