import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Robot {
  private int x;
  private int y;
  private Direction dir;

  private final Table table;

  public static enum Direction {
    NORTH, SOUTH, EAST, WEST;

    static final List<Direction> ROTATION = Arrays.asList(
        NORTH, WEST, SOUTH, EAST);
  }

  public Robot(int x, int y, Direction dir, Table table) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.table = table;
  }

  /**
   * This will print the position and direction of the robot.
   */
  public void report() {
    System.out.println(String.format("x: %d, y: %d, dir: %s", this.x, this.y, this.dir));
  }

  public void left() {
    rotate(num -> num + 1);
  }

  public void right() {
    rotate(num -> num - 1 + Direction.ROTATION.size());
  }

  public void move() {
    switch (this.dir) {
      case NORTH:
        this.y++;
        break;
      case SOUTH:
        this.y--;
        break;
      case EAST:
        this.x++;
        break;
      case WEST:
        this.x--;
        break;
    }
  }

  private void rotate(Function<Integer, Integer> rotationInd) {
    int current = Direction.ROTATION.indexOf(this.dir);
    int next = rotationInd.apply(current) % Direction.ROTATION.size();
    this.dir = Direction.ROTATION.get(next);
  }

}
