public class Tree {

    public static class ServiceCategoryNode {
        String category;
        ServiceCategoryNode left;
        ServiceCategoryNode right;

        public ServiceCategoryNode(String category) {
            this.category = category;
            this.left = null;
            this.right = null;
        }
    }

    public static class PriorityNode {
        String priority;
        PriorityNode left;
        PriorityNode right;

        public PriorityNode(String priority) {
            this.priority = priority;
            this.left = null;
            this.right = null;
        }
    }

    private ServiceCategoryNode serviceRoot;
    private PriorityNode priorityRoot;

    public Tree() {
        this.serviceRoot = null;
        this.priorityRoot = null;
    }

    public void addServiceCategory(String category) {
        serviceRoot = addServiceCategoryRec(serviceRoot, category);
    }

    private ServiceCategoryNode addServiceCategoryRec(ServiceCategoryNode root, String category) {
        if (root == null) {
            return new ServiceCategoryNode(category);
        }
        if (category.compareTo(root.category) < 0) {
            root.left = addServiceCategoryRec(root.left, category);
        } else if (category.compareTo(root.category) > 0) {
            root.right = addServiceCategoryRec(root.right, category);
        }
        return root;
    }

    public void addPriority(String priority) {
        priorityRoot = addPriorityRec(priorityRoot, priority);
    }

    private PriorityNode addPriorityRec(PriorityNode root, String priority) {
        if (root == null) {
            return new PriorityNode(priority);
        }
        if (priority.compareTo(root.priority) < 0) {
            root.left = addPriorityRec(root.left, priority);
        } else if (priority.compareTo(root.priority) > 0) {
            root.right = addPriorityRec(root.right, priority);
        }
        return root;
    }

    public void displayServiceCategories() {
        inorderService(serviceRoot);
    }

    private void inorderService(ServiceCategoryNode root) {
        if (root != null) {
            inorderService(root.left);
            System.out.println(root.category);
            inorderService(root.right);
        }
    }

    public void displayPriorities() {
        inorderPriority(priorityRoot);
    }

    private void inorderPriority(PriorityNode root) {
        if (root != null) {
            inorderPriority(root.left);
            System.out.println(root.priority);
            inorderPriority(root.right);
        }
    }
}
