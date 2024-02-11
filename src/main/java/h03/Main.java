package h03;

import fopbot.*;

public class Main {

  public final static int WORLD_SIZE_X = 10;
  public final static int WORLD_SIZE_Y = 10;

  /**
   * Main Method. Creates World and call robotTest()
   */
  public static void main(String[] args) {
    World.setSize(WORLD_SIZE_X, WORLD_SIZE_Y);
    World.setDelay(200);
    World.setVisible(true);
    robotTests();

  }

  /**
   * Calls putCoin() of Robot-Object numberOfCoins times
   *
   * @param robot         Robot-Object for which putCoin() gets called
   * @param numberOfCoins times putCoin() gets called
   */
  public static void putNumberOfCoins(Robot robot, int numberOfCoins) {
    for (int i = 0; i < numberOfCoins; i++) {
      robot.putCoin();
    }
  }

  /**
   * robotTests(), where Robots can be tested
   */
  public static void robotTests() {
    RobotWithInitialState robot = new RobotWithInitialState(0, 0, Direction.UP, 0);
    robot.move();
    robot.move();
    robot.turnLeft();
    robot.turnLeft();
    robot.turnLeft();
    robot.move();
    System.out.println("x Wert von Robot ist: " + robot.getX());
    System.out.println("y Wert von Robot ist: " + robot.getY());
    System.out.println("xdirection Wert von Robot ist: " + robot.getDirection());
    System.out.println("x Wert von RootWithInitialState ist: " + robot.getInitialX());
    System.out.println("y Wert von RootWithInitialState ist: " + robot.getInitialY());
    System.out.println("direction Wert von RootWithInitialState ist: " + robot.getInitialDirection());
    robot.setX(2);
    robot.setY(2);
    System.out.println("x Wert von Robot ist: " + robot.getX());
    System.out.println("y Wert von Robot ist: " + robot.getY());
    System.out.println("xdirection Wert von Robot ist: " + robot.getDirection());
    System.out.println("x Wert von RootWithInitialState ist: " + robot.getInitialX());
    System.out.println("y Wert von RootWithInitialState ist: " + robot.getInitialY());
    System.out.println("direction Wert von RootWithInitialState ist: " + robot.getInitialDirection());
  }
}
