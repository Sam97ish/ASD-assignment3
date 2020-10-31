package main.assignment3.impl;

import main.assignment1.MyList;
import main.assignment3.MyMap;
import main.assignment3.Neighborhood;
import main.assignment3.impl.BinaryHeap2;

import java.util.ArrayList;
import java.util.Objects;

public class MyNeighborhoodImpl<AnyType> implements Neighborhood<AnyType> {
    private MyMap<AnyType, Node<AnyType>> adjacencyList; //an adjacencyList implemented with myHashtable.
    private ArrayList<Node<AnyType>> allVertex;
    private int numNodes;
    private int edges;


    static class Node<AnyType> implements Comparable<Node<AnyType>> {//each node of vertex has a list to outgoing edges
        AnyType vertex;
        ArrayList<NodeEdge<AnyType>> outgoing;
        int chatterTime;
        int candyAmount;
        int key;
        boolean visited;

        Node(AnyType ver, int candy, int chatter){
            vertex = ver;
            outgoing = new ArrayList<NodeEdge<AnyType>>();
            visited = false;
            candyAmount = candy;
            chatterTime = chatter;
            key = 0;
        }

        Node(AnyType ver, ArrayList<NodeEdge<AnyType>> list){
            vertex = ver;
            outgoing = list;
        }

        public AnyType getVertex() {
            return vertex;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (NodeEdge<AnyType> s : this.outgoing)
            {
                sb.append(s.target.vertex.toString());
                sb.append(" ");
                sb.append("distance");
                sb.append(" ");
                sb.append(s.distance);
                sb.append(" ");
            }
            return sb.toString();
        }

        @Override
        public int compareTo(Node<AnyType> o) {
            return this.key - o.key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return chatterTime == node.chatterTime &&
                    candyAmount == node.candyAmount &&
                    getKey() == node.getKey() &&
                    getVertex().equals(node.getVertex());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getVertex(), outgoing, chatterTime, candyAmount, getKey(), visited);
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

    private ArrayList<Node<AnyType>> primsalgo(){
        BinaryHeap2<Node<AnyType>> binaryheap = new BinaryHeap2<Node<AnyType>>();
        Node<AnyType> start = allVertex.get(0);
        binaryheap.insert(start);

        for(int i = 1; i<allVertex.size();i++){
            Node<AnyType> n = allVertex.get(i);
            n.setKey(Integer.MAX_VALUE);
            n.visited = false;
            binaryheap.insert(n);
        }

        ArrayList<Node<AnyType>> MST = new ArrayList<>();

        while (!binaryheap.isEmpty()){
            Node<AnyType> minNode = binaryheap.deleteMin();
            minNode.visited = true;
            MST.add(minNode);

            ArrayList<NodeEdge<AnyType>> outgoing = minNode.outgoing;

            for (NodeEdge<AnyType> edge : outgoing) {
                if (!edge.target.visited) { //if node not yet in MST
                    if (edge.target.getKey() > edge.getDistance()) {
                        edge.target.setKey(edge.getDistance());
                        binaryheap.decresekey(edge.target);
                    }
                }
            }
        }

        return MST;

    }

    @Override
    public int approximateMinimumDistance() {
	// TODO Auto-generated method stub
        ArrayList<Node<AnyType>> MST = primsalgo();
        int sum = 0;
        for(Node<AnyType> vert : MST){
            sum += vert.getKey();
        }

        sum *=2;

	    return sum-2;
    }

    @Override
    public MyList<AnyType> neighborsToVisit(int maximum_Time) {
	// TODO Auto-generated method stub
	return null;
    }

  

   
}
