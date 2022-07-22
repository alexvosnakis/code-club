import java.util.Arrays;
import java.util.List;

public class Robot {
  private int x;
  private int y;
  private Direction dir;

  public static enum Direction {
    NORTH, SOUTH, EAST, WEST;

    static final List<Direction> ROTATION = Arrays.asList(
      NORTH, WEST, SOUTH, EAST
    );
  }

  public Robot(int x, int y, Direction dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
  }

  public void report() {
    System.out.println(String.format("x: %d, y: %d, dir: %s", this.x, this.y, this.dir));
  }

  public void left() {
    int current = Direction.ROTATION.indexOf(this.dir);
    int next = (current + 1) % Direction.ROTATION.size();
    this.dir = Direction.ROTATION.get(next);
  }

  public void right() {
    int current = Direction.ROTATION.indexOf(this.dir);
    int next = (current - 1 + Direction.ROTATION.size()) % Direction.ROTATION.size();
    this.dir = Direction.ROTATION.get(next);
  }
}
