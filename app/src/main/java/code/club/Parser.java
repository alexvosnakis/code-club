package code.club;

import java.util.Arrays;
import java.util.List;

import code.club.Command.Left;
import code.club.Command.Move;
import code.club.Command.Place;
import code.club.Command.Report;
import code.club.Command.Right;

public class Parser {
  public static Command accept(String rawCommand) throws IllegalCommandException {
    List<String> tokens = Arrays.asList(rawCommand.split("\\s"));

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
          if (part1.isEmpty()) {
            throw new IllegalCommandException("Empty command");
          } else {
            throw new IllegalCommandException("Unknown command: " + part1);
          }
      }
    } else {
      throw new IllegalCommandException("Empty command");
    }
  }

  private static Command placeCommand(List<String> tokens) throws IllegalCommandException {
    if (tokens.size() != 2) {
      throw new IllegalCommandException("Missing data for PLACE command");
    }

    List<String> locationMeta = Arrays.asList(tokens.get(1).split(","));

    if (locationMeta.size() != 3) {
      throw new IllegalCommandException("Missing location data for PLACE command");
    }

    try {
      int x = Integer.valueOf(locationMeta.get(0));
      int y = Integer.valueOf(locationMeta.get(1));

      Robot.Direction dir = Robot.Direction.valueOf(locationMeta.get(2).toUpperCase());
      return new Command.Place(x, y, dir);
    } catch (NumberFormatException e) {
      throw new IllegalCommandException("Bad location: " + locationMeta);
    } catch (IllegalArgumentException e) {
      throw new IllegalCommandException("Bad direction: " + locationMeta);
    }
  }
}
