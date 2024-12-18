public class Stack {

    private static class HistoryNode {
        String action;
        HistoryNode next;

        public HistoryNode(String action) {
            this.action = action;
            this.next = null;
        }
    }

    private HistoryNode top;

    public Stack() {
        this.top = null;
    }

    public void push(String action) {
        HistoryNode newNode = new HistoryNode(action);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public String pop() {
        if (top == null) {
            return null;
        } else {
            String action = top.action;
            top = top.next;
            return action;
        }
    }

    public String peek() {
        if (top == null) {
            return null;
        } else {
            return top.action;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayHistory() {
        if (top == null) {
            System.out.println("History is empty.");
        } else {
            System.out.println("Action History:");
            HistoryNode current = top;
            while (current != null) {
                System.out.println(current.action);
                current = current.next;
            }
        }
    }
}