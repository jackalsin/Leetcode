package airbnb.echoTcpServer.client;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ClientTest {
  private static final double BIAS = 1E-6;

  @Test
  @Disabled
  void testOnlineCase1() throws IOException, InterruptedException {
//    final Car car = new Car(0d, 0d);
    final double target = 10d;
//    final Server server = new Server(car);
    final Client client = new Client(target, BIAS);
//    server.run();
//    Thread.sleep(2000);
    client.run();
  }
}