package main.assignment3.impl;
import main.assignment1.*;

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

       /*
       //testing mylist.
       MyListImpl<Integer> ls = new MyListImpl<Integer>();

       ls.push(5);
       ls.push(9);
       ls.push(2);
       ls.push(7);

       System.out.println(ls.get(0));
       System.out.println(ls.get(1));
       System.out.println(ls.get(2));
       System.out.println(ls.get(3));
       System.out.println("\n" +ls.size());

       MyList<Integer> ls2 = ls;

       System.out.println(ls2.get(1));
        */

        /*
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

       undirectedGraph.addEdge(8,5); //causes an unknown problem sometimes.

       undirectedGraph.addEdge(3,8);

       undirectedGraph.addEdge(1,3);

       undirectedGraph.addEdge(1,9);

       undirectedGraph.addEdge(9,0);

       //System.out.println(undirectedGraph);
       System.out.println("is graph connected? " + undirectedGraph.isConnected());

       MyList<MyList<Integer>> ls = undirectedGraph.connectedComponents();

       for(int i = 0; i < ls.size(); i++){

           MyList<Integer> tmp = ls.get(i);
           System.out.println("Connected Component : " + i);
           for(int k = 0; k < tmp.size(); k++){
               System.out.println(tmp.get(k) + ", ");
           }
       }

         */


        /*
       //testing connectedComponent
       MyUndirectedUnweightedGraphImpl<Integer> undirectedGraph = new MyUndirectedUnweightedGraphImpl<>();

       undirectedGraph.addVertex(5);
       undirectedGraph.addVertex(9);
       undirectedGraph.addVertex(8);
       undirectedGraph.addVertex(0);
       undirectedGraph.addVertex(3);
       undirectedGraph.addVertex(1);

       undirectedGraph.addEdge(5, 9);
       undirectedGraph.addEdge(9,8);
       undirectedGraph.addEdge(0,3);
       undirectedGraph.addEdge(1,0);
       undirectedGraph.addEdge(1,3);
       //two connected components (1,3,0) and ( 9,8,5).

       System.out.println("is graph connected? " + undirectedGraph.isConnected());

       MyList<MyList<Integer>> ls = undirectedGraph.connectedComponents();

       for(int i = 0; i < ls.size(); i++){

           MyList<Integer> tmp = ls.get(i);
           System.out.println("Connected componenet : " + i);
           for(int k = 0; k < tmp.size(); k++){
               System.out.println(tmp.get(k) + ", ");
           }
       }
       */



       /*MyUndirectedUnweightedGraphImpl<Integer> undirectedGraph = new MyUndirectedUnweightedGraphImpl<>();



       undirectedGraph.addVertex(1);
       undirectedGraph.addVertex(2);
       undirectedGraph.addVertex(3);
       undirectedGraph.addVertex(4);
       undirectedGraph.addVertex(5);
       undirectedGraph.addVertex(6);
       undirectedGraph.addVertex(7);
       undirectedGraph.addVertex(8);
       undirectedGraph.addVertex(9);

       undirectedGraph.addEdge(1,9);
       undirectedGraph.addEdge(1,6);
       undirectedGraph.addEdge(1,8);
       undirectedGraph.addEdge(1,2);

       undirectedGraph.addEdge(2,8);
       undirectedGraph.addEdge(2,3);
       undirectedGraph.addEdge(2,4);

       undirectedGraph.addEdge(3,4);

       undirectedGraph.addEdge(5,8);
       undirectedGraph.addEdge(5,7);

       undirectedGraph.addEdge(6,9);

       undirectedGraph.addEdge(7,8);

       System.out.println(undirectedGraph);*/




       MyUndirectedUnweightedGraphImpl <String> undirectedGraph = new MyUndirectedUnweightedGraphImpl<>();

       undirectedGraph.addVertex("1");
       undirectedGraph.addVertex("2");
       undirectedGraph.addVertex("3");
       undirectedGraph.addVertex("4");
       undirectedGraph.addVertex("5");
       //undirectedGraph.addVertex(8);

       undirectedGraph.addEdge("1","2");
       undirectedGraph.addEdge("1","4");
       undirectedGraph.addEdge("1","3");
       undirectedGraph.addEdge("1","5");

       undirectedGraph.addEdge("3","4");
       undirectedGraph.addEdge("3","2");
       undirectedGraph.addEdge("2","4");
       undirectedGraph.addEdge("3","5");


       System.out.println(undirectedGraph);
       System.out.println(undirectedGraph.hasEulerPath());
       System.out.println(undirectedGraph.eulerPath());
       String lol = undirectedGraph.eulerPath().get(0);
       System.out.println(lol);




       /*//testing hasEulerPath.
       MyUndirectedUnweightedGraphImpl<Integer> undirectedGraph = new MyUndirectedUnweightedGraphImpl<>();

       undirectedGraph.addVertex(1);
       undirectedGraph.addVertex(2);
       undirectedGraph.addVertex(3);
       undirectedGraph.addVertex(4);
       undirectedGraph.addVertex(5);
       //undirectedGraph.addVertex(8);

       undirectedGraph.addEdge(1,2);
       undirectedGraph.addEdge(1,4);
       undirectedGraph.addEdge(1,3);
       undirectedGraph.addEdge(1,5);

       undirectedGraph.addEdge(3,4);
       undirectedGraph.addEdge(3,2);
       undirectedGraph.addEdge(3,1);
       undirectedGraph.addEdge(3,5);

       undirectedGraph.addEdge(5,1);
       undirectedGraph.addEdge(5,3);

       undirectedGraph.addEdge(2,4); //the other two edges are already added for the 2 and the 4.

       //undirectedGraph.addEdge(5,8);

       System.out.println(undirectedGraph.hasEulerPath());

       //test2
       MyUndirectedUnweightedGraphImpl<Integer> UG = new MyUndirectedUnweightedGraphImpl<>();

       UG.addVertex(0);
       UG.addVertex(1);
       UG.addVertex(2);
       UG.addVertex(3);
       UG.addVertex(4);
       //UG.addVertex(10);

       UG.addEdge(3,4);
       UG.addEdge(0,3);
       UG.addEdge(2,0);
       UG.addEdge(1,0);
       UG.addEdge(1,2);
       //UG.addEdge(1,3);

       System.out.println(UG.hasEulerPath());*/
/*
       MyNeighborhoodImpl<Integer> neighborhood = new MyNeighborhoodImpl<>();

       neighborhood.addVertex(1,0,0);
       neighborhood.addVertex(2,0,0);
       neighborhood.addVertex(3,0,0);
       neighborhood.addVertex(4,0,0);
       neighborhood.addVertex(5,0,0);
       neighborhood.addVertex(6,0,0);
       neighborhood.addVertex(7,0,0);
       neighborhood.addVertex(8,0,0);
       neighborhood.addVertex(9,0,0);

       neighborhood.addEdge(1,2,4);
       neighborhood.addEdge(1,8,8);
       neighborhood.addEdge(2,8,11);
       neighborhood.addEdge(2,3,8);
       neighborhood.addEdge(8,9,7);
       neighborhood.addEdge(8,7,1);
       neighborhood.addEdge(3,9,2);
       neighborhood.addEdge(7,9,6);
       neighborhood.addEdge(3, 4,7);
       neighborhood.addEdge(3,6,4);
       neighborhood.addEdge(7,6,2);
       neighborhood.addEdge(6,4,14);
       neighborhood.addEdge(4,5,9);
       neighborhood.addEdge(6,5,10);

       int num = neighborhood.approximateMinimumDistance();

       System.out.println("the min distance should be between [37, 74[ : " + num);
 */
    /*
       MyNeighborhoodImpl<String> neighborhood = new MyNeighborhoodImpl();

       neighborhood.addVertex("A", 0 ,0);
       neighborhood.addVertex("B", 0 ,0);
       neighborhood.addVertex("C", 0 ,0);
       neighborhood.addVertex("D", 0 ,0);
       neighborhood.addVertex("E", 0 ,0);
       neighborhood.addVertex("F", 0 ,0);
       neighborhood.addVertex("G", 0 ,0);
       neighborhood.addVertex("H", 0 ,0);

       neighborhood.addEdge("A","B", 4);
       neighborhood.addEdge("A","D", 16);
       neighborhood.addEdge("A","G", 9);
       neighborhood.addEdge("B","C", 20);
       neighborhood.addEdge("B","G", 8);
       neighborhood.addEdge("C","E", 4);
       neighborhood.addEdge("E","D", 5);
       neighborhood.addEdge("E","H", 3);
       neighborhood.addEdge("D","F", 14);
       neighborhood.addEdge("D","H", 6);
       neighborhood.addEdge("G","H", 13);
       neighborhood.addEdge("G","F", 6);
       neighborhood.addEdge("G","E", 12);

       int num = neighborhood.approximateMinimumDistance();

       System.out.println("the min distance should be between [42, 84[ : " + num);
       */

    //testing last method.
       MyNeighborhoodImpl<Integer> neighborhood2 = new MyNeighborhoodImpl<>();

       neighborhood2.addVertex(1,9,38);
       neighborhood2.addVertex(2,6,40);
       neighborhood2.addVertex(3,5,24);


       System.out.println(neighborhood2.neighborsToVisit(15));


       MyNeighborhoodImpl<Integer> neighborhood = new MyNeighborhoodImpl<>();

       neighborhood.addVertex(1,5,60);
       neighborhood.addVertex(2,3,50);
       neighborhood.addVertex(3,4,70);
       neighborhood.addVertex(4,2,30);


       System.out.println(neighborhood.neighborsToVisit(5));

    }
}
