package NWERC_16;

import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ShortestPath {

    int V;
    int distance[];

    ShortestPath(int V) {
        this.V = V;
    }

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE;
        int min_index=-1;

        for (int v = 0; v < V; v++)

            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        for (int count = 0; count < V-1; count++) {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        this.distance = dist;
    }
}

public class IronAndCoal {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int numberOfSquares = scan.nextInt();
        int[] iron = new int[scan.nextInt()];
        int[] coal = new int[scan.nextInt()];

        for (int i = 0; i < iron.length; i++) {
            iron[i] = scan.nextInt() - 1;
        }
        for (int i = 0; i < coal.length; i++) {
            coal[i] = scan.nextInt() - 1;
        }

        int[][] graph = new int[numberOfSquares][numberOfSquares];

        for (int i = 0; i < numberOfSquares; i++) {
            int numberOfLinks = scan.nextInt();
            for (int j = 0; j < numberOfLinks; j++) {
                graph[i][scan.nextInt() - 1] = 1;
            }
        }

        ShortestPath djk = new ShortestPath(numberOfSquares);
        djk.dijkstra(graph, 0);

        ArrayList<Integer> srcIron = new ArrayList<>();
        ArrayList<Integer> srcIronCoal = new ArrayList<>();

        ArrayList<Integer> srcCoal = new ArrayList<>();
        ArrayList<Integer> srcCoalIron = new ArrayList<>();


        for (int i = 0; i < iron.length; i++) {
            srcIron.add(djk.distance[iron[i]]);
        }

        for (int i = 0; i < iron.length; i++) {
            djk.dijkstra(graph, iron[i]);
            for (int j = 0; j < coal.length; j++) {
                srcIronCoal.add(djk.distance[coal[j]] + srcIron.get(i));
            }
        }

        djk.dijkstra(graph, 0);

        for (int i = 0; i < coal.length; i++) {
            srcCoal.add(djk.distance[coal[i]]);
        }

        for (int i = 0; i < coal.length; i++) {
            djk.dijkstra(graph, coal[i]);
            for (int j = 0; j < iron.length; j++) {
                srcCoalIron.add(djk.distance[iron[j]] + srcCoal.get(i));
            }
        }

        Collections.sort(srcCoalIron);
        Collections.sort(srcIronCoal);
        Collections.sort(srcIron);
        Collections.sort(srcCoal);

        if (srcCoalIron.get(0) < srcIronCoal.get(0) || srcCoalIron.get(0) < srcCoal.get(0) + srcIron.get(0)) {

            if(srcCoalIron.get(0) == Integer.MAX_VALUE || srcCoalIron.get(0) == -Integer.MAX_VALUE || srcCoalIron.get(0) == Integer.MIN_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(srcCoalIron.get(0));
            }

        } else if (srcIronCoal.get(0) < srcCoal.get(0) + srcIron.get(0)) {

            if(srcIronCoal.get(0) == Integer.MAX_VALUE || srcIronCoal.get(0) == -Integer.MAX_VALUE || srcIronCoal.get(0) == Integer.MIN_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(srcIronCoal.get(0));
            }
        } else {
            if(srcCoal.get(0) + srcIron.get(0) == Integer.MAX_VALUE || srcCoal.get(0) + srcIron.get(0) == -Integer.MAX_VALUE || srcCoal.get(0) + srcIron.get(0) == Integer.MIN_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(srcCoal.get(0) + srcIron.get(0));
            }
        }

        //Check src -> any ore -> any coal. Sort
        //Check src -> any coal -> any ore. Sort
        //Check src -> any coal + src -> any ore. Sort

        //Pick lowest of the above.


    }



}
