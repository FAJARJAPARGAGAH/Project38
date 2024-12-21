public class PriorityTreeNode {
    int nomorAntrian;
    String nama;
    String layanan;
    String prioritas;
    String waktuMasuk;
    PriorityTreeNode left;
    PriorityTreeNode right;

    public PriorityTreeNode(int nomorAntrian, String nama, String layanan, String prioritas, String waktuMasuk) {
        this.nomorAntrian = nomorAntrian;
        this.nama = nama;
        this.layanan = layanan;
        this.prioritas = prioritas;
        this.waktuMasuk = waktuMasuk;
        this.left = null;
        this.right = null;
    }
}
