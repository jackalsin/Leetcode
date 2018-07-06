package interviews.microsoft._348_Design_Tic_Tac_Toe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeTest {

  @Test
  void testOnlineCase() {
    TicTacToe ticTacToe = new TicTacToe(3);
    assertEquals(0, ticTacToe.move(0, 0, 1));
//|X| | |
//| | | |    // Player 1 makes a move at (0, 0).
//| | | |

    assertEquals(0, ticTacToe.move(0, 2, 2));
//|X| |O|
//| | | |    // Player 2 makes a move at (0, 2).
//| | | |

    assertEquals(0, ticTacToe.move(2, 2, 1));
//|X| |O|
//| | | |    // Player 1 makes a move at (2, 2).
//| | |X|

    assertEquals(0, ticTacToe.move(1, 1, 2));
//|X| |O|
//| |O| |    // Player 2 makes a move at (1, 1).
//| | |X|

    assertEquals(0, ticTacToe.move(2, 0, 1));
//|X| |O|
//| |O| |    // Player 1 makes a move at (2, 0).
//|X| |X|

    assertEquals(0, ticTacToe.move(1, 0, 2));
//|X| |O|
//|O|O| |    // Player 2 makes a move at (1, 0).
//|X| |X|

    assertEquals(1, ticTacToe.move(2, 1, 1));
  }

  @Test
  void testAntiTriangle() {
    TicTacToe ticTacToe = new TicTacToe(3);
    assertEquals(0, ticTacToe.move(0, 2, 1));

    assertEquals(0, ticTacToe.move(1, 1, 1));

    assertEquals(1, ticTacToe.move(2, 0, 1));
  }

  @Test
  void testFailedCase() {
    TicTacToe ticTacToe = new TicTacToe(2);
    assertEquals(0, ticTacToe.move(0, 0, 2));

    assertEquals(0, ticTacToe.move(0, 1, 1));

    assertEquals(2, ticTacToe.move(1, 1, 2));
  }
}
