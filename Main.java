import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Table table = new Table(5, 5);
    Robot robot = new Robot(table);

    // List<Command> commands = new ArrayList<>();
    // commands.add(new Command.Place(2, 2, Robot.Direction.NORTH));
    // commands.add(new Command.Move());
    // commands.add(new Command.Left());
    // commands.add(new Command.Move());
    // commands.add(new Command.Right());
    // commands.add(new Command.Report());

    // for (Command command : commands) {
    //   command.execute(robot);
    // }

    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      Command command = Parser.accept(str);
      command.execute(robot);
    }

    scanner.close();
  }
}
