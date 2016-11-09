import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class ProblemE {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int height = scan.nextInt();
        int width = scan.nextInt();
        int showroom [][] = new int[height][width];
        int graph [][] = new int[height*width][height*width];
        int dist[] = new int[height*width];
        Boolean spt[] = new Boolean[height*width];
        for (int i = 0; i < height*width; i++) {
            for (int j = 0; j < height*width; j++) {
                graph[i][j] = -1;
            }
        }
        for (int i = 0; i < height; i++) {
            String row = scan.next();
            for (int j = 0; j < width; j++) {

                switch (row.toCharArray()[j]){
                    case 'c':
                        showroom[i][j] = 1;
                        break;
                    case 'D':
                        showroom[i][j] = 0;
                        break;
                    default:
                        showroom[i][j] = -1;
                        break;
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (showroom[i/width][i%width] != '#') {
                try {
                    graph[i][i + 1] = showroom[i / width][i % width + 1];
                } catch (Exception e) {}
                try {
                    graph[i][i - 1] = showroom[i / width][i % width - 1];
                } catch (Exception e) {}
                try {
                    graph[i][i + width] = showroom[i / width + 1][i % width];
                } catch (Exception e) {}
                try {
                    graph[i][i - width] = showroom[i / width - 1][i % width];
                } catch (Exception e) {}
            }
        }
        for (int i = 0; i < height*width; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }
        dist[((scan.nextInt()-1)*width) + scan.nextInt()-1] = 1;
        for (int count = 0; count < height*width-1; count++) {
            int u = minDistance(dist, spt, height*width);
            spt[u] = true;
            for (int v = 0; v < height*width; v++) {
                if (!spt[v]
                        && graph[u][v] != -1
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        ArrayList<Integer> doors = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            if (showroom[0][i] == 0){ //TOP
                doors.add(dist[i]);
            }

            if (showroom[0][height-1] == 0) { //BOTTOM
                doors.add(dist[(height-1)*(width-1) + i]);
            }
        }
        for (int i = 0; i < height; i++) {
            if (showroom[i][0] == 0){ //LEFT
                doors.add(dist[i*width]);
            }
            if (showroom[i][width-1] == 0){ //RIGHT
                doors.add(dist[i*width + width-1]);
            }
        }
        int lowest = 0;
        for (int i : doors) {
            lowest = (lowest > i) ? i : lowest;
        }
        System.out.println(lowest);
    }
    public static int minDistance(int dist[], Boolean sptSet[], int V)
    {
        int min = Integer.MAX_VALUE;
        int min_index=-1;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
}