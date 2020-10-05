package airbnb.echoTcpServer.model;

import java.util.function.Function;

public final class Car {
  private volatile double speed;
  private volatile double gas;
  private static final int sleepInMillSecond = 10;

  private final Function<Double, Double> resistance;

  public Car(double speed, double gas, final Function<Double, Double> resistance) {
    this.speed = speed;
    this.gas = gas;
    this.resistance = resistance;
  }

  public Car(Car car) {
    this.speed = car.speed;
    this.gas = car.gas;
    this.resistance = car.resistance;
  }

  public double getSpeed() {
    return speed;
  }

  public double getGas() {
    return gas;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public void setGas(double gas) {
    this.gas = gas;
  }


  /**
   * Actually, there is no need to lock
   *
   * @throws InterruptedException
   */
  public void run() throws InterruptedException {
    while (true) {
      synchronized (this) {
        speed += (gas - resistance.apply(speed));
        Thread.sleep(sleepInMillSecond);
      }
    }
  }

  public void runDebug() {
    speed += (gas - resistance.apply(speed));
  }
}
