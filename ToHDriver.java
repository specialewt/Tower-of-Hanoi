import model.*;
import view.*;
import controller.*;


public class ToHDriver
{
    public static void main(String []args)
    {
        GameFrame localGF = new GameFrame();
        HomePanel homeScreen = new HomePanel(localGF.getFrameWidth(),localGF.getFrameHeight());
        BestScores newBestScores = new BestScores(5,"tesing/.exampleSaveFile.txt");
        MainController gameController = new MainController(homeScreen,localGF);

        gameController.startGame();
    }

}
