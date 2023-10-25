package com.example.grant20;

import com.example.grant20.models.PasswordHashing;
import com.example.grant20.models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage s;
    private static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        s = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        loader = fxmlLoader;
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }

    public static FXMLLoader getLoader() {
        return loader;
    }

    public static void changeMainPage(String path) { //сменить текущую сцену
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(path));
        try {
            Stage stage = s;
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            loader = fxmlLoader;
        } catch (IOException e) {
            System.out.println("Trouble with page creation");
            throw new RuntimeException(e);
        }
    }
    public static void changeMainPage(String path, Object controller) { //сменить текущую сцену
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(path));
        try {
            Stage stage = s;
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            loader = fxmlLoader;
        } catch (IOException e) {
            System.out.println("Trouble with page creation");
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        launch();
    }


}