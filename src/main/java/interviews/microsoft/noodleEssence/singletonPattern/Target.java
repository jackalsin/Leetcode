package interviews.microsoft.noodleEssence.singletonPattern;

public final class Target {
  private static long idCount = 0;
  private final long id;

  Target() {
    id = idCount++;
  }

  public long getId() {
    return id;
  }
}
