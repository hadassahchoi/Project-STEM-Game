import java.io.Serializable;

public class User implements Serializable {
  public String name;
  public int score;

  public User (String name,int score) {
    this.name = name;
    this.score = score;
  }

  public String toString() {
    return name + "\n\tScore: " + score;
  }
}