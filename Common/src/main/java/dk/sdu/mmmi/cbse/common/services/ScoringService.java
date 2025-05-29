package dk.sdu.mmmi.cbse.common.services;

public interface ScoringService {

 /**
  *
  *  <p><strong>Description:</strong></p>
  *  Adds specified value to the current score.
  *
  * <p><strong>Preconditions:</strong></p>
  * <ul>
  *   <li>{@code value} is not {@code null} and > 0.</li>
  * </ul>
  *
  * <p><strong>Postconditions:</strong></p>
  *    <ul>
  *      <li>Score has increased with {@code value}</li>
  *    </ul>
  *
  * @param value is an integer value to be added to the score
  *
  **/
 void addScore(int value);

 /**
  *  <p><strong>Description:</strong></p>
  *  returns the current score
  *
  * <p><strong>Preconditions:</strong></p>
  * <ul>
  *   <li>{@code Score} is not {@code null} and >= 0.</li>
  * </ul>
  *
  * <p><strong>Postconditions:</strong></p>
  *    <ul>
  *      <li>Returns an integer value representing game Score</li>
  *    </ul>
  *
  *  @return the current score as a non-negative integer
  *
  **/
 int getScore();
}
