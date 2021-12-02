package com.example.registrationform;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage){
        stage.setTitle("Registration Form");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(40);
        grid.setVgap(20);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Text sceneTitle = new Text("Login");
        sceneTitle.setFont(Font.font("Roboto", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("Email Address: ");
        grid.add(userName, 0, 1);

        TextField userEmailField = new TextField();
        grid.add(userEmailField, 1, 1);

        Label pw = new Label("Password: ");
        grid.add(pw, 0, 2);

        PasswordField userPasswordField = new PasswordField();
        grid.add(userPasswordField, 1, 2);

        Button button = new Button("Sign in");
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(button);
        grid.add(hBox, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        button.setOnAction(e -> {
            Email userEmail = new Email(userEmailField.getText());
            Password userPassword = new Password((userPasswordField.getText()));
            actiontarget.setFill(Color.DARKCYAN);
            actiontarget.setText("email: " + userEmail.getEmail() + " password: " + userPassword.getPassword());
            if (userEmail.getEmail().equals("Invalid email") || userPassword.getPassword().equals("Invalid password")) {
                showUnsuccessfulLoginScreen();
            } else {
                showSuccessfulLoginScreen();
            }
        });

        Scene scene = new Scene(grid, 420, 340);
        stage.setScene(scene);
        stage.show();

    }

    public void showSuccessfulLoginScreen() {
        Stage stage = new Stage();

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));

        vBox.setAlignment(Pos.CENTER);

        Label label = new Label("Login Successful");
        label.setFont(Font.font("Roboto", FontWeight.NORMAL, 20));

        vBox.getChildren().add(label);

        Scene scene = new Scene(vBox, 250, 150);
        stage.setScene(scene);
        stage.show();
    }

    public void showUnsuccessfulLoginScreen() {
        Stage stage = new Stage();

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));

        vBox.setAlignment(Pos.CENTER);

        Label label = new Label("Login Unsuccessful");
        label.setFont(Font.font("Roboto", FontWeight.NORMAL, 20));

        vBox.getChildren().add(label);

        Scene scene = new Scene(vBox, 250, 150);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}