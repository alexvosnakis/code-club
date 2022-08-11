import java.util.Arrays;
import java.util.List;

public class Parser {
  public static Command accept(String rawCommand) {
    List<String> tokens = Arrays.asList(rawCommand.split(" "));

    if (!tokens.isEmpty()) {
      String part1 = tokens.get(0).toUpperCase();

      switch (part1) {
        case "PLACE":
          return placeCommand(tokens);
        case "LEFT":
          return new Command.Left();
        case "RIGHT":
          return new Command.Right();
        case "MOVE":
          return new Command.Move();
        case "REPORT":
          return new Command.Report();
        default:
          //todo report error
          return null;
      }
    }

    return null;
  }

  private static Command placeCommand(List<String> tokens) {
    if(tokens.size() != 2) {
      return null;
    }

    List<String> locationMeta = Arrays.asList(tokens.get(1).split(","));

    if(locationMeta.size() != 3) {
      return null; //todo report error
    }

    try {
      int x = Integer.valueOf(locationMeta.get(0));
      int y = Integer.valueOf(locationMeta.get(1));

      Robot.Direction dir = Robot.Direction.valueOf(locationMeta.get(2));
      return new Command.Place(x, y, dir);
    } catch(NumberFormatException e) {
      return null; //todo report error
    } catch(IllegalArgumentException e) {
      return null; //todo report error
    }
  }
}
