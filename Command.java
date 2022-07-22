public interface Command {

  public Robot execute(Robot robot);

  public static class Move implements Command {

    @Override
    public Robot execute(Robot robot) {
      robot.move();
      return robot;
    }
  }

  public static class Report implements Command {

    @Override
    public Robot execute(Robot robot) {
      robot.report();
      return robot;
    }
  }

  public static class Left implements Command {

    @Override
    public Robot execute(Robot robot) {
      robot.left();
      return robot;

    }
  }

  public static class Right implements Command {

    @Override
    public Robot execute(Robot robot) {
      robot.right();
      return robot;

    }
  }

  public static class Place implements Command {

    private final int x;
    private final int y;
    private Robot.Direction dir;
    private Table table;

    public Place(int x, int y, Robot.Direction dir, Table table) {
      this.x = x;
      this.y = y;
      this.dir = dir;

    }

    @Override
    public Robot execute(Robot robot) {
      Robot newRobot = new Robot(x, y, dir, table);
      return new Robot(x, y, dir, table);
    }
  }
}
