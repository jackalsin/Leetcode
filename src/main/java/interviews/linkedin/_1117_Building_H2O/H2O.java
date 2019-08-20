package interviews.linkedin._1117_Building_H2O;

/**
 * TODO: revisit
 *
 * @author jacka
 * @version 1.0 on 8/19/2019
 */
public interface H2O {

  void hydrogen(Runnable releaseHydrogen) throws InterruptedException;

  void oxygen(Runnable releaseOxygen) throws InterruptedException;
}
