package algorithm_theory.Shortest;

public class Edge_k implements Comparable<Edge_k>{
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge_k(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeU = nodeU;
        this.nodeV = nodeV;
    }

    public String toString() {
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU + ")";
    }

    @Override
    public int compareTo(Edge_k o) {
        return this.weight - o.weight;
    }
}
