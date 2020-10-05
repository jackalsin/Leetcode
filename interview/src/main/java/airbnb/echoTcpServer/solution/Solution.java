package airbnb.echoTcpServer.solution;

import static airbnb.echoTcpServer.common.Settings.SOLUTION_FORMAT;
import static airbnb.echoTcpServer.common.Settings.SUCCESS;

public final class Solution {
  private double prevGas = -1, prevSpeed = -1, initSpeed = -1;
  private final double targetSpeed, bias;
  private long prevTime = 0;
  private final double kP = 1d, kI = 1e-2, kD = 0d;

  public Solution(double targetSpeed, double bias) {
    this.targetSpeed = targetSpeed;
    this.bias = bias;
  }

  /**
   * @param resp a string that contains gas, a space and current speed
   * @return 1) Setting.SUCCESS when reached the goal status; 2) THROTTLE + " %f"
   */
  public String solve(final String resp) {
    final String[] items = resp.split(" ");
    final double gas = Double.parseDouble(items[0]), speed = Double.parseDouble(items[1]);
    // init
    if (prevGas == -1) {
      assert prevSpeed == -1;
      prevGas = gas;
      prevSpeed = speed;
      initSpeed = speed;
      prevTime = System.nanoTime();
      return String.format(SOLUTION_FORMAT, 1d);
    }

    if (Math.abs(targetSpeed - speed) <= bias) {
      return SUCCESS;
    }
    String solution = String.format(SOLUTION_FORMAT, nextGas(speed));
    prevSpeed = speed;
    return solution;
  }

  private double nextGas(final double curSpeed) {
    long curTime = System.nanoTime();
    final double eT = targetSpeed - curSpeed, eTao = curSpeed - initSpeed, deltaA = (curSpeed - prevSpeed) / (curTime - prevTime);
    prevTime = curTime;
    prevSpeed = curSpeed;
    return kP * eT + kI * eTao + kD * deltaA;
  }
}
