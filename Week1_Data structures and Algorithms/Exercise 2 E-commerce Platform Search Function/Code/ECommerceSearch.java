import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new TreeMap<>();
    boolean isEndOfWord = false;
    String word = null;
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isEndOfWord = true;
        node.word = word;
    }

    public List<String> searchByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;

        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return result;
            }
            node = node.children.get(ch);
        }

        dfs(node, result);
        return result;
    }

    private void dfs(TrieNode node, List<String> result) {
        if (node.isEndOfWord) {
            result.add(node.word);
        }
        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), result);
        }
    }
}

public class ECommerceSearch {

    public static List<String> searchProducts(String[] products, String searchPrefix) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product.toLowerCase());
        }
        return trie.searchByPrefix(searchPrefix.toLowerCase());
    }

    public static void main(String[] args) {
        String[] products = {"laptop", "lamp", "keyboard", "camera", "laptop stand"};
        String prefix = "la";

        List<String> result = searchProducts(products, prefix);
        for (String product : result) {
            System.out.println(product);
        }
    }
}
