package laiOfferTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CopyAGraph {
	  public List<GraphNode> copy(List<GraphNode> graph) {
		    // Write your solution here.
		    // Method 1: try BFS
	/*	    if (graph == null) {
		      return null;
		    }*/
		    
		    /*
		    Map<GraphNode, GraphNode> map = new HashMap<>();
		    map.put(graph, new GraphNode(graph.key));
		    GraphNode newGraph = map.get(graph);
		    
		    GraphNode tempGraph = graph;
		    //GraphNode tempNew = newGraph;
		    // begin BFS
		    Queue<GraphNode> queue = new LinkedList<>();
		    queue.offer(tempGraph);
		    while (!queue.isEmpty()) {
		      int size = queue.size();
		      for (int i = 0; i < size; i++) {
		        GraphNode temp = queue.poll();
		        for (int i = 0; i < temp.neighbors.size(); i++) {
		          if (!map.containsKey(temp.neighbors.get(i))) {
		            queue.offer(temp.neighbors.get(i));
		            map.put(temp.neighbors.get(i), new GraphNode(temp.neighbors.get(i).key));
		          }
		          map.get(temp).neighbors.add(map.get(temp.neighbors.get(i)));
		        }
		      }
		    }
		    return newGraph;
		    */
		    
		    // the input is a list of nodes
		    if (graph == null) {
			      return null;
			}
		    List<GraphNode> newGraph = new ArrayList<>();
		    Map<GraphNode, GraphNode> map = new HashMap<>();
		    
		    for (int i = 0; i < graph.size(); i++) {
		    	if (map.isEmpty() || !map.containsKey(graph.get(i))) {
		    		map.put(graph.get(i), new GraphNode(graph.get(i).key));
		    		newGraph.add(map.get(graph.get(i)));
		    	}
		    	for (int j = 0; j < graph.get(i).neighbors.size(); j++) {
		    		if (!map.containsKey(graph.get(i).neighbors.get(j))) {
		    			map.put(graph.get(i).neighbors.get(j), new GraphNode(graph.get(i).neighbors.get(j).key));
		    			newGraph.add(map.get(graph.get(i).neighbors.get(j)));
		    		}
		    		map.get(graph.get(i)).neighbors.add(map.get(graph.get(i).neighbors.get(j)));
		    	}
		    }
		    return newGraph;
		  }

	  
	 
	   class GraphNode {
	     public int key;
	     public List<GraphNode> neighbors;
	     public GraphNode(int key) {
	       this.key = key;
	       this.neighbors = new ArrayList<GraphNode>();
	     }
	   }
	  
}
