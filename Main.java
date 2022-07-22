public class Main {
  public static void main(String[] args) {
    Table table = new Table(5, 5);
    Robot robot = new Robot(1, 2, Robot.Direction.NORTH, table);
    robot.report();
    robot.left();
    robot.move();
    robot.move();
    robot.report();
  }

}
