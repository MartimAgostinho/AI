import searchalgorithm.Algorithms;
import searchalgorithm.Node;
import undirectedgraph.Graph;
import undirectedgraph.Romenia;
import undirectedgraph.Vertex;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    private static Node searchSolution( String loc, String dest, ArrayList<String> prov ){

        Graph rom = Romenia.defineGraph();
        Graph map = new Graph();

        //add loc and dest to graph

        map.addVertex(
                rom.getVertex(loc).getLabel(),
                rom.getVertex(loc).getLatitude(),
                rom.getVertex(loc).getLongitude());

        map.addVertex(
                rom.getVertex(dest).getLabel(),
                rom.getVertex(dest).getLatitude(),
                rom.getVertex(dest).getLongitude());

        HashSet<Vertex> cities;
        ArrayList<Vertex> vlist = new ArrayList<Vertex>(),
                          vtm   = new ArrayList<Vertex>();
        vlist.add( map.getVertex(loc) );

        for( String p : prov ){

            cities = rom.
                    getVertexSet( p ).
                    getVertices();
            vtm.clear();

            for( Vertex vt: cities ){

                map.addVertex(
                        vt.getLabel(),
                        vt.getLatitude(),
                        vt.getLongitude());
                vtm.add( vt );

                for( Vertex v: vlist ){
                    //add caminhos
                    map.addEdge( v.getLabel(), vt.getLabel() );

                }
            }
            vlist = new ArrayList<>(vtm);
        }
        for( Vertex v: vlist ){
            //add caminhos
            map.addEdge( v.getLabel(), dest );
        }

        map.showLinks();
        Node n = map.searchSolution( loc,dest,Algorithms.AStarSearch );
        rom.showSolution(n);
        return n;
    }

    public static void main(String[] args) {

        String loc = "Arad", dest = "Vaslui";
        ArrayList<String> s = new ArrayList<String>();
        Graph graph = Romenia.defineGraph();
        graph.showLinks();
        graph.showSets();
/*
        Node n = graph.searchSolution(loc,dest,Algorithms.AStarSearch);
        graph.showSolution(n);
        n = graph.searchSolution(loc,dest,Algorithms.UniformCostSearch);
        graph.showSolution(n);
        n = graph.searchSolution(loc,dest,Algorithms.DepthFirstSearch);
        graph.showSolution(n);
        n = graph.searchSolution(loc,dest,Algorithms.GreedySearch);
        graph.showSolution(n);
        n = graph.searchSolution(loc,dest,Algorithms.BreadthFirstSearch);
        graph.showSolution(n);
*/
        s.add("Transilvania");
        s.add("Muntenia");
        s.add("Banat");
        searchSolution(loc,dest,s);
        /*
        ArrayList<String> s  new ArrayList<String>();
        s.add("Dobrogea");
        s.add("Banat");

        Node n = searchSolution( "Arad","Bucharest",s );
*/
    }
}