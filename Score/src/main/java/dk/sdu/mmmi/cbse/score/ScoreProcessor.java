package dk.sdu.mmmi.cbse.score;

import dk.sdu.mmmi.cbse.common.services.ScoringService;

public class ScoreProcessor implements ScoringService {

int Score;

@Override
public void addScore(int value){
    Score = Score + value;
}

@Override
public int getScore(){
    return Score;
}

}
