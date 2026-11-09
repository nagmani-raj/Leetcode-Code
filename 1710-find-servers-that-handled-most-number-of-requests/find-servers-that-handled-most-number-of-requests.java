public class Solution {
    static class Server {
        final int id;
        final int busyTime;

        public Server(int id, int busyTime) {
            this.id = id;
            this.busyTime = busyTime;
        }
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<Server> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a.busyTime));
        int[] requestCount = new int[k];
        int n = arrival.length;
        for (int id = 0; id < k; id++) {
            available.add(id);
        }
        for (int i = 0; i < n; i++) {
            int defaultServer = (i % k);
            while (!busy.isEmpty() && busy.peek().busyTime <= arrival[i]) {
                Server top = busy.poll();
                available.add(top.id);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer nextServer = available.ceiling(defaultServer);
            nextServer = (nextServer != null) ? nextServer : available.ceiling(0);
            int requestEnd = arrival[i] + load[i];
            available.remove(nextServer);
            busy.add(new Server(nextServer, requestEnd));
            requestCount[nextServer]++;
        }
        int maxRequests = Integer.MIN_VALUE;
        List<Integer> busiestServers = new ArrayList<>();
        for (int id = 0; id < k; id++) {
            maxRequests = Math.max(maxRequests, requestCount[id]);
        }
        for (int id = 0; id < k; id++) {
            if (requestCount[id] == maxRequests) {
                busiestServers.add(id);
            }
        }
        return busiestServers;
    }
}
