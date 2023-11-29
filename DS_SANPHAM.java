/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SANPHAM;

/**
 *
 * @author ADMIN
 */
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;

public class DS_SANPHAM implements DOCGHIFILE , CHUCNANG {
      private static int soLuong = 0;
    static Scanner sc = new Scanner(System.in);
   private static final int max_sach = 100; 
    private SANPHAM[] dssp;
        public DS_SANPHAM() {
       dssp=new SANPHAM[max_sach];
       soLuong=0;
    }

    public SANPHAM[] getDS_SANPHAM() {
        return dssp;
    }

    public static int getSoLuong() {
        return soLuong;
    }
    @Override

public void readFromFile(String tenFile) {
     dssp = new SANPHAM[200]; 
     soLuong = 0; 
    try {
         try (FileReader fr = new FileReader("SanPham.txt"); BufferedReader br = new BufferedReader(fr)) {
             String line;
             while ((line = br.readLine()) != null) {
                 if(line.trim() !=null){
                     String txt[ ] = line.split(",");
                     System.out.println("First element (should be maSP): " + txt[0]);
                     String maSP = txt[0];
                     String tenSP = txt[1];
                     String NSX = txt[2];
                     long giaBan = Long.parseLong(txt[3]);
                     long giaNhap = Long.parseLong(txt[4]);
                     String loai=txt[5];
                     if (loai.equalsIgnoreCase("Sach")) {
                         String maSach = txt[6];
                         TACGIA tacGia = new TACGIA();
                         tacGia.setTenTG(txt[7]);
                         tacGia.setQueQuan(txt[8]);
                         int namXB = Integer.parseInt(txt[9]);
                         String loaiSach = txt[10];
                         
                         if (loaiSach.equalsIgnoreCase("Truyen")) {
                             String ngonNgu = txt[11];
                             String loaiTruyen = txt[12];
                             TRUYEN truyen =new TRUYEN(maSP,tenSP,NSX,giaBan,giaNhap,loai,maSach,tacGia,namXB,loaiSach,ngonNgu,loaiTruyen);
                             dssp[soLuong] = truyen;
                             soLuong++;
                             
                         } else if (loaiSach.equalsIgnoreCase("Giao Khoa")) {
                             int lop = Integer.parseInt(txt[10]);
                             String mon = txt[11];
                             GIAOKHOA giaoKhoa= new GIAOKHOA(maSP,tenSP,NSX,giaBan,giaNhap,loai,maSach,tacGia,namXB,loaiSach,lop,mon);
                             dssp[soLuong] = giaoKhoa;
                             soLuong++;
                         }
                     }
                     else if(loai.equalsIgnoreCase("Dung Cu Hoc Tap")){
                         String maDungCu=txt[6];
                         String chucNang=txt[7];
                         String loaiDungCu=txt[8];
                         if (loaiDungCu.equalsIgnoreCase("Gom")) {
                             String loaiGom = txt[9];
                             String kichCo = txt[10];
                             GOM gom =new GOM(maSP,tenSP,NSX,giaBan,giaNhap,loai,maDungCu,chucNang,loaiDungCu,loaiGom,kichCo);
                             dssp[soLuong] = gom;
                             soLuong++;
                             
                         } else if (loaiDungCu.equalsIgnoreCase("Thuoc")) {
                             String kichCoThuoc=txt[9];
                             String loaiThuoc=txt[10];
                             THUOC thuoc= new THUOC(maSP,tenSP,NSX,giaBan,giaNhap,loai,maDungCu,chucNang,loaiDungCu,kichCoThuoc,loaiThuoc);
                             dssp[soLuong] = thuoc;
                             soLuong++;
                         }
                         else if (loaiDungCu.equalsIgnoreCase("Viet")) {
                             String mauSac=txt[9];
                             String loaiViet=txt[10];
                             VIET viet= new VIET(maSP,tenSP,NSX,giaBan,giaNhap,loai,maDungCu,chucNang,loaiDungCu,mauSac,loaiViet);
                             dssp[soLuong] = viet;
                             soLuong++;
                         }
                         
                     }
                 }
                 
             }
         }
        System.out.println("Doc file thanh cong");
    } catch (IOException | NumberFormatException e) {
    }
}
    @Override
public void writeToFile(String tenFile) {
    try {
        try (FileWriter fw = new FileWriter("SanPham.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < soLuong; i++) {
                SANPHAM sp = dssp[i];
                String line = sp.getMaSP()+","+sp.getTenSP() + "," + sp.getNSX() + "," + (long)sp.getGiaBan() + "," +(long) sp.getGiaNhap() + ","+sp.getLoai()+",";
                if (sp instanceof  SACH) {
                    SACH sach = (SACH) sp;
                    line += sach.getMaSach() + "," + sach.getTacGia().getTenTG() + "," + sach.getTacGia().getQueQuan() + "," + sach.getNamXB() + "," + sach.getLoaiSach();
                    if (sach instanceof TRUYEN) {
                        TRUYEN truyen = (TRUYEN) sach;
                        line += "," + truyen.getNgonNgu() + "," + truyen.getLoaiTruyen();
                    } else if (sach instanceof GIAOKHOA) {
                        GIAOKHOA giaoKhoa = (GIAOKHOA) sach;
                        line += "," + giaoKhoa.getLop() + "," + giaoKhoa.getMon();
                    }
                    
                }
                if (sp instanceof  DUNGCUHOCTAP) {
                    DUNGCUHOCTAP dcht = (DUNGCUHOCTAP) sp;
                    line += dcht.getMaDungCu() +  "," +dcht.getChucNang()+ ","+dcht.getLoaiDungCu();
                    if (dcht instanceof THUOC) {
                        THUOC thuoc = (THUOC) dcht;
                        line += "," + thuoc.getKichCoThuoc() + "," + thuoc.getLoaiThuoc();
                    } else if(dcht instanceof VIET){
                        VIET viet = (VIET) dcht;
                        line += "," + viet.getMauSac() + "," + viet.getLoaiViet();
                    }
                    else if(dcht instanceof GOM){
                        GOM gom = (GOM) dcht;
                        line += "," + gom.getKichCo() + "," + gom.getLoaiGom();
                    }
                    
                }
                bw.write(line);
                bw.newLine();
            }
        }
        System.out.println("Viet vao file thanh cong");
    } catch (IOException e) {
    }
}
    
 @Override
    public void Them() {
        System.out.println("Chon loai San Pham muon them: ");
        System.out.println("1.Dung Cu Hoc Tap: ");
        System.out.println("2.Sach: ");
         int luachon = sc.nextInt();
          switch (luachon) {
              case 1:{


        System.out.println("Chon Loai Dung Cu:");
        System.out.println("1. Thuoc");
        System.out.println("2. Viet");
        System.out.println("3. Gom");
        int choice = sc.nextInt();

        DUNGCUHOCTAP dc1;
        switch (choice) {
            case 1:
                dc1 = new THUOC();
                break;
            case 2:
                dc1 = new VIET();
                break;
            case 3:
                dc1 = new GOM();
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                return; 
        }

        if (dc1 != null) {
           
            dc1.input();
            dssp[soLuong] = dc1;
            soLuong++;
            System.out.println("Them San Pham thanh cong.");
        }
        break;
              }
              case 2:{
                      if (soLuong == dssp.length) {
            dssp = java.util.Arrays.copyOf(dssp, dssp.length * 2);
        }

        System.out.println("Chon Loai Sach:");
        System.out.println("1. Truyen");
        System.out.println("2. Giao khoa");
        int choice = sc.nextInt();

        SACH sach1;
        TACGIA tacGia=new TACGIA();
        switch (choice) {
            case 1:
                sach1 = new TRUYEN();
                break;
            case 2:
                sach1 = new GIAOKHOA();
                break;
            default:
                System.out.println("Lua chon khong hop le.");
                return; 
        }

        if (sach1 != null) {
           
            sach1.input();
            tacGia.input1();
            sach1.setTacGia(tacGia);
            dssp[soLuong] = sach1;
            soLuong++;
            System.out.println("Them San Pham thanh cong.");
        }
              
              break;
              }
          }
      
    }
    
    @Override

   public void Sua() {
    System.out.println("Nhap ma SP can sua: ");
    String maSP = sc.nextLine();


    
    if (maSP.startsWith("dc")) {
        int index = -1;
        for (int i = 0; i < dssp.length; i++) {
            if (dssp[i] != null && dssp[i].getMaSP() != null && dssp[i].getMaSP().equals(maSP)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            SANPHAM sp2 = dssp[index];
            if (sp2 instanceof GOM) {
                GOM gom = new GOM();
                gom.input();
               dssp[index] = gom;
            } else if (sp2 instanceof VIET) {
                VIET viet = new VIET();
                viet.input();
                dssp[index] = viet;
            } else if (sp2 instanceof THUOC) {
                THUOC thuoc = new THUOC();
                thuoc.input();
                dssp[index] = thuoc;
            }
            System.out.println("Sua SP thanh cong.");
        } else {
            System.out.println("Khong tim thay SP co ma 111 " + maSP);
        }
    }
    if(maSP.startsWith("s")){
     int index = -1;
    for (int i = 0; i < dssp.length; i++) {
        if (dssp[i] != null && dssp[i].getMaSP() != null && dssp[i].getMaSP().equals(maSP)) {
            index = i;
            break;
        }
    }
    if (index != -1) {
        SANPHAM sp1 = dssp[index];
         TACGIA tacGia=new TACGIA();
        if ( sp1 instanceof TRUYEN) {
            TRUYEN truyen = new TRUYEN();
            truyen.input();
            tacGia.input1();
            truyen.setTacGia(tacGia);
            dssp[index] = truyen;
        } else if (sp1 instanceof GIAOKHOA) {
            GIAOKHOA giaoKhoa = new GIAOKHOA();
            giaoKhoa.input();
            tacGia.input1();
            giaoKhoa.setTacGia(tacGia);
            dssp[index] = giaoKhoa;
        }
        System.out.println("Sua Sach thanh cong.");
    } else {
        System.out.println("Khong tim thay Sach co ma " + maSP);
    }
    
    }
}
   
   @Override
public void Xoa() {
  System.out.println("Nhap vao Ma SP cần xóa: ");
        String IDxoa=sc.nextLine();
        
        int index=-1;
        for (int i=0; i<soLuong; i++){
            if (dssp[i].getMaSP().equals(IDxoa)){
                index=i;
                break;
            }
        }
        if (index==-1)
            System.out.println("Không tồn tại ID sách này.");
        else {
            for (int i=index; i<soLuong; i++)
                dssp[i]=dssp[i+1];
            System.out.println("Đã xóa sách có ID: "+IDxoa);
            soLuong--;
        }
}
    
      @Override
 public void timKiem(){
        System.out.println("Tìm kiếm San Pham theo: ");
        System.out.println("1.ma san pham");
        System.out.println("2.Ten San Pham");
        System.out.println("3.Khoang Gia Ban");
         System.out.println("4.Loai SP");
        System.out.println("0.Thoát");
        int luaChon=-1;
             String choose = sc.nextLine();
            luaChon = Integer.parseInt(choose);
        while (luaChon>=0){
            
            switch(luaChon){
               case 1:
    while(true){
        System.out.println("Nhap vao ma SP: ");
        String ID=sc.nextLine();
        boolean check=false;
        for (SANPHAM dssp1 : dssp) {
            if (dssp1 != null && dssp1.getMaSP().equals(ID)) {
                check=true;
                break;
            }
        }
        if (check==true){
            for (SANPHAM dssp1 : dssp) {
                if (dssp1 != null && dssp1.getMaSP().equals(ID)) {
                    dssp1.output();
                    System.out.println("--------------------");
                    break;
                }
            }
            break;  
        }
        else{
            System.out.println("Ma SP không tồn tại.");
            return;
        }
    }



                    break;
                case 2:
                    while (true) {
    System.out.println("Nhap ten Sach: ");
    String tenSP = sc.nextLine().toUpperCase();
    boolean check = false;
    for (SANPHAM dssp1 : dssp) {
        if (dssp1.getTenSP().toUpperCase().compareTo(tenSP) == 0) {
            check = true;
            break;
        }
    }
    if (check == true) {
        for (SANPHAM dssp1 : dssp) {
            if (dssp1.getTenSP().toUpperCase().equals(tenSP)) {
                dssp1.output();
                System.out.println("--------------------");
                break;  // Đặt break ở đây để thoát khỏi vòng lặp for
            }
        }
        break;  // Đặt break ở đây để thoát khỏi vòng lặp while
    } else {
        System.out.println("Ten SP khong ton tai!! Vui long nhap lai");
        return;
    }
}

            break;
                case 3:
while (true) {
    System.out.println("Nhap gia tien thap nhat: ");
    double giaThapNhat=sc.nextLong();
    System.out.println("Nhap gia tien cao nhat: ");
    double giaCaoNhat=sc.nextLong();
    boolean check = false;
    for (SANPHAM dssp1 : dssp) {
        if (dssp1.getGiaBan() > giaThapNhat && dssp1.getGiaBan() < giaCaoNhat) {
            check = true;
            break;
        }
    }
    if (check == true) {
        for (SANPHAM dssp1 : dssp) {
            if (dssp1.getGiaBan() > giaThapNhat && dssp1.getGiaBan() < giaCaoNhat) {
                dssp1.output();
                System.out.println("--------------------");
                break;  // Đặt break ở đây để thoát khỏi vòng lặp for
            }
        }
        break;  // Đặt break ở đây để thoát khỏi vòng lặp while
    } else {
        System.out.println("KHong co san pham nao trong khoang gia");
    }
    break;  // Đặt break ở đây để thoát khỏi vòng lặp while nếu không tìm thấy sản phẩm
}

                                      break;
                case 4:
         System.out.println("Chon loai SP can tim:");
        System.out.println("1. Dung cu hoc tap");
        System.out.println("2. Sach");
        int choice = sc.nextInt();

        
switch (choice) {
    case 1:{
        boolean check = false;
        for (SANPHAM dssp1 : dssp) {
            if (dssp1.getLoai().equals("Dung Cu Hoc Tap")) {
                check=true;
                break;
            }
        }
        if (check == true) {
            for (SANPHAM dssp1 : dssp) {
                if (dssp1.getLoai().equals("Dung Cu Hoc Tap")) {
                    dssp1.output();
                    System.out.println("--------------------");
                    break;  // Đặt break ở đây để thoát khỏi vòng lặp for
                }
            }
        }
        break;
    }
    case 2:{
        boolean check = false;
        for (SANPHAM dssp1 : dssp) {
            if (dssp1.getLoai().equals("Sach")) {
                check=true;
                break;
            }
        }
        if (check == true) {
            for (SANPHAM dssp1 : dssp) {
                if (dssp1.getLoai().equals("Sach")) {
                    dssp1.output();
                    System.out.println("--------------------");
                    break;  // Đặt break ở đây để thoát khỏi vòng lặp for
                }
            }
        }
        break;    
    }
    default:{
        System.out.println("Lua chon khong hop le.");
        return;
    }
}

        break;
                    
            }
        }
 }
  @Override
        
         public void hienThiDanhSach() {
    for (int i = 0; i < soLuong; i++) {
        SANPHAM sp = dssp[i];
        System.out.println("SP thứ " + (i+1) + ":");
        System.out.println("Ma San pham:"+sp.getMaSP());
        System.out.println("Tên SP: " + sp.getTenSP());
        System.out.println("NSX: " + sp.getNSX());
        System.out.println("Giá Bán: " + sp.getGiaBan());
        System.out.println("Giá Nhập: " + sp.getGiaNhap());
        if( sp instanceof SACH ){
             SACH sach = (SACH) sp;
        System.out.println("Mã Sách: " + sach.getMaSach());
        System.out.println("Tên TG: " + sach.getTacGia().getTenTG());
        System.out.println("Quê Quán: " + sach.getTacGia().getQueQuan());
        System.out.println("Năm XB: " + sach.getNamXB());
        System.out.println("Loại Sách: " + sach.getLoaiSach());
        if (sp instanceof TRUYEN) {
            TRUYEN truyen = (TRUYEN) sach;
            System.out.println("Ngôn Ngữ: " + truyen.getNgonNgu());
            System.out.println("Loại Truyện: " + truyen.getLoaiTruyen());
        } else if (sp instanceof GIAOKHOA) {
            GIAOKHOA giaoKhoa = (GIAOKHOA) sach;
            System.out.println("Lớp: " + giaoKhoa.getLop());
            System.out.println("Môn: " + giaoKhoa.getMon());
        }
        System.out.println();
    }
         if( sp instanceof  DUNGCUHOCTAP){
         DUNGCUHOCTAP dcht = (DUNGCUHOCTAP) sp;
         System.out.println("Mã Dung Cu Hoc Tap: " + dcht .getMaDungCu());
        System.out.println("Chuc Nang: " + dcht .getChucNang());
        System.out.println("Loai Dung cu: " + dcht .getLoaiDungCu());
        if ( dcht  instanceof  GOM) {
            GOM gom = (GOM) dcht;
            System.out.println("Kich Co: " + gom.getKichCo());
            System.out.println("Loại Gom: " + gom.getLoaiGom());
        } else if (dcht instanceof VIET) {
              VIET viet = (VIET) dcht;
            System.out.println("Mau sac: " + viet.getMauSac());
            System.out.println("Loai Thuoc: " + viet.getLoaiViet());
        }
        else if (dcht instanceof THUOC) {
              THUOC thuoc = (THUOC) dcht;
            System.out.println("Kich co: " + thuoc.getKichCoThuoc());
            System.out.println("Loai Thuoc: " + thuoc.getLoaiThuoc());
        }
         }
    }

         }
}
