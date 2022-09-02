package code.club;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.club.Robot.Direction;

public class RobotTest {

  private final Table table = new Table(5, 5);

  @Test
  public void givenRobotPlaced_whenRotorStarts_thenRotorIsRunning() {
    Robot robot = new Robot(table);

    robot.place(new Command.Place(0, 0, Direction.NORTH));
    robot.rotorStart(new Command.RotorStart());

    Robot robot2 = new Robot(table, 0, 0, 0, Direction.NORTH, true, true);

    assertEquals(robot2, robot);
  }

  @Test
  public void givenRobotNotPlaced_whenRotorStarted_thenRotorIsNotRunning() {
    Robot robot = new Robot(table);

    robot.rotorStart(new Command.RotorStart());

    Robot robot2 = new Robot(table, 0, 0, 0, Direction.NORTH, true, true);

    assertNotEquals(robot2, robot);
  }

  @Test
  public void givenRobotRotorRunning_whenStopped_thenRobotLands() {
    Robot robot = new Robot(table, 0, 0, 1, Direction.NORTH, true, true);

    robot.rotorStop(new Command.RotorStop());

    Robot robot2 = new Robot(table, 0, 0, 0, Direction.NORTH, true, false);
    assertEquals(robot2, robot);
  }
}
