import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Table table = new Table(5, 5);
    Robot robot = null;

    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      System.out.println(str);

      Command command = Parser.accept(str, table);
      command.execute(robot);
    }

    scanner.close();
  }
}
