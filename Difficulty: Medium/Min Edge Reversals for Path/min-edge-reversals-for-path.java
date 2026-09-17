class Solution {
    public int minimumEdgeReversal(int[][] edges, int n, int src, int dst) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            adjList.get(u).add(new int[]{v, 0});
            adjList.get(v).add(new int[]{u, 1});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        
        dist[src] = 0;
        minHeap.add(new int[]{0, src});
        
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            
            int dt = curr[0];
            int u = curr[1];
            
            if(dist[u] < dt) {
                continue;
            }
            
            for(int[] adjNode : adjList.get(u)) {
                int v = adjNode[0];
                int ndt = adjNode[1];
                
                if(dist[v] > (dist[u] + ndt)) {
                    dist[v] = dist[u] + ndt;
                    minHeap.add(new int[]{dist[v], v});
                }
            } 
        }
        
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}