class Twitter {

    private static class Tweet {
        int tweetId;
        int time;
        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> follows;       // userId -> set of followeeIds
    private Map<Integer, List<Tweet>> userTweets;      // userId -> their tweets (in order posted)
    private int timer;

    public Twitter() {
        follows = new HashMap<>();
        userTweets = new HashMap<>();
        timer = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timer++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-heap by time — newest tweet always on top
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // each element: [time, listIndex_pointer, userId]

        // Step 1: gather the set of people whose tweets we care about (self + followees)
        Set<Integer> people = new HashSet<>();
        people.add(userId);
        if (follows.containsKey(userId)) {
            people.addAll(follows.get(userId));
        }

        // Step 2: for each person, push their MOST RECENT tweet's index onto the heap
        for (int person : people) {
            List<Tweet> tweets = userTweets.get(person);
            if (tweets != null && !tweets.isEmpty()) {
                int lastIndex = tweets.size() - 1;
                maxHeap.offer(new int[]{tweets.get(lastIndex).time, lastIndex, person});
            }
        }

        // Step 3: pull the top (newest) tweet, then push that person's NEXT most recent tweet
        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] top = maxHeap.poll();
            int time = top[0], index = top[1], person = top[2];

            result.add(userTweets.get(person).get(index).tweetId);

            if (index - 1 >= 0) {
                Tweet prevTweet = userTweets.get(person).get(index - 1);
                maxHeap.offer(new int[]{prevTweet.time, index - 1, person});
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}