package Game.Main;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainView newMainView = new MainView();
        MainViewController mvc = new MainViewController(newMainView);

    }
}