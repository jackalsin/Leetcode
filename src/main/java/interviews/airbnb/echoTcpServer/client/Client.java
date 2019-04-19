package interviews.airbnb.echoTcpServer.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static interviews.airbnb.echoTcpServer.common.Settings.PORT;
import static interviews.airbnb.echoTcpServer.common.Settings.SOLUTION_FORMAT;
import static interviews.airbnb.echoTcpServer.common.Settings.STATUS;
import static interviews.airbnb.echoTcpServer.common.Settings.SUCCESS;

public final class Client {
  private static final String HOSTNAME = "localhost";
  private double prevGas = -1, prevSpeed = -1;
  private final double targetSpeed, bias;
  private static final double MAX_POWER = 5000d;

  public Client(double targetSpeed, double bias) {
    this.targetSpeed = targetSpeed;
    this.bias = bias;
  }

  public void run() {
    try (Socket kkSocket = new Socket(HOSTNAME, PORT);
         BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
         PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true)) {
      String resp;
      while (true) {
        resp = receive(in, out);
        System.out.println(resp);
        final String solution = solve(resp);
        if (solution.equals(SUCCESS)) {
          return;
        }
        System.out.println(solution);
        send(out, solution);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String receive(BufferedReader in, PrintWriter out) throws IOException {
    out.println(STATUS);
    return in.readLine();
  }

  private void send(PrintWriter out, final String req) {
    out.println(req);
  }

  private String solve(final String resp) {
    final String[] items = resp.split(" ");
    final double gas = Double.parseDouble(items[0]), speed = Double.parseDouble(items[1]);
    if (prevGas == -1 && prevSpeed == -1) {
      prevGas = gas;
      prevSpeed = speed;
      return String.format(SOLUTION_FORMAT, MAX_POWER);
    }

    final double deltaSpeed = speed - prevSpeed;

    if (Math.abs(targetSpeed - speed) <= bias) {
      return SUCCESS;
    }
    String solution;
    if (deltaSpeed > 0 && speed > targetSpeed) {
      solution = String.format(SOLUTION_FORMAT, gas / 2);
    } else if (deltaSpeed > 0) { // speed <= targetSpeed
      solution = String.format(SOLUTION_FORMAT, gas);
    } else if (speed > targetSpeed) { // deltaSpeed <= 0
      solution = String.format(SOLUTION_FORMAT, gas);
    } else { // 减速 且 低于目标速度
      solution = String.format(SOLUTION_FORMAT, gas * 2);
    }
    return solution;
  }
}
