package edu.csula.cs460.graph.search;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra implements SearchStrategy {
    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {
//    	List<Node> visitedNodes;
//    	Queue<Node> queue = new LinkedList<>();
    	PriorityQueue<Map<Node, Integer>> pq = new PriorityQueue<>();
    	Map<Node, Integer> nodeValues = new HashMap<Node,Integer>();
    	
    	nodeValues.put(source, 0);
    	
    	
    	while(!pq.isEmpty()){
    		
    	}
    	
    	
        return null;
    }
}
