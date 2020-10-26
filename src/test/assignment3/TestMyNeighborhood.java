package test.assignment3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.assignment3.Neighborhood;

import main.assignment3.impl.MyNeighborhoodImpl;

public class TestMyNeighborhood {

    @Test
    void testapproximateMinimumDistance() {
	Neighborhood<String> graph = createGraphProblemStatement();
	Assertions.assertTrue(4 <= graph.approximateMinimumDistance());
	Assertions.assertTrue(8 > graph.approximateMinimumDistance());

	Assertions.assertEquals(3, graph.neighborsToVisit(23).size());

    }

    private Neighborhood<String> createGraphProblemStatement() {
	Neighborhood<String> graph = new MyNeighborhoodImpl<String>();

	graph.addVertex("A", 6, 18);
	graph.addVertex("B", 9, 36);
	graph.addVertex("C", 7, 21);
	graph.addVertex("D", 10, 60);

	graph.addEdge("A", "B", 1);
	graph.addEdge("A", "C", 1);
	graph.addEdge("A", "D", 25);
	graph.addEdge("B", "C", 18);
	graph.addEdge("B", "D", 1);
	graph.addEdge("C", "D", 1);

	return graph;
    }

}
