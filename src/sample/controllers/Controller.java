package sample.controllers;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;
import sample.server.DatabaseHandler;
import sample.POJO.User;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button close;

    @FXML
    private TextField cod;

    @FXML
    private Button code;

    @FXML
    private TextField number;

    @FXML
    private Button open;

    @FXML
    private PasswordField password;

    @FXML
    void initialize() {
        String simCode = "qwertyuiopasdfghjkzxcvbnmQWERTYUOASDFGHJKLZXCVBNM1234567890!@#$%^&*>?";
        Random random = new Random();
        char sim;
        String codes = "";
        int index;
        for (int i = 0; i < 4; i++){
            index = random.nextInt(simCode.length());
            sim = simCode.charAt(index);
            codes += sim;}

        String finalCodes = codes;
        code.setOnAction(event -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Сообщение");
            alert.setHeaderText(finalCodes);
            alert.showAndWait();
                });
        open.setOnAction(actionEvent -> {
            String numberText = number.getText().trim();
            String passwordText = password.getText().trim();
            String codeText = cod.getText().trim();

            if (!numberText.equals("") && !passwordText.equals("") && !codeText.equals("")) {
                if(codeText.equals(finalCodes)){
                    try {
                        loginUser(numberText, passwordText);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Ошибка");
                    alert.setHeaderText("Неправилный кот!");
                    alert.setContentText("Повторите попитку позже!");
                    alert.showAndWait();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Поля не заполнены!");
                alert.setContentText("Заполните все поля!");
                alert.showAndWait();


            }
        });

        close.setOnAction(event -> {
                    number.setText("");
                    password.setText("");
                    cod.setText("");
                });

    }

    private void loginUser(String loginText, String passwordText) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setNumber(loginText);
        user.setPassword(passwordText);
        ResultSet resultAuto = dbHandler.getUserLoginAndPassword(user);
        if(resultAuto.next()){
            open.getScene().getWindow().hide();
             Main.OpenIcon("/sample/resources/window/userWindow.fxml");
        }
        else {Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Пользователь не найден!");
        alert.setContentText("Нажмине <Ок>, затем попробуйте сново, возможно вы где-то допустили ошибку.");

        alert.showAndWait();}
    }


}
