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
