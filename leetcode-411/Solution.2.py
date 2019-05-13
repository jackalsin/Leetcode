def minvert(graph):
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(n1, n2):
        p1, p2 = find(n1), find(n2)
        if p1 != p2:
            parent[p1] = p2
    N = len(graph)
    parent = {}
    for node in range(N):
        parent[node] = node

    indegree = [0]*N
    for i in range(N):
        for j in range(N):
            if graph[i][j]:
                indegree[j] += 1

    # only contains indegree == 0
    nodelist = [x for x in range(N) if indegree[x] == 0]
    visit = set()

    def dfs(i):
        if i in visit:
            return
        visit.add(i)
        for j in range(N):
            if graph[i][j]:
                dfs(j)
    res = 0
    resultList = []
    for n in nodelist:
        res += 1
        resultList.append(n)
        dfs(n)
    left = [x for x in range(N) if x not in visit]
    print("parent ", parent)
    for node in left:
        for nei in left:
            if graph[node][nei] and node != nei:
                union(node, nei)
    loop = set()
    print("left ", left)

    for node in left:
        p = find(node)
        loop.add(p)
#     for i in range(N):
#         if i not in visit:
#             dfs(i)
#             res += 1
    print("parent ", parent)
    print(loop)
    print(resultList)
    return res+len(loop)


graph = [[0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
         [0, 0, 0, 1, 0, 1, 0, 1, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
         [0, 0, 0, 0, 0, 0, 0, 0, 1, 0],
         [0, 0, 0, 0, 0, 0, 1, 0, 0, 0],
         [0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
         [0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
         [0, 0, 0, 1, 0, 0, 1, 0, 0, 0]]

# {1, 0, 0, 0},
# {0, 0, 1, 0},
# {1, 0, 0, 1},
# {0, 1, 0, 0}
#    1->2->3->1, 2->0->0
# graph = [[1, 0, 0, 0], [0, 0, 1, 0], [1, 0, 0, 1], [0, 1, 0, 0]]
# graph = [[0, 1, 0, 0], [1, 0, 0, 0], [0, 1, 0, 1], [0, 0, 1, 0]]
graph= [[0, 1, 0, 0],[1,0,0,0],[0,1,0,0],[0,1,1,0]]

print(minvert(graph))
