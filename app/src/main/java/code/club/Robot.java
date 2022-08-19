package code.club;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Robot {
  private int x;
  private int y;
  private Direction dir;

  private boolean hasBeenPlaced = false;

  private final Table table;

  public static enum Direction {
    NORTH, SOUTH, EAST, WEST;

    static final List<Direction> ROTATION = Arrays.asList(
        NORTH, WEST, SOUTH, EAST);
  }

  public Robot(Table table) {
    this.x = 0; // default
    this.y = 0; // default
    this.dir = Direction.NORTH; // default
    this.table = table;
  }

  /**
   * This will print the position and direction of the robot.
   */
  public void report(Command.Report report) {
    if (!hasBeenPlaced) {
      return;
    }

    System.out.println(String.format("x: %d, y: %d, dir: %s", this.x, this.y, this.dir));
  }

  public void left(Command.Left left) {
    if (!hasBeenPlaced) {
      return;
    }

    rotate(num -> num + 1);
  }

  public void right(Command.Right right) {
    if (!hasBeenPlaced) {
      return;
    }

    rotate(num -> num - 1 + Direction.ROTATION.size());
  }

  public void move(Command.Move move) {
    if (!hasBeenPlaced) {
      return;
    }

    int nextX = this.x;
    int nextY = this.y;

    switch (this.dir) {
      case NORTH:
        nextY++;
        break;
      case SOUTH:
        nextY--;
        break;
      case EAST:
        nextX++;
        break;
      case WEST:
        nextX--;
        break;
    }

    if (this.table.isOnTable(nextX, nextY)) {
      this.x = nextX;
      this.y = nextY;
    }
  }

  public void place(Command.Place place) {
    this.hasBeenPlaced = true;

    this.dir = place.dir;
    this.x = place.x;
    this.y = place.y;
  }

  private void rotate(Function<Integer, Integer> rotationInd) {
    int current = Direction.ROTATION.indexOf(this.dir);
    int next = rotationInd.apply(current) % Direction.ROTATION.size();
    this.dir = Direction.ROTATION.get(next);
  }

}
