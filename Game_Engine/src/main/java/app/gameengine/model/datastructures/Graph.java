package app.gameengine.model.datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph<N>{
    private HashMap<N, ArrayList<N>> adjacencyMap;
    public Graph(){
        this.adjacencyMap=new HashMap<>();
    }
    public void addNode(N node){
        if(!this.adjacencyMap.containsKey(node)){
            this.adjacencyMap.put(node,new ArrayList<>());
        }
    }
    public void addEdge(N from, N to){
        this.addNode(from);
        this.addNode(to);
        this.adjacencyMap.get(from).add(to);
    }
    public void addBidirectionalEdge(N node1, N node2){
        this.addNode(node1);
        this.addNode(node2);
        this.adjacencyMap.get(node1).add(node2);
        this.adjacencyMap.get(node2).add(node1);
    }
}
