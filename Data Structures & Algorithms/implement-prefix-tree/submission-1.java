class PrefixTree {
    private static class Node {
        Node[] links = new Node[26];
        boolean isEnd = false;
    }

    private Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(node.links[idx] == null) {
                node.links[idx] = new Node();
            }
            node = node.links[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = find(word);
        return node == null ? false : node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private Node find(String word) {
        Node temp = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(temp.links[index] == null) {
                return null;
            }
            temp = temp.links[index];
        }
        return temp;
    }
}
