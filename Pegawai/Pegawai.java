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
