public class Tree {
    private PriorityTreeNode root;

    public Tree() {
        this.root = null;
    }

    public void addCustomer(int nomorAntrian, String nama, String layanan, String prioritas, String waktuMasuk) {
        root = addCustomerRec(root, nomorAntrian, nama, layanan, prioritas, waktuMasuk);
    }

    private PriorityTreeNode addCustomerRec(PriorityTreeNode node, int nomorAntrian, String nama, String layanan, String prioritas, String waktuMasuk) {
        if (node == null) {
            return new PriorityTreeNode(nomorAntrian, nama, layanan, prioritas, waktuMasuk);
        }

        // "Iya" memiliki prioritas lebih tinggi
        if (prioritas.equalsIgnoreCase("Iya")) {
            node.left = addCustomerRec(node.left, nomorAntrian, nama, layanan, prioritas, waktuMasuk);
        } else {
            node.right = addCustomerRec(node.right, nomorAntrian, nama, layanan, prioritas, waktuMasuk);
        }

        return node;
    }

    // Menampilkan antrian berdasarkan prioritas
    public void displayByPriority() {
        System.out.println("| No. Antrian | Nama | Layanan | Prioritas | Waktu Masuk |");
        System.out.println("---------------------------------------------------------");
        inorderTraversal(root);
    }

    private void inorderTraversal(PriorityTreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println("| " + node.nomorAntrian + " | " + node.nama + " | " + node.layanan + " | " + node.prioritas + " | " + node.waktuMasuk + " |");
            inorderTraversal(node.right);
        }
    }

    // Menghapus nasabah dengan prioritas tertinggi (antrian depan)
    public PriorityTreeNode removeHighestPriority() {
        if (root == null) {
            return null;
        }
        PriorityTreeNode[] result = removeHighestPriorityRec(root, null);
        root = result[1]; // Update root tree
        return result[0]; // Return node with highest priority
    }

    private PriorityTreeNode[] removeHighestPriorityRec(PriorityTreeNode node, PriorityTreeNode parent) {
        if (node.left == null) {
            if (parent != null) {
                parent.left = node.right;
            }
            return new PriorityTreeNode[]{node, node.right};
        }
        return removeHighestPriorityRec(node.left, node);
    }
}
