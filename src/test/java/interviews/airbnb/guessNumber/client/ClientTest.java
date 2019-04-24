package interviews.airbnb.guessNumber.client;

import interviews.airbnb.guessNumber.server.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This will on travis CI
 */
@Disabled
class ClientTest {
  private Client client;
  private Server server;
  private static final int THREADS = Runtime.getRuntime().availableProcessors();
  private final ExecutorService threadPool = Executors.newFixedThreadPool(THREADS);

  @BeforeEach
  void setUp() {
    client = new Client();
  }

  @AfterEach
  void tearDown() throws IOException {
    if (server != null) {
      server.shutdown();
    }
  }

  @Test
  void testOnlineCase1111() throws IOException {
    final String target = "1111";
    server = new Server(target);
    startServer(server);
    assertEquals(target, client.solve());
  }

  @Test
  void testOnlineCase6666() throws IOException {
    final String target = "6666";
    server = new Server(target);
    startServer(server);
    assertEquals(target, client.solve());
  }

  @Test
  void testOnlineCase2346() throws IOException {
    final String target = "2346";
    server = new Server(target);
    startServer(server);
    assertEquals(target, client.solve());
  }

  @Test
  void testOnlineCase1115() throws IOException {
    final String target = "1115";
    server = new Server(target);
    startServer(server);
    assertEquals(target, client.solve());
  }

  private void startServer(final Server server) {
    threadPool.execute(() -> {
      try {
        server.run();
      } catch (IOException e) {
        e.printStackTrace();
        try {
          server.shutdown();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });
  }
}