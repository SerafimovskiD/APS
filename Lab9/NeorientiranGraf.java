import java.util.*;

class AdjacencyListGraph<T> {
    private Map<T, Set<T>> adjacencyList;
    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    public void removeVertex(T vertex) {

        for (Set<T> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }

        adjacencyList.remove(vertex);
    }


    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source);
        }
    }

    public Set<T> getNeighbors (T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public void print()
    {
        adjacencyList.forEach((x,y) ->
                System.out.printf("%s: %s\n", x.toString(), new ArrayList<T>(y)));
        System.out.printf("\n");
    }

}

public class NeorientiranGraf {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line, parts[];
        int n = sc.nextInt();
        line=sc.nextLine();
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for(int i=0; i<n; i++)
        {
            line = sc.nextLine();
            parts=line.split(" ");
            switch(parts[0])
            {
                case "CREATE": graph = new AdjacencyListGraph<>();
                    break;
                case "PRINTGRAPH": graph.print();
                    break;
                case "ADDEDGE": graph.addEdge(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
                    break;
                case "DELETEEDGE": graph.removeEdge(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
                    break;
                default:
                    System.out.println(graph
                            .getNeighbors(Integer.parseInt(parts[1]) )
                            .contains(Integer.parseInt(parts[2])));
                    break;
            }
        }

    }
}