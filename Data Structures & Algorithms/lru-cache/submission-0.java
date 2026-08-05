class Pair {
    int first;
    int second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}

class LRUCache {

    ArrayList<Pair> cache;
    int n;

    public LRUCache(int capacity) {
        n = capacity;
        cache = new ArrayList<>();
    }

    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).first == key) {
                Pair temp = cache.get(i);
                cache.remove(i);
                cache.add(temp); // Move to most recently used
                return temp.second;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        // If key exists, update value and move to end
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).first == key) {
                Pair temp = cache.get(i);
                temp.second = value; // Update value
                cache.remove(i);
                cache.add(temp); // Move to most recently used
                return;
            }
        }

        // Remove least recently used if full
        if (cache.size() == n) {
            cache.remove(0);
        }

        // Add new entry
        cache.add(new Pair(key, value));
    }
}