import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class DijkstraAlgo {
    static void dijkstra(Set<Vertex> graph, Vertex source) {
        initSingleSource(graph, source);
        ArrayList<Vertex> shortestPath = new ArrayList<Vertex>();
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
        for (Vertex v: graph) {
            q.add(v);
        }
        while (q.size() != 0) {
            Vertex u = q.poll();
            shortestPath.add(u);
            System.out.println(u.name + ":\t" + ((u.distance==Integer.MAX_VALUE/2)? "∞":u.distance));
            for (Vertex v : u.es.keySet()) {
                relax(u,v);
            }
        }
    }

    static void initSingleSource(Set<Vertex> g, Vertex s) {
        for(Vertex v : g) {
            v.distance = Integer.MAX_VALUE/2;
            v.pi = null;
        }
        s.distance = 0;
    }

    static void relax(Vertex u, Vertex v) {
        int w = getWeight(u,v);
        if(v.distance > u.distance + w) {
            v.distance = u.distance + w;
            v.pi = u;
        }
    }

    public static void main (String [] args)
    {
        // build Graph
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        a.addEdge(b,50);
        a.addEdge(c,30);
        a.addEdge(d,100);
        a.addEdge(f,10);
        b.addEdge(c,5);
        c.addEdge(b,5);
        d.addEdge(b,20);
        d.addEdge(c,50);
        e.addEdge(d,15);
        e.addEdge(f,15);
        f.addEdge(d,10);

        Set<Vertex> graph = new HashSet<Vertex>();
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);

        // call Dijkstra algorithm
        dijkstra(graph, a);
    }

    static int getWeight(Vertex from, Vertex to) {
        return from.es.get(to);
    }
}

class Vertex implements Comparable<Vertex> {
    String name;
    int distance;
    Vertex pi;
    HashMap<Vertex, Integer> es = new HashMap<Vertex, Integer>();

    public Vertex(String name) {
        this.name = name;
    }

    void addEdge(Vertex v, int w) {
        es.put(v,w);
    }

    @Override
    public int compareTo(Vertex v) {
        int comp =this.distance - v.distance; 
        if (comp > 0) {
            return 1;
        } else if (comp == 0) {
            return 0;
        }
        return -1;
    }
}
