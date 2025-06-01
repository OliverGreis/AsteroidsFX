package dk.sdu.mmmi.cbse.ScoreMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoreMicroService{

    private int score = 0;



    public static void main(String[] args) {
        SpringApplication.run(ScoreMicroService.class,args);
    }


    @GetMapping("/addScore")
    public void addScore(@RequestParam(value = "value") int value) {
        score = score + value;
    }

    @GetMapping("/getScore")
    public int addScore() {
        return score;
    }
}
