public class Nasabah {
    int nomorAntrian;
    String nama;
    String layanan;
    int prioritas;
    String waktuMasuk;
    Nasabah next;
    Nasabah left, right;

    public Nasabah(int nomorAntrian, String nama, String layanan, int prioritas, String waktuMasuk) {
        this.nomorAntrian = nomorAntrian;
        this.nama = nama;
        this.layanan = layanan;
        this.prioritas = prioritas;
        this.waktuMasuk = waktuMasuk;
        this.next = null;
        this.left = null;
        this.right = null;
    }
}