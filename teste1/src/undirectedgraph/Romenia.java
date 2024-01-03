package undirectedgraph;

import undirectedgraph.Graph;

public class Romenia {

	public static Graph defineGraph() {

		Graph g = new Graph();
		// Define cities:
		g.addVertex("Oradea", 47.13561353349686, 21.942814020576478);
		g.addVertex("Zerind", 46.52260061098099, 21.434580296440124);
		g.addVertex("Bucharest", 44.46500939226151, 26.132074670324325);
		g.addVertex("Urziceni", 44.7651157129097, 26.779688568229677);
		g.addVertex("Arad", 46.10335825736999, 21.38572515193939);
		g.addVertex("Mehadia", 44.83255531536103, 22.248290459890363);
		g.addVertex("Neamt", 47.025110100383756, 26.301262792711256);
		g.addVertex("Iasi", 47.2497405216217, 27.593019258441924);
		g.addVertex("R. Vilcea", 45.07871705239296, 24.23197022754669);
		g.addVertex("Eforie", 44.1411425446701, 28.64265878973961);
		g.addVertex("Pitesti", 44.886291018705364, 24.745782113246918);
		g.addVertex("Timisoara", 45.78511597787857, 21.147172155075076);
		g.addVertex("Craiova", 44.291238849096295, 23.886701366548536);
		g.addVertex("Hirsova", 44.68151902256012, 27.949804978523254);
		g.addVertex("Vaslui", 46.556726307811736, 27.872964073562624);
		g.addVertex("Giurgiu", 43.799509237489694, 25.836121172599793);
		g.addVertex("Sibiu", 45.73982535298347, 24.071660857515333);
		g.addVertex("Dobreta", 44.708144558353425, 22.554114568929673);
		g.addVertex("Fagaras", 45.987228839054104, 24.977595936632156);
		g.addVertex("Lugoj", 45.629784028759005, 21.758500103197097);
		// Define routes:
		g.addEdge("Bucharest","Giurgiu");
		g.addEdge("R. Vilcea","Sibiu");
		g.addEdge("Iasi","Vaslui");
		g.addEdge("Iasi","Neamt");
		g.addEdge("Lugoj","Mehadia");
		g.addEdge("Arad","Timisoara");
		g.addEdge("Arad","Sibiu");
		g.addEdge("Bucharest","Fagaras");
		g.addEdge("Eforie","Hirsova");
		g.addEdge("Fagaras","Sibiu");
		g.addEdge("Bucharest","Urziceni");
		g.addEdge("Craiova","Pitesti");
		g.addEdge("Dobreta","Mehadia");
		g.addEdge("Hirsova","Urziceni");
		g.addEdge("Arad","Zerind");
		g.addEdge("Craiova","R. Vilcea");
		g.addEdge("Craiova","Dobreta");
		g.addEdge("Urziceni","Vaslui");
		g.addEdge("Lugoj","Timisoara");
		g.addEdge("Bucharest","Pitesti");
		g.addEdge("Pitesti","R. Vilcea");
		g.addEdge("Oradea","Zerind");
		g.addEdge("Oradea","Sibiu");
		// Define regions:
		g.addVertexSet("Banat");
		g.addVertexToSet("Banat","Mehadia");
		g.addVertexToSet("Banat","Timisoara");
		g.addVertexToSet("Banat","Lugoj");
		g.addVertexSet("Crisana");
		g.addVertexToSet("Crisana","Oradea");
		g.addVertexToSet("Crisana","Zerind");
		g.addVertexToSet("Crisana","Arad");
		g.addVertexSet("Dobrogea");
		g.addVertexToSet("Dobrogea","Eforie");
		g.addVertexToSet("Dobrogea","Hirsova");
		g.addVertexSet("Moldova");
		g.addVertexToSet("Moldova","Neamt");
		g.addVertexToSet("Moldova","Iasi");
		g.addVertexToSet("Moldova","Vaslui");
		g.addVertexSet("Muntenia");
		g.addVertexToSet("Muntenia","Bucharest");
		g.addVertexToSet("Muntenia","Urziceni");
		g.addVertexToSet("Muntenia","Giurgiu");
		g.addVertexSet("Oltenia");
		g.addVertexToSet("Oltenia","R. Vilcea");
		g.addVertexToSet("Oltenia","Pitesti");
		g.addVertexToSet("Oltenia","Craiova");
		g.addVertexToSet("Oltenia","Dobreta");
		g.addVertexSet("Transilvania");
		g.addVertexToSet("Transilvania","Sibiu");
		g.addVertexToSet("Transilvania","Fagaras");

		return g;
	}

}
