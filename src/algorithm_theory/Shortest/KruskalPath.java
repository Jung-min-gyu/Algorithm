package algorithm_theory.Shortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class KruskalPath {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public String find(String node) {
        //path compression 기법
        if (parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }
    //초기화
    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public ArrayList<Edge_k> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge_k> edges) {
        ArrayList<Edge_k> mst = new ArrayList<>();
        Edge_k currentEdge;

        //1. 초기화
        for (int index = 0; index < vertices.size(); index++) {
            makeSet(vertices.get(index));
        }

        //2. 간선 weight 기반, sorting
        Collections.sort(edges);

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (find(currentEdge.nodeV) != find(currentEdge.nodeU)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        ArrayList<Edge_k> edges = new ArrayList<>();
        edges.add(new Edge_k(7, "A", "B"));
        edges.add(new Edge_k(5, "A", "D"));
        edges.add(new Edge_k(7, "B", "A"));
        edges.add(new Edge_k(8, "B", "C"));
        edges.add(new Edge_k(9, "B", "D"));
        edges.add(new Edge_k(7, "B", "E"));
        edges.add(new Edge_k(8, "C", "B"));
        edges.add(new Edge_k(5, "C", "E"));
        edges.add(new Edge_k(5, "D", "A"));
        edges.add(new Edge_k(9, "D", "B"));
        edges.add(new Edge_k(7, "D", "E"));
        edges.add(new Edge_k(6, "D", "F"));
        edges.add(new Edge_k(7, "E", "B"));
        edges.add(new Edge_k(5, "E", "C"));
        edges.add(new Edge_k(7, "E", "D"));
        edges.add(new Edge_k(8, "E", "F"));
        edges.add(new Edge_k(9, "E", "G"));
        edges.add(new Edge_k(6, "F", "D"));
        edges.add(new Edge_k(8, "F", "E"));
        edges.add(new Edge_k(11, "F", "G"));
        edges.add(new Edge_k(9, "G", "E"));
        edges.add(new Edge_k(11, "G", "F"));

        KruskalPath kObject = new KruskalPath();
        System.out.println(kObject.kruskalFunc(vertices, edges));
    }
}
