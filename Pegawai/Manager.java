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
