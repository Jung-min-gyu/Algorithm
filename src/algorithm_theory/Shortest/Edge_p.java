package algorithm_theory.Shortest;

public class Edge_p implements Comparable<Edge_p>{
    public int weight;
    public String node1;
    public String node2;

    public Edge_p(int weight, String node1, String node2) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.node2 + ", " + this.node1 + ")";
    }

    @Override
    public int compareTo(Edge_p edge_p) {
        return this.weight - edge_p.weight;
    }
}
