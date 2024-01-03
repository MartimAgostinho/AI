import searchalgorithm.Algorithms;
import searchalgorithm.Node;
import undirectedgraph.Graph;
import undirectedgraph.Romenia;
import undirectedgraph.Vertex;
import undirectedgraph.VertexSet;

import java.util.HashSet;
import java.util.Iterator;

public class Main1 {
    public static void main(String[] args) {

        String  loc  = "Arad",
                dest = "Bucharest",
                mid  = "Dobrogea";

        Graph graph = Romenia.defineGraph();
        graph.showLinks();
        graph.showSets();
        Node n;

        n = graph.searchSolution("Arad", "Bucharest", Algorithms.BreadthFirstSearch);
        graph.showSolution(n);

        VertexSet cities_vs = graph.getVertexSet(mid);
        HashSet<Vertex> cities = cities_vs.getVertices();
        Vertex vt;

        Iterator<Vertex> it = cities.iterator();
        int j = 0;

        Graph tmp = new Graph();

        tmp.addVertex(
                graph.getVertex(loc).getLabel(),
                graph.getVertex(loc).getLatitude(),
                graph.getVertex(loc).getLongitude());

        tmp.addVertex(
                graph.getVertex(dest).getLabel(),
                graph.getVertex(dest).getLatitude(),
                graph.getVertex(dest).getLongitude());

        Node[]  n1 = new Node[cities.size()],
                n2 = new Node[cities.size()];

        while( it.hasNext() ){

            vt = it.next();

            tmp.addVertex(
                    vt.getLabel(),
                    vt.getLatitude(),
                    vt.getLongitude());

            n1[j]   = graph.searchSolution(
                    loc,
                    vt.getLabel(),
                    Algorithms.AStarSearch );

            n2[j] = graph.searchSolution(
                    vt.getLabel(),
                    dest,
                    Algorithms.AStarSearch );

            tmp.addEdge( loc, vt.getLabel() );
            tmp.addEdge( vt.getLabel(), dest );
            ++j;
        }

        n = tmp.searchSolution(loc,dest,Algorithms.AStarSearch);
        //falta juntar as solucoes
        tmp.showSolution(n);

    }
}