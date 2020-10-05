package google.treasure;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * @author jacka
 * @version 1.0 on 1/31/2018.
 */
public final class Room {

  private final int id;
  public final boolean hasTreasure;
  private final Set<Edge> keys = new HashSet<>();

  public Room(int id, boolean hasTreasure) {
    this.id = id;
    this.hasTreasure = hasTreasure;
  }

  public Set<Edge> getKeys() {
    return new HashSet<>(keys);
  }

  public void addKey(final Edge edge) {
    keys.add(edge);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Room)) {
      return false;
    }
    Room room = (Room) o;
    return id == room.id &&
        hasTreasure == room.hasTreasure &&
        Objects.equals(keys, room.keys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hasTreasure, keys);
  }
}
