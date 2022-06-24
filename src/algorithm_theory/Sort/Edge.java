package algorithm_theory.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class Edge implements Comparable<Edge>{
    public Integer distance;
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }


    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance;  //comparable 사용 정렬
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge(12, "A");
        Edge edge2 = new Edge(10, "A");
        Edge edge3 = new Edge(13, "A");

        Edge[] edges = {edge1, edge2, edge3};
//        Arrays.sort(edges);
//        for (int index = 0; index < edges.length; index++) {
//            System.out.println(edges[index].distance);
//        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge objectItem1, Edge objectItem2) {
                return objectItem1.distance - objectItem2.distance;  //comparator 사용 정렬
            }
        });
        for (int index = 0; index < edges.length; index++) {
            System.out.println(edges[index].distance);
        }
    }
}
