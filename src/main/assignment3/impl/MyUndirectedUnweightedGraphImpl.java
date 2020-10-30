package main.assignment3.impl;

import main.assignment1.MyList;
import main.assignment3.*;
import java.util.ArrayList;

public class MyUndirectedUnweightedGraphImpl<AnyType> implements UnweightedGraph<AnyType>{
    private MyMap<AnyType,  Node<AnyType>> adjacencyList; //an adjacencyList implemented with myHashtable.
    private ArrayList<Node<AnyType>> allVertex;
    private int numNodes;
    private int edges;


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

        public AnyType getVertex() {
            return vertex;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Node<AnyType> s : this.outgoing)
            {
                sb.append(s.vertex.toString());
                sb.append(" ");
            }
            return this.vertex + sb.toString();
        }

    }

    public MyUndirectedUnweightedGraphImpl(){

        this.adjacencyList = new MyHashTableImpl<AnyType,  Node<AnyType>>(0.48);
        this.allVertex = new ArrayList<>();
        edges = 0;

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
                edges++;
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

    public  ArrayList<Node> hasEulerPath2() {
        // TODO Auto-generated method stub
        boolean isconn = isConnected2(); //O(|V| + |E|)

        if (!isconn){
            return null;
        }
        ArrayList<Node> oddEdges = new  ArrayList<>();

        int numOddEdges=0;
        for(Node<AnyType> vert : allVertex){ //O(|V|).
            int numEdges = vert.outgoing.size();
            if( numEdges % 2 != 0){
                oddEdges.add(vert);
                numOddEdges++;
            }
            if (numOddEdges > 2) {
                return null;
            }

        }

        if (numOddEdges  == 0){
            oddEdges.add(allVertex.get(0));
            oddEdges.add(allVertex.get(1));
        }

        System.out.println(numOddEdges);

        return oddEdges;
    }

    @Override
    public MyList<AnyType> eulerPath() {
	// TODO Auto-generated method stub
        MyListImpl list = new MyListImpl<>();
        ArrayList <Node> oddVertices = hasEulerPath2();
        if ( oddVertices == null || oddVertices.size() == 1) {  // Base case in order to continue the algorithm.
            System.out.println(oddVertices);
            return list; // Returns an empty list one of the above requirements above are met.
        }


        Node start = oddVertices.get(0);
        MyStack<Node> stack = new MyStack();
        Node current = start;

        System.out.println(start.vertex);

        do {
            ArrayList<Node<AnyType>> neighbours = current.outgoing;
            if (neighbours.size() == 0) {
                list.push(current);
                current = stack.pop();
                continue ;
            }
            stack.push(current);
            Node tmp = current;
            current = neighbours.get(0);
            neighbours.remove(current);
            current.outgoing.remove(tmp);

        }while (!stack.isEmpty() && current != null );
        System.out.println(list.get(list.size()-1));
         if(list.size() < edges +1){
            list.push(start);
        }

        MyListImpl ordered = new MyListImpl<>();


        for (int i = 0; i < list.size(); i++ ){
            ordered.push(list.get(i));
        }

        System.out.println(edges);

	return list;
    }

}
