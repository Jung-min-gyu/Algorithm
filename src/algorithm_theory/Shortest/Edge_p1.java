package algorithm_theory.Shortest;

public class Edge_p1 implements Comparable<Edge_p1>{
    public String node;
    public int weight;

    public Edge_p1(String node, int weight) {
        this.weight = weight;
        this.node = node;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node + ")";
    }

    @Override
    public int compareTo(Edge_p1 edge_p1) {
        return this.weight - edge_p1.weight;
    }
}
