package interviews.airbnb.echoTcpServer.solution;

import interviews.airbnb.echoTcpServer.model.Car;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static interviews.airbnb.echoTcpServer.common.Settings.SUCCESS;
import static org.junit.jupiter.api.Assertions.fail;

class SolutionTest {
  private static final double BIAS = 1e-5;
  private static final String INITIAL = "%f %f";
  private final ExecutorService exectutor = Executors.newFixedThreadPool(4);

  @Test
  @Disabled
  void testOnlineCase1() {
    final double initSpeed = 0d, initGas = 0d, targetSpeed = 100d;
    final Car car = new Car(initSpeed, initGas, speed -> 1d);
    exectutor.execute(() -> {
      try {
        car.run();
      } catch (InterruptedException e) {
        fail("Car is down");
      }
    });
    final Solution solution = new Solution(targetSpeed, BIAS);
    while (true) {
      final String resp = String.format(INITIAL, car.getGas(), car.getSpeed());
      final String sol = solution.solve(resp);
      System.out.println(resp + "\t\t\t" + sol);
      if (sol.startsWith(SUCCESS)) {
        return;
      }
      final String[] items = sol.split(" ");
      car.setGas(Double.parseDouble(items[1]));
//      car.runDebug();
    }
  }

}