# OOP-PRAKTIKUM-5
## Latihan
Class Pegawai:
```java
package Pegawai;

public class Pegawai {
    private String nama;
    private double gajiPokok;

    public Pegawai (String nama, double gajiPokok) {
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    // Setter dan Getter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Setter dan Getter untuk gajiPokok
    public double getGajiPokok() {
        return gajiPokok;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    // Method untuk mencetak informasi pegawai
    public void cetakInfo() {
        System.out.println("Nama Pegawai  : " + this.nama);
        System.out.println("Gaji Pokok    : " + this.gajiPokok);
    }
}
```

Class Manager:
```java
package Pegawai;

public class Manager extends Pegawai {
    private double tunjangan;

    public Manager(String nama, double gajiPokok, double tunjangan) {
        super(nama, gajiPokok);
        this.tunjangan = tunjangan;
    }

    // Setter dan Getter untuk tunjangan
    public double getTunjangan() {
        return tunjangan;
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    // Method untuk mencetak informasi manajer
    @Override
    public void cetakInfo() {
        super.cetakInfo(); // Memanggil metode dari kelas Pegawai
        System.out.println("Tunjangan      : " + this.tunjangan);
    }
}
```

Class Programmer:
```java
package Pegawai;

public class Programmer extends Pegawai {
    private double bonus;

    public Programmer(String nama,double gajiPokok, double bonus) {
        super(nama, gajiPokok);
        this.bonus = bonus;
    }

    // Setter dan Getter untuk bonus
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // Method untuk mencetak informasi programmer
    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("Bonus          : " + this.bonus);
    }
}
```

Class Main:
```java
package Pegawai;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Manager
        Manager manager = new Manager("Agung",1000000,1500000);
        manager.cetakInfo();
        System.out.println();

        // Membuat objek Programmer
        Programmer programmer = new Programmer("Yoga",2000000,2500000);
        programmer.cetakInfo();
    }
}

```
Output:
![](doc/3.png)

## Sistem Pembelian Online dengan Keranjang Belanja

Class Produk:
```java
package MarsStore;
public class Produk {
    private String namaProduk;
    private int harga;
    private int jumlahStok;

    public Produk(String namaProduk, int harga, int jumlahStok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }

    // Setter NamaProduk
    public String getNamaProduk() {
        return namaProduk;
    }

    // Setter Harga
    public int getHarga() {
        return harga;
    }

    // Setter JumlahStok
    public int getJumlahStok() {
        return jumlahStok;
    }


    public void kurangiStok(int jumlah) {
        this.jumlahStok -= jumlah;
    }

    public void displayInfo(){
        System.out.println("Toko Indo April");
        System.out.println("Nama Produk : " + namaProduk);
        System.out.println("Harga Produk : " + harga);
        System.out.println("Jumlah Stok : " + jumlahStok);
    }
}
```

Class elektronik:
```java
package MarsStore;
public class elektronik extends Produk {
    private int garansi;

    public elektronik (String namaProduk, int harga, int jumlahStok, int garansi) {
        super(namaProduk, harga, jumlahStok);
        this.garansi = garansi;
    }

    // Setter dan Getter Garansi
    public int getGaransi() {
        return garansi;
    }

    public void setGaransi(int garansi) {
        this.garansi = garansi;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Garansi: " + this.garansi + " tahun");

    }
}
```

Class makanan:
```java
package MarsStore;

import java.util.Date;

public class makanan extends Produk {
    private Date exp;

    public makanan(String namaProduk,int harga,int jumlahStok, Date exp) {
        super(namaProduk, harga, jumlahStok);
        this.exp = exp;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Tanggal Exp: " + this.exp);
    }

}
```

Class pakaian:
```java
package MarsStore;

public class pakaian extends Produk {
    private String ukuran;
    private String warna;

    public pakaian (String namaProduk, int harga,int jumlahStok, String ukuran, String warna) {
        super(namaProduk, harga, jumlahStok);
        this.ukuran = ukuran;
        this.warna = warna;
    }

    // Setter Ukuran
    public String getUkuran() {
        return ukuran;
    }

    // Setter Warna
    public String getWarna() {
        return warna;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Ukuran : " + this.ukuran);
        System.out.println("Warna : " + this.warna);
    }

}
```

Class keranjangBelanja:
```java
package MarsStore;
import java.util.ArrayList;

public class keranjangBelanja {
    private ArrayList<ItemKeranjang> keranjang;

    public keranjangBelanja() {
        keranjang = new ArrayList<>();
    }

    public void tambahProduk(Produk p, int jumlah) {
        if (p.getJumlahStok() >= jumlah) {
            p.kurangiStok(jumlah);
            keranjang.add(new ItemKeranjang(p, jumlah));
            System.out.println("Produk " + p.getNamaProduk() + " ditambahkan sebanyak " + jumlah);
        } else {
            System.out.println("Stok tidak mencukupi untuk produk " + p.getNamaProduk());
        }
    }

    public int hitungTotalBelanja() {
        int total = 0;
        for (ItemKeranjang item : keranjang) {
            total += item.getProduk().getHarga() * item.getJumlah();
        }
        return total;
    }

    public void displayKeranjang() {
        System.out.println("Isi Keranjang Belanja:");
        for (ItemKeranjang item : keranjang) {
            System.out.println("- " + item.getProduk().getNamaProduk() + " x" + item.getJumlah() +
                               " = Rp" + (item.getProduk().getHarga() * item.getJumlah()));
        }
        System.out.println("Total Belanja: Rp" + hitungTotalBelanja());
    }

    private class ItemKeranjang {
        private Produk produk;
        private int jumlah;

        public ItemKeranjang(Produk produk, int jumlah) {
            this.produk = produk;
            this.jumlah = jumlah;
        }

        public Produk getProduk() {
            return produk;
        }

        public int getJumlah() {
            return jumlah;
        }
    }
}
```

Class main:
```java
package MarsStore;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        // Membuat beberapa produk
        elektronik tv = new elektronik("TV", 3000000, 10, 2);
        pakaian kaos = new pakaian("Kaos", 60000, 15, "XL", "Merah");
        makanan roti = new makanan("Roti", 6000, 20, new Date());

        // Membuat keranjang belanja
        keranjangBelanja keranjang = new keranjangBelanja();

        // Menambahkan produk ke keranjang
        keranjang.tambahProduk(tv, 2);
        keranjang.tambahProduk(kaos, 4);
        keranjang.tambahProduk(roti, 8);

        // Menampilkan isi keranjang
        keranjang.displayKeranjang();
    }
}
```

Output:
![](doc/1.png)
