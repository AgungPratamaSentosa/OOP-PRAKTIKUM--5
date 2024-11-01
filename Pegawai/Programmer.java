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
