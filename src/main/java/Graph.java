import java.util.*;
import java.util.stream.Collectors;

public class Graph <T>{
    private ArrayList<Vertex<T>> adjacentList;
    private List<Integer> degreesSequence;

    public Graph(){
        this.adjacentList = new ArrayList<>();


    }

    public void addVertex(T vertex){
        this.adjacentList.add(new Vertex<>(vertex));
    }

    public void addEdge(T source, T destination){

    }

    public List<Vertex<T>> getAdjacentList(T vertex){
        return this.adjacentList.stream().filter(v -> v.getValue().equals(vertex)).findFirst().get().getAdjacent();
    }




    /**
     * Este método utiliza el algoritmo de Havel-Hakimi
     * para identificar que la secuencia de grados es un grafo.
     *
     * @return true si es un grafo, false si no lo es.
     */
    public static boolean isGraph(List<Integer> degrees){
        ArrayList<Integer> degreesCopy = degrees.stream().collect(Collectors.toCollection(ArrayList::new));

        while(true) {
            Collections.sort(degreesCopy, Collections.reverseOrder());
            if (degreesCopy.get(0) == 0)
                return true;

            int firstElement = degreesCopy.get(0);
            degreesCopy.remove(0);

            if (firstElement > degreesCopy.size())
                return false;

            for (int k = 0; k < firstElement; k++) {
                degreesCopy.set(k, degreesCopy.get(k) - 1);
                if (degreesCopy.get(k) < 0)
                    return false;
            }
        }
    }

    /**
     * Este método utiliza el algoritmo de Depth-First Search para
     * mostrar la información de los nodos del grafo.
     */

    public List<T> depthFirstSearch(){
        List<T> result = new ArrayList<>();
        for (Vertex<T> v : this.adjacentList) {
            if (!v.isVisited()) {
                result.addAll(depthFirstSearch(v));
            }
        }
        return result;
    }

    private List<T> depthFirstSearch(Vertex<T> v){
        List<T> result = new ArrayList<>();
        v.setVisited(true);
        result.add(v.getValue());
        for (Vertex<T> v2 : v.getAdjacent()) {
            if (!v2.isVisited()) {
                result.addAll(depthFirstSearch(v2));
            }
        }
        return result;
    }

}
