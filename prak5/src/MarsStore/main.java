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
