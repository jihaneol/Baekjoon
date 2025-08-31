import java.util.*;

// 좌표 클래스
class Position {
    int x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// 간선 클래스 (영역 간 연결 비용)
class Edge implements Comparable<Edge> {
    int u, v, cost;
    Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

// Union-Find (Disjoint Set)
class UnionFind {
    int[] parent;
    UnionFind(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}

class Solution {
    public int n;
    public int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public int solution(int[][] land, int height) {
        n = land.length;
        int[][] group = new int[n][n];

        // 1. BFS로 영역 구분
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (group[i][j] != 0) continue;
                num++;
                bfs(i, j, group, num, land, height);
            }
        }

        // 2. 영역 간 연결 비용(간선) 수집
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int s = group[i][j];
                for (int[] d : dir) {
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if (!isRange(nx, ny)) continue;
                    int e = group[nx][ny];
                    if (s == e) continue;
                    int cost = Math.abs(land[i][j] - land[nx][ny]);
                    edges.add(new Edge(s, e, cost));
                }
            }
        }

        // 3. 크루스칼 알고리즘으로 MST 만들기
        Collections.sort(edges);
        UnionFind uf = new UnionFind(num);
        int answer = 0, cnt = 0;
        for (Edge e : edges) {
            if (uf.union(e.u, e.v)) {
                answer += e.cost;
                cnt++;
                if (cnt == num - 1) break; // MST 완성
            }
        }
        return answer;
    }

    // BFS로 같은 영역 묶기
    public void bfs(int x, int y, int[][] group, int num, int[][] land, int h) {
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(x, y));
        group[x][y] = num;

        while (!q.isEmpty()) {
            Position now = q.poll();
            for (int[] d : dir) {
                int nx = d[0] + now.x;
                int ny = d[1] + now.y;
                if (!isRange(nx, ny)) continue;
                if (group[nx][ny] != 0) continue;
                if (Math.abs(land[now.x][now.y] - land[nx][ny]) > h) continue;
                q.add(new Position(nx, ny));
                group[nx][ny] = num;
            }
        }
    }

    // 범위 체크
    public boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
