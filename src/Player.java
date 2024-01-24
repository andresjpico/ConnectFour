public class Player {
  //Public
    public Player(GridColor color, String name) {
      this.color = color;
      this.name = name;
    }

    public GridColor getColor() {
      return color;
    }

    public String getName() {
      return name;
    }

  //Private
    GridColor color;
    String name;
}
