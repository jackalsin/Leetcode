package interviews.google.campusBike.managerMiser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/19/2020
 */
class TestClassTest {

  @Test
  void testOnlineCase1() {
    final List<String> input = List.of(
        "3",
        "4 15 20",
        "7 10 19",
        "7 20 4"
    );
    inputContent = new ByteArrayInputStream(String.join(System.lineSeparator(), input).getBytes());
    System.setIn(inputContent);
    TestClass.main(new String[0]);
    final int expected = 18,
        actual = Integer.parseInt(outContent.toString());
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final List<String> input = List.of(
        "4",
        //  *
        "90 75 75 80",
        //        *
        "35 85 55 65",
        //      *
        "125 95 90 105",
        //*
        "45 110 95 115");
    inputContent = new ByteArrayInputStream(String.join(System.lineSeparator(), input).getBytes());
    System.setIn(inputContent);
    TestClass.main(new String[0]);
    final int expected = 275, // [75, 65, 90, 45]
        actual = Integer.parseInt(outContent.toString());
    assertEquals(expected, actual);
  }

  private final InputStream originalIn = System.in;
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  private ByteArrayOutputStream outContent;
  private ByteArrayOutputStream errContent;
  private ByteArrayInputStream inputContent;

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
}