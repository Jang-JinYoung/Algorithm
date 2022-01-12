// https://www.acmicpc.net/problem/2606

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> virus = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Graph graph = new Graph(N+1);
        for(int i=0; i<M; i++) {
            String [] line = br.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);

            graph.addEdge(n1, n2);
            graph.addEdge(n2, n1);
        }

        boolean [] visited = new boolean[N+1];
        bfs(graph, visited, 1);
        System.out.println(virus.size()-1);

    }

    private static void bfs(Graph graph, boolean[] visited, int s) {


        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            s = queue.poll();
            virus.add(s);

            Iterator<Integer> it = graph.adj[s].listIterator();
            while(it.hasNext()) {
                int n = it.next();

                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }

}

class Graph {
    int V;
    LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {adj[v].add(w);}

    @Override
    public String toString() {
        return "Graph{" +
                "V=" + V +
                ", adj=" + Arrays.toString(adj) +
                '}';
    }
}
