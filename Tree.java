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

        if (prioritas.equalsIgnoreCase("Iya")) {
            node.left = addCustomerRec(node.left, nomorAntrian, nama, layanan, prioritas, waktuMasuk);
        } else {
            node.right = addCustomerRec(node.right, nomorAntrian, nama, layanan, prioritas, waktuMasuk);
        }

        return node;
    }

    public void displayByPriority() {
        System.out.println("| No. Antrian | Nama | Layanan | Prioritas | Waktu Masuk |");
        System.out.println("---------------------------------------------------------");
        preorderTraversal(root);
    }

    private void preorderTraversal(PriorityTreeNode node) {
        if (node != null) {
            System.out.println("| " + node.nomorAntrian + " | " + node.nama + " | " + node.layanan + " | " + node.prioritas + " | " + node.waktuMasuk + " |");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public PriorityTreeNode removeHighestPriority() {
        if (root == null) {
            return null;
        }
        PriorityTreeNode[] result = removeHighestPriorityRec(root, null);
        root = result[1]; 
        return result[0]; 
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
