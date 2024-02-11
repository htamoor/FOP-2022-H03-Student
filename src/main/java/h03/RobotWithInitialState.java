package h03;

import fopbot.*;

public class RobotWithInitialState extends Robot {

  private final int initialX;
  private final int initialY;
  private final Direction initialDirection;
  private final int initialNumberOfCoins;

  /**
   * Constructor of RobotWithMemorizedStart
   *
   * @param x             Initial x-Coordinate
   * @param y             Initial y-Coordinate
   * @param direction     Initial direction
   * @param numberOfCoins Initial numberOfCoins
   */
  public RobotWithInitialState(int x, int y, Direction direction, int numberOfCoins) {
    super(x, y, direction, numberOfCoins);
    initialX = x;
    initialY = y;
    initialDirection = direction;
    initialNumberOfCoins = numberOfCoins;
  }

  /**
   * @return the initialX coordinate
   */
  public int getInitialX() {
    return initialX;
  }

  /**
   * @return the initial y coordinate
   */
  public int getInitialY() {
    return initialY;
  }

  /**
   * @return the initial Direction
   */
  public Direction getInitialDirection() {
    return initialDirection;
  }

  /**
   * @return the initial number of coins
   */
  public int getInitialNumberOfCoins() {
    return initialNumberOfCoins;
  }
  // H1.3

  /**
   * The relative x coodinate is the difference between the current x coordinate minus the initial x coordinate
   * @return the relative x coordinate
   */
  public int getRelativeX() {
    return getX() - initialX;
  }

  /**
   * The relative y coodinate is the difference between the current y coordinate minus the initial y coordinate
   * @return the relative y coordinate
   */
  public int getRelativeY() {
    return getY() - initialY;
  }

  /**
   * The relative Direction is UP, if initial and current Direction are equal;
   * RIGHT, if current Direction is 90° to the right from initial;
   * DOWN, if current is vis-à-vis from the initial Direction;
   * otherwise LEFT
   *
   * @return The relative Direction
   */
  public Direction getRelativeDirection() {
    int rel = (getDirection().ordinal() - initialDirection.ordinal() + 4) % 4;
    return Direction.values()[rel];
  }

  /**
   * The amount of the relative number of coins is calculated by subtracting the current number of coins from the initial number of coins
   * @return the relative number of coins
   */
  public int getRelativeNumberOfCoins() {
    return getNumberOfCoins() - initialNumberOfCoins;
  }

  /**
   * Adds the @Param relativeX with the initial x coordinate
   * Sets the result as relativeX after calling this Method
   * But only if the result is a valid number within the World
   */
  public void setRelativeX(int relativeX) {
    int result = initialX + relativeX;
    if (result < 0 || World.getWidth() <= result) {
      crash();
    } else {
      setX(result);
    }
  }

  /**
   * Adds the @param relativeY with the initial y coordinate
   * Sets the result as relativeY after calling this Method
   * But only if the result is a valid number within the World
   */
  public void setRelativeY(int relativeY) {
    int result = initialY + relativeY;
    if (result < 0 || World.getHeight() <= result) {
      crash();
    } else {
      setY(result);
    }
  }

  /**
   * Put as many coins, so that a call of getRelativeNumberOfCoins() directly afterwards returns relativeNumberOfCoins.
   * But don't do it, if the new numberOfCoins is not in [0, currentNumberOfCoins]
   */
  public void setRelativeNumberOfCoins(int relativeNumberOfCoins) {
    int result = initialNumberOfCoins + relativeNumberOfCoins;
    if (result < 0 || getNumberOfCoins() < result) {
      crash();
    } else {
      final int putCoins = getNumberOfCoins() - result;
      for ( int i = 0; i < putCoins; i++) {
        putCoin();
      }
    }
  }

  /**
   * Turn the Robot so, so that a call of getRelativeDirection() directly afterwards returns relativeDirection.
   */
  public void setRelativeDirection(Direction relativeDirection) {
    int result = (initialDirection.ordinal() + relativeDirection.ordinal()) % 4;
    int numOfTurns = 4 - (4 + result - getDirection().ordinal()) % 4;
    for (int i = 0; i < numOfTurns; i++) {
      turnLeft();
    }
  }

}
