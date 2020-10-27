package main.assignment3.impl;

public class main {
   public static void main(String[] args) {

        /*
       //testing my queue.
        MyQueue<Integer> queue = new MyQueue<Integer>();

        queue.push(5);
       queue.push(8);
       queue.push(1);
       queue.push(6);

       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println(queue.pop());
       System.out.println(queue.pop());
        */


        /*
       //testing the undirected graph that uses the hashtable.
       MyUndirectedUnweightedGraphImpl<Integer> undirectedGraph = new MyUndirectedUnweightedGraphImpl<>();
       undirectedGraph.addVertex(5);
       undirectedGraph.addVertex(9);
       undirectedGraph.addVertex(10);
       undirectedGraph.addVertex(1);
       undirectedGraph.addVertex(11);

       undirectedGraph.addEdge(5,9);
       undirectedGraph.addEdge(9,10);
       undirectedGraph.addEdge(5,1);
       undirectedGraph.addEdge(1,9);

       System.out.println(undirectedGraph);
       */

       //testing is connected
       MyUndirectedUnweightedGraphImpl<Integer> undirectedGraph = new MyUndirectedUnweightedGraphImpl<>();

       undirectedGraph.addVertex(5);
       undirectedGraph.addVertex(9);
       undirectedGraph.addVertex(8);
       undirectedGraph.addVertex(0);
       undirectedGraph.addVertex(3);
       undirectedGraph.addVertex(1);



       undirectedGraph.addEdge(5,9);


       undirectedGraph.addEdge(9,8);


       //undirectedGraph.addEdge(8,5); //for some unknown reason this doesn't work, it's the 5's fault (8,0) works, but not (0,5).


       undirectedGraph.addEdge(3,8);


       undirectedGraph.addEdge(1,3);


      undirectedGraph.addEdge(1,9);


       undirectedGraph.addEdge(9,0);

       //System.out.println(undirectedGraph);

       System.out.println(undirectedGraph.isConnected());



    }
}
