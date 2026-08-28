class Solution:
    def validPath(
        self, n: int, edges: List[List[int]], source: int, destination: int
    ) -> bool:
        if source == destination:
            return True
        elif n == 0 or n == 1:
            if source == destination:
                return True
            return False

        map = {}
        vis = [0] * n

        for edge in edges:
            u, v = edge[0], edge[1]
            if u not in map.keys():
                map[u] = [v]
            else:
                map[u].append(v)
            if v not in map.keys():
                map[v] = [u]
            else:
                map[v].append(u)

        queue = []
        queue.append(source)
        vis[source] = 1

        while len(queue) != 0:
            p = queue.pop(0)

            for i in range(len(map[p])):
                if vis[map[p][i]] == 0:
                    queue.append(map[p][i])
                    vis[map[p][i]] = 1
                if vis[destination] == 1:
                    return True

        return vis[destination] == 1
