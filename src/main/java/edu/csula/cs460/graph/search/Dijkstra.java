package edu.csula.cs460.graph.search;

import edu.csula.cs460.graph.Edge;
import edu.csula.cs460.graph.Graph;
import edu.csula.cs460.graph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra implements SearchStrategy {
    @Override
    public List<Edge> search(Graph graph, Node source, Node dist) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	Map<Node, Node> predecessor = new HashMap<>();
    	Node currentNode;
    	int tempDistance;
    	
    	source.setDistance(0);
    	pq.add(source);
    	
    	while(!pq.isEmpty()){
    		
    		currentNode = pq.remove();
    		
    		for(Node neighborNodes: graph.neighbors(currentNode)){
				
    			tempDistance = currentNode.getDistance() + graph.distance(currentNode, neighborNodes);
    			
    			if(tempDistance < neighborNodes.getDistance()){
    				
    				predecessor.put(neighborNodes, currentNode);
    				neighborNodes.setDistance(tempDistance);
    				
    				if(!pq.contains(neighborNodes)){
    					pq.add(neighborNodes);
    				}			
    			}
    		}
    		pq = updatePriority(pq);
    	}
    	
    	List<Edge> edgePath = new ArrayList<>();
    	
    	Node to;
    	Node from = dist;

    	//Traces path from source to dist
    	do{
    		to = from;
    		from = predecessor.get(from);
    		edgePath.add(new Edge(from, to, graph.distance(from, to)));
    		
    	}while(!from.equals(source));
    	
    	Collections.reverse(edgePath);

        return edgePath;
    }
    
    //Reprioritizes queue
    public PriorityQueue<Node> updatePriority(PriorityQueue<Node> pq){
    	
    	PriorityQueue<Node> newPriority = new PriorityQueue<>();
    	
    	while(!pq.isEmpty()){
    		newPriority.add(pq.remove());
    	}
    	return newPriority;
    }
}
