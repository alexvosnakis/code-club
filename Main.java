import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Table table = new Table(5, 5);
    Robot robot = new Robot(table);

    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      try {
        Command command = Parser.accept(str);
        command.execute(robot);
      } catch (IllegalCommandException e) {
        System.out.println(e.getMessage());
      }
    }

    scanner.close();
  }
}
