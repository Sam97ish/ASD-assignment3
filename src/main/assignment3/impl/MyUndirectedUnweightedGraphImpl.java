package main.assignment3.impl;

import main.assignment1.MyList;
import main.assignment3.*;
import java.util.ArrayList;

public class MyUndirectedUnweightedGraphImpl<AnyType> implements UnweightedGraph<AnyType>{
    MyMap<AnyType,  Node<AnyType>> adjacencyList; //an adjacencyList implemented with myHashtable.
    ArrayList<Node<AnyType>> allVertex;
    int numNodes;


    static class Node<AnyType>{//each node of vertex has a list to outgoing edges
        AnyType vertex;
        ArrayList<Node<AnyType>> outgoing;
        boolean visited;

        Node(AnyType ver){
            vertex = ver;
            outgoing = new ArrayList<Node<AnyType>>();
            visited = false;
        }

        Node(AnyType ver, ArrayList<Node<AnyType>> list){
            vertex = ver;
            outgoing = list;
        }

        @Override
        public String toString() {
            return this.vertex + " " + this.outgoing.toString() + " \n ";
        }

    }

    public MyUndirectedUnweightedGraphImpl(){

        this.adjacencyList = new MyHashTableImpl<AnyType,  Node<AnyType>>(0.48);
        this.allVertex = new ArrayList<>();

    }

    @Override
    public void addVertex(AnyType vertex) {
	// TODO Auto-generated method stub
        Node<AnyType> vertNode = new Node<AnyType>(vertex); //create a new node for the vertex
	    adjacencyList.insert(vertex, vertNode); //add the node to the hashtable using the vertex value
        numNodes++;
        allVertex.add(vertNode);
    }

    @Override
    public void addEdge(AnyType sourceVertex, AnyType targetVertex) {
	// TODO Auto-generated method stub
	    Node<AnyType> sourceNode = adjacencyList.contains(sourceVertex);//get the source vertex from the hashtable.
        Node<AnyType> targetNode = adjacencyList.contains(targetVertex);//get the target vertex from the hashtable.

	    if( targetNode != null) { //if targetVertex is not in the graph, do nothing.

            if (sourceNode != null) {//if sourceNode is in the graph
                sourceNode.outgoing.add(targetNode); //add the target vertex to the sourcevertex outgoing list.
            }
        }
    }

    @Override
    public String toString() {
        return adjacencyList.toString();
    }


    public MyMap<AnyType, Node<AnyType>> getAdjacencyList(){
        return this.adjacencyList;
    }

    private int dfs(Node<AnyType> node){
        int count =0;
        MyQueue<Node<AnyType>> queue = new MyQueue<>();

        queue.push(node);

        while(!queue.isEmpty()){ //every edge of every vertex O(|E|).

            Node<AnyType> vertex = queue.pop();

            ArrayList<Node<AnyType>> list = vertex.outgoing;

            for (Node<AnyType> vert : list) {

                if (!vert.visited) {
                    count++;
                    queue.push(vert);

                }
            }

        }

        return count;
    }
    @Override
    public boolean isConnected() {
	// TODO Auto-generated method stub

        for (Node<AnyType> vertex : this.allVertex) {// O(|V|)
            vertex.visited = false;
        }

        Node<AnyType> n = allVertex.get(0);
        int count = dfs(n); //O(|E|)

	return 2*count == numNodes; //because the undirected graph has a double representation in adjacency list.
    }

    @Override
    public MyList<MyList<AnyType>> connectedComponents() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public boolean hasEulerPath() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public MyList<AnyType> eulerPath() {
	// TODO Auto-generated method stub
	return null;
    }

}
