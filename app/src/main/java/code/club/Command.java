package code.club;

public interface Command {

  public void execute(Robot robot);

  public static class Move implements Command {

    @Override
    public void execute(Robot robot) {
      robot.move(this);
    }
  }

  public static class Report implements Command {

    @Override
    public void execute(Robot robot) {
      robot.report(this);
    }
  }

  public static class Left implements Command {

    @Override
    public void execute(Robot robot) {
      robot.left(this);
    }
  }

  public static class Right implements Command {

    @Override
    public void execute(Robot robot) {
      robot.right(this);
    }
  }

  public static class Place implements Command {

    public final int x;
    public final int y;
    public final Robot.Direction dir;

    public Place(int x, int y, Robot.Direction dir) {
      this.x = x;
      this.y = y;
      this.dir = dir;
    }

    @Override
    public void execute(Robot robot) {
      robot.place(this);
    }
  }

  public static class RotorStart implements Command {

    @Override
    public void execute(Robot robot) {
      robot.rotorStart(this);
    }
  }

  public static class RotorStop implements Command {

    @Override
    public void execute(Robot robot) {
      robot.rotorStop(this);
    }
  }
}
