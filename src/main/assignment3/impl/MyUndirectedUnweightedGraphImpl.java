package main.assignment3.impl;

import main.assignment1.MyList;
import main.assignment3.UnweightedGraph;

public class MyUndirectedUnweightedGraphImpl<AnyType> implements UnweightedGraph<AnyType>{

    @Override
    public void addVertex(AnyType vertex) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addEdge(AnyType sourceVertex, AnyType targetVertex) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public boolean isConnected() {
	// TODO Auto-generated method stub
	return false;
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
