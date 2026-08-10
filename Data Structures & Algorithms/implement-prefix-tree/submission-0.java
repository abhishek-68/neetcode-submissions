class Node {
    Node[] links = new Node[26];
    boolean eow = false;
    Node() {}

    boolean containsKey(char ch) {
        return links[ch-'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch-'a'] = node;
    }

    Node get(char ch) {
        return links[ch-'a'];
    }

    void setEnd() {
        eow = true;
    }

    boolean isEnd() {
        return eow;
    }
}

class PrefixTree {

    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            // move to next node
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(char ch : word.toCharArray()) {
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()) {
            if(!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}
