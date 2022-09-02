package code.club;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ParserTest {

  @Test
  public void whenRotorStartText_thenRotorStartCommand() throws IllegalCommandException {
    Command command = Parser.accept("ROTOR-START");

    assertInstanceOf(Command.RotorStart.class, command);
  }

  @Test
  public void whenRotorStopText_thenRotorStartCommand() throws IllegalCommandException {
    Command command = Parser.accept("ROTOR-STOP");

    assertInstanceOf(Command.RotorStop.class, command);
  }

  @Test
  public void whenUnknownCommand_thenException() {
    assertThrows(IllegalCommandException.class, () -> {
      Parser.accept("this is not a valid command");
    });
  }

}
