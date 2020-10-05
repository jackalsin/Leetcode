package google.treasure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public class Graph {
  private final Map<Room, Set<Edge>> incomingLinks = new HashMap<>();
  private final Map<Room, Set<Edge>> outcomingLinks = new HashMap<>();

  public void addRoom(final Room room) {
    incomingLinks.putIfAbsent(room, new HashSet<>());
    outcomingLinks.putIfAbsent(room, new HashSet<>());
  }

  public void addRooms(final Room... rooms) {
    for (final Room room : rooms) {
      incomingLinks.putIfAbsent(room, new HashSet<>());
      outcomingLinks.putIfAbsent(room, new HashSet<>());
    }
  }

  public void addEdge(final Edge edge) {
    incomingLinks.get(edge.to).add(edge);
    outcomingLinks.get(edge.from).add(edge);
  }

  public void addEdges(final Edge... edges) {
    for (final Edge edge : edges) {
      incomingLinks.get(edge.to).add(edge);
      outcomingLinks.get(edge.from).add(edge);
    }
  }

  public Set<Edge> getOutcomingEdges(final Room room) {
    return new HashSet<>(outcomingLinks.get(room));
  }
}
