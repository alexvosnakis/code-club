public class Main {
  public static void main(String[] args) {
    Robot robot = new Robot(1, 2, Robot.Direction.NORTH);
    robot.report();
    robot.left();
    robot.report();
  }
}
