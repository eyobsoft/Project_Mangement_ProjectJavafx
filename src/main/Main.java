package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainInterface mainInterface = new MainInterface();

        TabPane tabPane = mainInterface.tabPaneMethod();

        primaryStage.setTitle("Final Project Management System");
        primaryStage.setScene(new Scene(tabPane));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
