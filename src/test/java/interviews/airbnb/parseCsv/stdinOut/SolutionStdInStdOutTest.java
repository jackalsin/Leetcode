package interviews.airbnb.parseCsv.stdinOut;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionStdInStdOutTest {
  private Solution solution;
  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  private ByteArrayOutputStream outContent;
  private ByteArrayOutputStream errContent;
  private ByteArrayInputStream inputContent;

  private ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

  @BeforeEach
  void setup() {
    outContent = new ByteArrayOutputStream();
    errContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    System.setErr(originalErr);

  }

  @AfterEach
  void tearDown() {
    System.setIn(originalIn);
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  void testOnlineCase1() throws ExecutionException, InterruptedException {
    final List<String> input = List.of(
        "Weronika,Zaborska,njkfdsv@dsgfk.sn,\"running, sc-fi\",new,Krakow,25",
        "Ryuichi,Akiyama,jkg@ljnsfd.fjn,music,guide,Tokyo,65",
        "Elena,Martinez,emrt@lsofnbr.rt,\"cooking, traveling\",superhost,Valencia,42",
        "\"John \"\"Mo\"\"\",Smith,sfn@flkaei.km,biking and hiking,,\"Seattle, WA\",23"
    ), expected = List.of(
        "Weronika, 25 years old, is from Krakow and is interested in running, sc-fi.",
        "Ryuichi, 65 years old, is from Tokyo and is interested in music.",
        "Elena, 42 years old, is from Valencia and is interested in cooking, traveling.",
        "John \"Mo\", 23 years old, is from Seattle, WA and is interested in biking and hiking."
    );
    inputContent = new ByteArrayInputStream(String.join(System.lineSeparator(), input).getBytes());
    System.setIn(inputContent);
    final Future future = threadPool.submit(() -> Solution.main(new String[0]));
    while (future.get() != null) {
    }
    final String unFormatted = outContent.toString();
    final List<String> actual = Arrays.stream(unFormatted.split(System.lineSeparator())).collect(Collectors.toList());
    assertEquals(expected, actual);
  }

}