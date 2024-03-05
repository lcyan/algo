package cn.vvspace.algo.datastruct;

@SuppressWarnings("unchecked")
public class ThirdHashMap<K, V> {

    public V get(K key) {
        int hash = hash(key);
        Node<K, V> node = bukets[getIndexOf(hash, bukets.length)];
        while (node != null) {
            if (hash == node.hash && (key == node.key || key.equals(node.key))) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    private int getIndexOf(int hash, int length) {
        int index = hash % length;
        return Math.abs(index);
    }

    final int DEFAULT_CAPACITY = 16;
    final float LOAD_FACTOR = 0.75f;
    Node<K, V>[] bukets;
    private int size;

    public ThirdHashMap() {
        bukets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public ThirdHashMap(int capacity) {
        bukets = new Node[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        if (size >= bukets.length * LOAD_FACTOR) {
            resize();
        }
        putVal(hash(key), key, value, bukets);
    }

    private void putVal(int hash, K key, V value, Node<K, V>[] table) {
        int index = getIndexOf(hash, table.length);
        Node<K, V> node = table[index];

        if (node == null) {
            table[index] = new Node<>(hash, key, value);
            size++;
            return;
        }

        while (node != null) {
            if (node.hash == hash && (node.key == key || node.key.equals(key))) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        Node<K, V> newNode = new Node<>(hash, key, value, table[index]);
        table[index] = newNode;
        size++;
    }

    private void resize() {
        Node<K, V>[] newBuckets = new Node[bukets.length * 2];
        rehash(newBuckets);
        bukets = newBuckets;
    }

    private void rehash(Node<K, V>[] newBuckets) {
        size = 0;
        for (Node<K, V> buket : bukets) {
            Node<K, V> node = buket;
            while (node != null) {
                putVal(hash(node.key), node.key, node.value, newBuckets);
                node = node.next;
            }
        }
    }

    class Node<K, V> {
        private final int hash;
        private K key;
        private V value;

        private Node<K, V> next;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    final int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode();
    }
}

