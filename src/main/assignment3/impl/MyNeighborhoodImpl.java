package main.assignment3.impl;

import main.assignment1.MyList;
import main.assignment3.MyMap;
import main.assignment3.Neighborhood;

import java.util.ArrayList;

public class MyNeighborhoodImpl<AnyType> implements Neighborhood<AnyType> {
    private MyMap<AnyType, Node<AnyType>> adjacencyList; //an adjacencyList implemented with myHashtable.
    private ArrayList<Node<AnyType>> allVertex;
    private int numNodes;
    private int edges;


    static class Node<AnyType>{//each node of vertex has a list to outgoing edges
        AnyType vertex;
        ArrayList<NodeEdge<AnyType>> outgoing;
        int chatterTime;
        int candyAmount;
        boolean visited;

        Node(AnyType ver, int candy, int chatter){
            vertex = ver;
            outgoing = new ArrayList<NodeEdge<AnyType>>();
            visited = false;
            candyAmount = candy;
            chatterTime = chatter;
        }

        Node(AnyType ver, ArrayList<NodeEdge<AnyType>> list){
            vertex = ver;
            outgoing = list;
        }

        public AnyType getVertex() {
            return vertex;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (NodeEdge<AnyType> s : this.outgoing)
            {
                sb.append(s.target.vertex.toString());
                sb.append(" ");
            }
            return sb.toString();
        }

    }

    static class NodeEdge<AnyType>{
        Node<AnyType> target;
        int distance;

        NodeEdge(Node<AnyType> tar, int dist){
            target = tar;
            distance = dist;
        }

        public Node<AnyType> getTarget() {
            return target;
        }

        public int getDistance() {
            return distance;
        }
    }

    public MyNeighborhoodImpl(){

        this.adjacencyList = new MyHashTableImpl<AnyType, Node<AnyType>>(0.48);
        this.allVertex = new ArrayList<>();
        edges = 0;

    }

    @Override
    public void addVertex(AnyType neighbor, int chatterTime, int candyAmount) {
	// TODO Auto-generated method stub
	    Node<AnyType> vertNode = new Node<AnyType>(neighbor, candyAmount, chatterTime); //create a new node for the vertex
        adjacencyList.insert(neighbor, vertNode); //add the node to the hashtable using the vertex value
        numNodes++;
        allVertex.add(vertNode);
    }

    @Override
    public void addEdge(AnyType fromNeighbor, AnyType toNeighbor, int distance) {
	// TODO Auto-generated method stub
        Node<AnyType> sourceNeighbor = adjacencyList.contains(fromNeighbor);//get the source vertex from the hashtable.
        Node<AnyType> targetNeighbor = adjacencyList.contains(toNeighbor);//get the target vertex from the hashtable.

        if( targetNeighbor != null) { //if targetVertex is not in the graph, do nothing.

            if (sourceNeighbor != null) {//if sourceNode is in the graph
                NodeEdge<AnyType> forSource = new NodeEdge(targetNeighbor, distance);
                NodeEdge<AnyType> forTarget = new NodeEdge(sourceNeighbor, distance);
                sourceNeighbor.outgoing.add(forSource); //add the target vertex to the sourcevertex outgoing list.
                targetNeighbor.outgoing.add(forTarget); //because undirected ==> double representation.
                edges++;
            }
        }
	
    }

    @Override
    public int approximateMinimumDistance() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public MyList<AnyType> neighborsToVisit(int maximum_Time) {
	// TODO Auto-generated method stub
	return null;
    }

  

   
}
