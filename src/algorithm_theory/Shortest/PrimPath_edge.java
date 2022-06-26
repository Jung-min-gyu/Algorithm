package algorithm_theory.Shortest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PrimPath_edge {
    public ArrayList<Edge_p> primFunc(String startNode, ArrayList<Edge_p> edges) {
        Edge_p currentEdge, poppedEdge, adjacentEdgeNode;
        ArrayList<Edge_p> currentEdgeList, candidateEdgeList, adjacentEdgeNodes;
        PriorityQueue<Edge_p> priorityQueue;

        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge_p> mst = new ArrayList<>();
        HashMap<String, ArrayList<Edge_p>> adjacentEdges = new HashMap<>();

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            if (!adjacentEdges.containsKey(currentEdge.node1)) {
                adjacentEdges.put(currentEdge.node1, new ArrayList<Edge_p>());
            }
            if (!adjacentEdges.containsKey(currentEdge.node2)) {
                adjacentEdges.put(currentEdge.node2, new ArrayList<Edge_p>());
            }
        }

        for (int index = 0; index < edges.size(); index++) {
            currentEdge = edges.get(index);
            currentEdgeList = adjacentEdges.get(currentEdge.node1);
            currentEdgeList.add(new Edge_p(currentEdge.weight, currentEdge.node1, currentEdge.node2));
            currentEdgeList = adjacentEdges.get(currentEdge.node2);
            currentEdgeList.add(new Edge_p(currentEdge.weight, currentEdge.node2, currentEdge.node1));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge_p>());
        priorityQueue = new PriorityQueue<Edge_p>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.node2)) {
                //해당 edge를 mst에 추가
                connectedNodes.add(poppedEdge.node2);
                mst.add(new Edge_p(poppedEdge.weight, poppedEdge.node1, poppedEdge.node2));

                adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.node2, new ArrayList<Edge_p>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if (!connectedNodes.contains(adjacentEdgeNode.node2)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;
    }


    public static void main(String[] args) {
        ArrayList<Edge_p> myedges = new ArrayList<>();
        myedges.add(new Edge_p(7, "A", "B"));
        myedges.add(new Edge_p(5, "A", "D"));
        myedges.add(new Edge_p(8, "B", "C"));
        myedges.add(new Edge_p(9, "B", "D"));
        myedges.add(new Edge_p(7, "D", "E"));
        myedges.add(new Edge_p(5, "C", "E"));
        myedges.add(new Edge_p(7, "B", "E"));
        myedges.add(new Edge_p(6, "D", "F"));
        myedges.add(new Edge_p(8, "E", "F"));
        myedges.add(new Edge_p(9, "E", "G"));
        myedges.add(new Edge_p(11, "F", "G"));

        PrimPath_edge pObject = new PrimPath_edge();
        System.out.println(pObject.primFunc("A", myedges));
    }
}
