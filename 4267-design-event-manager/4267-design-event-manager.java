class EventManager {

    Map<Integer, Integer> map;
    PriorityQueue<int[]> pq;

    public EventManager(int[][] events) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (b[1] != a[1])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        for (int[] e : events) {
            map.put(e[0], e[1]);
            pq.offer(new int[] { e[0], e[1] });
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[] { eventId, newPriority });
    }

    public int pollHighest() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int id = top[0];
            int pri = top[1];
            if (!map.containsKey(id))
                continue;
            if (map.get(id) != pri)
                continue;

            map.remove(id);
            return id;
        }
        return -1;
    }
}