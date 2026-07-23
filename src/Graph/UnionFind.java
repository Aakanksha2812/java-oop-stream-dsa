package Graph;

class UnionFind {

    int[] parent;

    UnionFind(int n) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent2 != parent1) {
            parent[parent2] = parent1;
        }

    }

    boolean areConnected(int node1, int node2) {
        if (parent[node1] == parent[node2]) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.union(0, 1);
        uf.union(1, 2);
        System.out.println("parent of node " + uf.find(0));
        System.out.println("parent of node " + uf.find(1));
        System.out.println("parent of node " + uf.find(2));
        System.out.println("is node 0 and 1 connected " + uf.areConnected(0, 1));
        System.out.println("is node 1 and 2 connected " + uf.areConnected(1, 2));
        System.out.println("is node 2 and 3 connected " + uf.areConnected(2, 3));
    }
}
