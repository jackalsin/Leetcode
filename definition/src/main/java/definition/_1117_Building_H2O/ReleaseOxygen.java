package definition._1117_Building_H2O;

/**
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public final class ReleaseOxygen implements Runnable {
  private final StringBuffer sb;
  private static final char VAL = 'O';

  public ReleaseOxygen(final StringBuffer sb) {
    this.sb = sb;
  }

  @Override
  public void run() {
    sb.append(VAL);
  }
}
