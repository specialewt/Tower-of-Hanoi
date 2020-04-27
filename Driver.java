import model.*;
import view.*;
import controller.*;


public class Driver
{
    public static void main(String []args)
    {
        GameFrame localGF = new GameFrame();
        HomePanel homeScreen = new HomePanel(localGF.getFrameWidth(),localGF.getFrameHeight());
        BestScores newBestScores = new BestScores(5,"model/.TOHSaveFile.txt");
        MainController gameController = new MainController(homeScreen,localGF, newBestScores);

        gameController.startGame();
    }

}
