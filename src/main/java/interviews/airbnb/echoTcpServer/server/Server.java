package interviews.airbnb.echoTcpServer.server;

import interviews.airbnb.echoTcpServer.model.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static interviews.airbnb.echoTcpServer.common.Settings.PORT;
import static interviews.airbnb.echoTcpServer.common.Settings.STATUS;
import static interviews.airbnb.echoTcpServer.common.Settings.THROTTLE;

public final class Server {
  private final Car car;
  private static final int THREADS = 2;
  private final ExecutorService threadPool = Executors.newFixedThreadPool(THREADS);
  private ServerSocket serverSocket = new ServerSocket(PORT);

  public Server(final Car car) throws IOException {
    this.car = new Car(car);
  }

  public void run() {
    threadPool.execute(() -> {
      try {
        car.run();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    worker();
  }

  public void worker() {
    try (
        Socket clientSocket = serverSocket.accept();
        PrintWriter out =
            new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()))
    ) {
      String inputLine, outputLine;

      while ((inputLine = in.readLine()) != null) {
        if (inputLine.startsWith(STATUS)) {
          outputLine = statusController();
          out.println(outputLine);
        } else if (inputLine.startsWith(THROTTLE)) {
          throttleController(inputLine);
        } else {
          throw new IllegalArgumentException("Not acceptable: " + inputLine);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void throttleController(final String input) {
    System.out.println("Throttle");
    final String[] items = input.split(" ");
    car.setGas(Double.parseDouble(items[1]));
  }

  private String statusController() {
    System.out.println("Status");
    return String.format("%f %f", this.car.getGas(), this.car.getSpeed());
  }

  public static void main(final String[] args) throws IOException {
    final Car car = new Car(0d, 0d, speed -> 1E-2 * speed);
    final Server server = new Server(car);
    server.run();
  }
}
