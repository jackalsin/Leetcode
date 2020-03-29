package _0851_0900._853_Car_Fleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int carFleet(int target, int[] position, int[] speed) {
    final List<Car> cars = new ArrayList<>();
    for (int i = 0; i < position.length; ++i) {
      cars.add(new Car(position[i], speed[i]));
    }
    Collections.sort(cars, (x, y) -> Integer.compare(y.pos, x.pos));
//    System.out.println(cars);
    if (cars.isEmpty()) {
      return 0;
    }
    int fleets = 1, lastCarStart = cars.get(0).pos, lastCarSpeed = cars.get(0).speed;
    for (int i = 1; i < position.length; ++i) {
      final Car car = cars.get(i);
      if (lastCarSpeed >= car.speed) {
//        System.out.printf("%d speed too slow\n", i);
        lastCarStart = car.pos;
        lastCarSpeed = car.speed;
        fleets++;
      }
      if ((long) (target - lastCarStart) * (car.speed - lastCarSpeed) < (long) (lastCarStart - car.pos) * lastCarSpeed) {
        // 追不上
//        System.out.printf("%d cannot reach before target\n", i);
        lastCarStart = car.pos;
        lastCarSpeed = car.speed;
        fleets++;
      }

    }
    return fleets;
  }

  private static final class Car {
    private final int pos, speed;

    private Car(int pos, int speed) {
      this.pos = pos;
      this.speed = speed;
    }

    @Override
    public String toString() {
      return "Car{" +
          "pos=" + pos +
          ", speed=" + speed +
          '}';
    }
  }
}
