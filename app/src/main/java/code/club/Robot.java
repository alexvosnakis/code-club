package code.club;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.google.common.base.Objects;

public class Robot {
  private int x;
  private int y;
  private int z;
  private Direction dir;

  private boolean hasBeenPlaced;
  private boolean rotorRunning;

  private final Table table;

  public static enum Direction {
    NORTH, SOUTH, EAST, WEST;

    static final List<Direction> ROTATION = Arrays.asList(
        NORTH, WEST, SOUTH, EAST);
  }

  public Robot(Table table) {
    this(table, 0, 0, 0, Direction.NORTH, false, false);
  }

  Robot(Table table, int x, int y, int z, Direction dir, boolean hasBeenPlaced, boolean rotorRunning) {
    this.table = table;
    this.x = x;
    this.y = y;
    this.z = z;
    this.dir = dir;
    this.hasBeenPlaced = hasBeenPlaced;
    this.rotorRunning = rotorRunning;
  }

  /**
   * This will print the position and direction of the robot.
   */
  public void report(Command.Report report) {
    if (!hasBeenPlaced) {
      return;
    }

    System.out.println(String.format("x: %d, y: %d, z: %d, dir: %s", this.x, this.y, this.z, this.dir));
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

  public void rotorStart(Command.RotorStart rotorStart) {
    if (!hasBeenPlaced) {
      return;
    }

    this.rotorRunning = true;
  }

  public void rotorStop(Command.RotorStop rotorStop) {
    this.rotorRunning = false;

    // TODO this robot will be damaged if it lands on a obstacle
    // eg. if (table.obstacleAt(this.x, this.y)) damageRobot() or something

    // now land the robot!
    this.z = 0;
  }

  private void rotate(Function<Integer, Integer> rotationInd) {
    int current = Direction.ROTATION.indexOf(this.dir);
    int next = rotationInd.apply(current) % Direction.ROTATION.size();
    this.dir = Direction.ROTATION.get(next);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (!(obj instanceof Robot))
      return false;

    Robot other = (Robot) obj;
    return this.x == other.x
        && this.y == other.y
        && this.z == other.z
        && this.hasBeenPlaced == other.hasBeenPlaced
        && this.rotorRunning == other.rotorRunning
        && this.dir == other.dir;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.x, this.y, this.z, this.hasBeenPlaced, this.rotorRunning, this.dir);
  }
}
