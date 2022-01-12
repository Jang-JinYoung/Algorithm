
import java.io.BufferedReader;
// https://www.acmicpc.net/problem/1260

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]); // 정점의 개수
        int M = Integer.parseInt(line[1]); // 간선의 개수
        int V = Integer.parseInt(line[2]); // 정점의 번호

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<M; i++) {
            String [] temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            if(graph.containsKey(n1)) {
                List<Integer> list = graph.get(n1);
                list.add(n2);
                graph.put(n1, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n2);
                graph.put(n1, list);
            }

            if(graph.containsKey(n2)) {
                List<Integer> list = graph.get(n2);
                list.add(n1);
                graph.put(n2, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(n1);
                graph.put(n2, list);
            }
        } // for

        for(int key : graph.keySet()) {
            Collections.sort(graph.get(key));
        }

        boolean [] visited = new boolean[N+1];
        dfs(graph, visited, V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(graph, visited, V);
    }

    private static void bfs(HashMap<Integer, List<Integer>> graph, boolean[] visited, int v) {
        LinkedList<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0) {
            v = queue.poll();
            System.out.print(v + " ");

            if(graph.containsKey(v)) {
                Iterator<Integer> it = graph.get(v).listIterator();

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

    private static void dfs(HashMap<Integer, List<Integer>> graph, boolean[] visited, int v) {

        visited[v] = true;
        System.out.print(v + " ");

        if(graph.containsKey(v)) {
            Iterator<Integer> it = graph.get(v).listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n])
                    dfs(graph, visited, n);
            }
        }
    }


}

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for(int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {adj[v].add(w);}
}
