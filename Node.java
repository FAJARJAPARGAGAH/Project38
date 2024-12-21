public class Node {
    int nomorAntrian;
    String nama;
    String layanan;
    int prioritas;
    String waktuMasuk;
    String tanggal;
    Node next;
    Node left, right;

    public Node(int nomorAntrian, String nama, String layanan, int prioritas, String waktuMasuk) {
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