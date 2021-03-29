package com.sbardyuk.algofun.again;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class GraphStuff {

    private static class G {

        int n;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDeg = new HashMap<>();

        G(int n) {
            this.n = n;
            for (int i = 0; i < n; i++) {
                adj.put(i, new ArrayList<>());
                inDeg.put(i, 0);
            }
        }

        G(int n, boolean isUndirected, int [][] adj) {
            this(n);

            for (int [] edge : adj) {
                this.adj.get(edge[0]).add(edge[1]);
                this.inDeg.put(edge[1], this.inDeg.get(edge[1]) + 1);

                if (isUndirected) {
                    this.adj.get(edge[1]).add(edge[0]);
                    this.inDeg.put(edge[0], this.inDeg.get(edge[0]) + 1);
                }
            }
        }

        private void print() {
            for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
                System.out.println(entry.getKey() + " -> " + Arrays.toString(entry.getValue().toArray()));
            }
        }

        private void dfs() {
            boolean [] visited = new boolean[n];
            Stack<Integer> stack = new Stack<>();

            stack.push(0);
            visited[0] = true;

            System.out.println();
            System.out.println("DFS starting from 0:");

            while (!stack.isEmpty()) {

                int node = stack.pop();

                System.out.print( " " + node + " ->");

                for (int v : adj.get(node)) {
                    if (!visited[v]) {
                        stack.push(v);
                        visited[v] = true;
                    }
                }
            }
        }

        private void bfs() {
            boolean [] visited = new boolean [n];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(0);
            visited[0] = true;

            System.out.println();
            System.out.println("BFS starting from 0:");

            while(!queue.isEmpty()) {

                int node = queue.poll();

                System.out.print( " " + node + " ->");

                for (int v : adj.get(node)) {
                    if (!visited[v]) {
                        queue.offer(v);
                        visited[v] = true;
                    }
                }
            }
        }

        private void topoSort() {
            List<Integer> sorted = new ArrayList<>();
            Queue<Integer> sources = new LinkedList<>();

            for (Map.Entry<Integer, Integer> entry : inDeg.entrySet()) {
                if (entry.getValue() == 0) {
                    sources.add(entry.getKey());
                }
            }

            while (!sources.isEmpty()) {
                int source = sources.poll();

                sorted.add(source);

                for (int child : adj.get(source)) {
                    int newInDeg = inDeg.get(child) - 1;
                    newInDeg = newInDeg <= 0 ? 0 : newInDeg;
                    inDeg.put(child, newInDeg);

                    if (newInDeg == 0) {
                        sources.add(child);
                    }
                }
            }

            if (sorted.size() != n) {
                System.out.println("there loops in the graph");
            } else {
                System.out.println();
                System.out.println();
                System.out.println("Topologycal sort:");
                System.out.println(Arrays.toString(sorted.toArray()));
            }


        }

    }



    public static void main(String[] args) {
        //       1 - 2
        //   0 /      |
        //     \ 4 -  3  - 5

        G g = new G(6, true, new int[][] { {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}, {3, 5} });

        g.print();
        g.dfs();
        g.bfs();

        System.out.println();
        System.out.println();

        //       1 -> 2
        //   0 /      \/
        //     \ 4 ->  3  -> 5

        G gDirected = new G(6, false, new int[][] { {0, 1}, {1, 2}, {2, 3}, {3, 5}, {0, 4}, {4, 3} });

        gDirected.print();
        gDirected.dfs();
        gDirected.bfs();
        gDirected.topoSort();
    }

}
