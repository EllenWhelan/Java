import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/* 1. Justify the choice of the data structures used in CompetitionDijkstra and
CompetitionFloydWarshall:

I chose to use a two dimensional array of floats as an array is optimal for dense graphs in dijkstras algorithm.
I personally wanted a solution that would work well on denser graphs. An array is also easier to implement
 than a binary, 4 way or fobonacci heap. These heaps provide perhaps
better solutions but are not worth implementing for the extra effiency they provide.

2. Explain theoretical differences in the performance of Dijkstra and Floyd-Warshall algorithms
in the given problem. Also explain how would their relative performance be affected by the
density of the graph. Which would you choose in which set of circumstances and why?

The way I solve this problem is to get all the shortest paths from every vertex to evry other vertex.
Because of this FW is easier to implement in terms of lines of code as it only has to be called once to get
 the entire set of paths back. ijkstra must be called in a for loop for each vertex and then processed to find
  th elongest path to give to the slowest walker. FW uses more memory space as it makes a second float array the
   same size as t he graph but dijkstar only has a secondary array the size of the number of vertices.
Dijkstra works quicker in most cases as FW has many more for loops in its algorithm causing asymptotic run
time to grow quickly. Dijkstra also works better on denser graphs as the float array data structure is optimal in
these cases. In denser graphs I would choose dijkstra as the memory usage and run times is less.


 */

public class CompetitionTests {

    @Test
    public void testGraphStuff(){
       EWGraph test=new EWGraph(8, 15, 56, 60, 70);
       Edge testEdge= new Edge(2, 0, 1);
       int dst=testEdge.getDst();
       int src=testEdge.getSrc();
       float weight=testEdge.getWeight();
       test.addEdge(testEdge);
       int edg=test.getEdges();
       assertEquals("testing get edge", 15, edg);
       int vert=test.getVertices();
       assertEquals("testing vert",8, vert);

    }

    @Test
    public void testDijkstraConstructor() {

        new CompetitionDijkstra("tinyEWD.txt", 56, 60, 70);
    }

    @Test public void testTimeForCompDij(){
        //normal
        CompetitionDijkstra newG= new CompetitionDijkstra("tinyEWD.txt", 56, 60, 70);
        int actualResult= newG.timeRequiredforCompetition();
        assertEquals("Expecting 34", 34, actualResult);

        EWGraph empty=null;
        float result= newG.findLongestDistanceDij(empty);
        assertEquals("testing null graph", -1.0f, result);

        newG.graph=null;
        int newResult=newG.timeRequiredforCompetition();
        assertEquals("Testing null graph tie=me", -1, newResult);



    }

    @Test
    public void testFWConstructor() {
        new CompetitionFloydWarshall("tinyEWD.txt", 56, 60, 70);
    }

    @Test public void testTimeForCompFW(){
        CompetitionFloydWarshall newG = new CompetitionFloydWarshall("tinyEWD.txt", 56, 60, 70);
        int actualResult = newG.timeRequiredforCompetition();
        assertEquals("Expecting 34", 34, actualResult);

        EWGraph empty=null;
        float result= newG.findLongestDistance(empty);
        assertEquals("testing null graph", -1.0f, result);

        newG.graph=null;
        int newResult=newG.timeRequiredforCompetition();
        assertEquals("Testing null graph tie=me", -1, newResult);
    }

    //TODO - more tests

}