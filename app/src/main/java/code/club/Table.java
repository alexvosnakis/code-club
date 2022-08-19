package code.club;

public class Table {

  private final int xAxisLength;

  private final int yAxisLength;

  public Table(int xAxisLength, int yAxisLength) {
    this.xAxisLength = xAxisLength;
    this.yAxisLength = yAxisLength;
  }

  public boolean isOnTable(int x, int y) {
    // negative values are not allowed
    if (x < 0 || y < 0) {
      return false;
    }

    return (x < this.xAxisLength && y < this.yAxisLength);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null) {
      return false;
    }
    if (!(o instanceof Table)) {
      return false;
    }
    Table other = (Table) o;
    return (this.xAxisLength == other.xAxisLength && this.yAxisLength == other.yAxisLength);
  }
}
