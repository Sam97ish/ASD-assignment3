package main.assignment3.impl;

import main.assignment1.MyList;
import main.assignment3.*;
import java.util.ArrayList;

public class MyUndirectedUnweightedGraphImpl<AnyType> implements UnweightedGraph<AnyType>{
    private MyMap<AnyType,  Node<AnyType>> adjacencyList; //an adjacencyList implemented with myHashtable.
    private ArrayList<Node<AnyType>> allVertex;
    private int numNodes;


    static class Node<AnyType>{//each node of vertex has a list to outgoing edges
        AnyType vertex;
        ArrayList<Node<AnyType>> outgoing;
        ArrayList<Node<AnyType>> weights;
        boolean visited;

        Node(AnyType ver){
            vertex = ver;
            outgoing = new ArrayList<Node<AnyType>>();
            weights = new ArrayList<Node<AnyType>>();
            visited = false;
        }

        Node(AnyType ver, ArrayList<Node<AnyType>> list){
            vertex = ver;
            outgoing = list;
        }

        public AnyType getVertex() {
            return vertex;
        }

        @Override
        public String toString() {
            return this.vertex + " " + this.outgoing.toString();
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
                targetNode.outgoing.add(sourceNode); //because undirected ==> double representation.
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

/*
    private int dfs(Node<AnyType> node){

        for (Node<AnyType> vertex : this.allVertex) {// O(|V|)
            vertex.visited = false;
        }

        int count =0;
        MyQueue<Node<AnyType>> queue = new MyQueue<>();

        queue.push(node);

        while(!queue.isEmpty()){ //every edge of every vertex O(|E|).

            Node<AnyType> vertex = queue.pop();
            vertex.visited = true;
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

 */

    private void dfs(Node<AnyType> node){

        node.visited = true;
        ArrayList<Node<AnyType>> ls = node.outgoing;
        for (Node<AnyType> w : ls) {
            if (!w.visited) {
                dfs(w);
            }
        }
    }

    @Override
    public boolean isConnected() {
	// TODO Auto-generated method stub

        Node<AnyType> n = allVertex.get(0);

        dfs(n); //O(|E| + |V|)
        boolean isConnected = true;

        for (Node<AnyType> w : allVertex) { //O(|V|)
            isConnected &= w.visited;
        }

	return isConnected;
    }

    private MyList<AnyType> dfsComponents(Node<AnyType> vertex) {

        MyQueue<Node<AnyType>> queue = new MyQueue<>();
        MyListImpl<AnyType> ls = new MyListImpl<>();

        queue.push(vertex);

        while (!queue.isEmpty()) { //every edge of every vertex O(|E|).

            Node<AnyType> node = queue.pop();
            vertex.visited = true;
            ArrayList<Node<AnyType>> list = node.outgoing;
            ls.push(node.getVertex());

            for (Node<AnyType> vert : list) {// O(|E|) of the connected component.

                if (!vert.visited) {
                    vert.visited = true;
                    queue.push(vert);
                }
            }

        }
        return ls;
    }

    @Override
    public MyList<MyList<AnyType>> connectedComponents() {
	// TODO Auto-generated method stub

        for (Node<AnyType> vertex : this.allVertex) {// O(|V|)
            vertex.visited = false;
        }

        MyListImpl<MyList<AnyType>> lsOfls = new MyListImpl<>();

        for (Node<AnyType> vertex : allVertex) {

            if (!vertex.visited) {
                MyList<AnyType>  ls = dfsComponents(vertex); //O(|E| + |V|)
                lsOfls.push(ls);
            }
        }

	return lsOfls;
    }

    public boolean isConnected2() {
        // TODO Auto-generated method stub

        Node<AnyType> n = allVertex.get(0);

        dfs(n); //O(|E| + |V|)
        boolean isConnected = true;

        for (Node<AnyType> w : allVertex) { //O(|V|)
            isConnected &= w.visited || w.outgoing.size() <= 0;
        }

        return isConnected;
    }

    @Override
    public boolean hasEulerPath() {
	// TODO Auto-generated method stub

        boolean isconn = isConnected2(); //O(|V| + |E|)

        int numOddEdges=0;
        boolean hasEvenEdges = false;
        for(Node<AnyType> vert : allVertex){ //O(|V|).
            int numEdges = vert.outgoing.size();
            if( numEdges % 2 == 0){
                hasEvenEdges = true;
            }else{// odd num of edges should be either 0 or 2.
                numOddEdges++;
            }

        }

        if(hasEvenEdges){
            hasEvenEdges = numOddEdges == 0 || numOddEdges == 2;
        }

	return hasEvenEdges & isconn;
    }

    @Override
    public MyList<AnyType> eulerPath() {
	// TODO Auto-generated method stub
        MyList list = new MyListImpl<>();
        if (!isConnected() || !hasEulerPath()) // Base case in order to continue the algorithm.
            return list;



	return null;
    }

}
