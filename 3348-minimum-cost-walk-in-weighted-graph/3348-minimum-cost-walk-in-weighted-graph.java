class Solution {

    public int[] minimumCost(int n, int[][] edges, int[][] queries) {
        
        List<List<int[]>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>(2));
        }
        for (int[] edge : edges) {
            list.get(edge[0]).add(new int[] { edge[1], edge[2] });
            list.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }

        boolean[] visited = new boolean[n];

        
        int[] comp = new int[n];
        List<Integer> compC = new ArrayList<>(n);

        int compId = 0;

    
        for (int node = 0; node < n; node++) {
            
            if (!visited[node]) {
                
                compC.add(
                    getComponentCost(
                        node,
                        list,
                        visited,
                        comp,
                        compId
                    )
                );
                
                compId++;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (comp[start] == comp[end]) {
                
                ans[i] = compC.get(comp[start]);
            } else {
               
                ans[i] = -1;
            }
        }

        return ans;
    }

   
    private int getComponentCost(
        int source,
        List<List<int[]>> list,
        boolean[] visited,
        int[] comp,
        int compId
    ) {
        Queue<Integer> nodesQueue = new LinkedList<>();

        
        int compC = Integer.MAX_VALUE;

        nodesQueue.offer(source);
        visited[source] = true;

        
        while (!nodesQueue.isEmpty()) {
            int node = nodesQueue.poll();

            
            comp[node] = compId;

           
            for (int[] neighbor : list.get(node)) {
                int weight = neighbor[1];
                
                compC &= weight;

               
                if (visited[neighbor[0]]) continue;
                visited[neighbor[0]] = true;
                nodesQueue.offer(neighbor[0]);
            }
        }

        return compC;
    }
}