public class Node {
    int nomorAntrian;
    String nama;
    String layanan;
    String prioritas;
    String waktuMasuk;
    Node next = null;

    public Node(int nomorAntrian, String nama, String layanan, String prioritas, String waktuMasuk) {
        this.nomorAntrian = nomorAntrian;
        this.nama = nama;
        this.layanan = layanan;
        this.prioritas = prioritas;
        this.waktuMasuk = waktuMasuk;
    }
}