import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        List<Integer> sequence = List.of(2,2,2,2,3,3,4);

       // System.out.println(Graph.isGraph(sequence));

        var graph = new Graph<Integer>();

//        graph.addVertex(0);
//        graph.addVertex(1);
//        graph.addVertex(2);
//        graph.addVertex(3);
//        graph.addVertex(4);
//
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(0, 3);
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 4);

        //System.out.println(graph.depthFirstSearch());

        graph = createRandomGraph(sequence);

    }


    /**
     * Este método  crea un grafo guarde números aletorios
     * en base a una secuencia dada.
     * */
    public static Graph<Integer> createRandomGraph(List<Integer> degrees) {
        Graph<Integer> graph = new Graph<>();
        var random = new Random();

        List<Integer> randNums = random.ints(0, degrees.size()).distinct().limit(degrees.size()).boxed().collect(Collectors.toList());

        randNums.forEach(i -> graph.addVertex(i));








        randNums.forEach(i -> {
            System.out.print(i + " : ");
            System.out.println(graph.getAdjacentList(randNums.get(i)));
        });
        return graph;
    }
}
