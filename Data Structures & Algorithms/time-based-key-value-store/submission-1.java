class TimeMap {

    private Map<String, Map<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new HashMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        int seen = -1;

        for (int t : map.get(key).keySet()) {
            if (t <= timestamp && t > seen) {
                seen = t;
            }
        }

        return seen == -1 ? "" : map.get(key).get(seen);
    }
}
