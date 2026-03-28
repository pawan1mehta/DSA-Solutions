class Solution {
    public int countPaths(int V, int[][] edges) {
        List<List<int[]>> adjList = constructAdjList(V, edges);
        
        int minTime = minTimeToReachDestination(V, adjList, 0, V - 1);
        
        int numOfWays = countWaysToReachDestinationWithLimitedTime(V, adjList, 0, V - 1, minTime);
        
        return numOfWays;
    }
    
    private int minTimeToReachDestination(int V, List<List<int[]>> adjList, int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[] a, int[] b) {
               return Integer.compare(a[1], b[1]); 
           } 
        });
        
        minHeap.add(new int[]{src, 0});
        dist[src] = 0;
        
        int u, v, time;
        while(!minHeap.isEmpty()) {
            int[] currNode = minHeap.poll();
            
            u = currNode[0];
            
            if(dist[u] < currNode[1]) {
                continue;
            }
            
            for(int[] adjNode : adjList.get(u)) {
                v = adjNode[0];
                time = adjNode[1];
                
                if(dist[v] > (dist[u] + time)) {
                    dist[v] = dist[u] + time;
                    minHeap.add(new int[]{v, dist[v]});
                }
            }
        }
        
        return dist[V - 1];
    }
    
    private int countWaysToReachDestinationWithLimitedTime(int V, List<List<int[]>> adjList, int src, int dest, int limitedTime) {
        boolean[] visited = new boolean[V];
        return dfs(src, dest, limitedTime, adjList, visited);    
    }
    
    private int dfs(int src, int dest, int limitedTime, List<List<int[]>> adjList, boolean[] visited) {
        if(limitedTime < 0) {
            return 0;
        }
        
        if(src == dest) {
            return 1;
        }
        
        visited[src] = true;
        
        int total = 0;
        
        for(int[] adjNode : adjList.get(src)) {
            if(!visited[adjNode[0]]) {
                total += dfs(adjNode[0], dest, limitedTime - adjNode[1], adjList, visited);
            }
        }
        
        visited[src] = false;
        
        return total;
    }
    
    private List<List<int[]>> constructAdjList(int V, int[][] edges) {
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        int u, v, time;
        for(int[] edge : edges) {
            u = edge[0]; v = edge[1]; time = edge[2];
            
            adjList.get(u).add(new int[]{v, time});
            adjList.get(v).add(new int[]{u, time});
        }
        
        return adjList;
    }
}
