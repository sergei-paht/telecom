package sample.controllers;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sample.POJO.tableEvent;
import sample.POJO.tableWindowUsers;
import sample.POJO.tableWorker;

public class WindowUsers {
    private ObservableList<tableWindowUsers> user = FXCollections.observableArrayList();
    private ObservableList<tableEvent> events = FXCollections.observableArrayList();
    private ObservableList<String> workers = FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private ImageView avatar;

    @FXML
    private RadioButton rbActive;

    @FXML
    private RadioButton rbInactive;

    @FXML
    private URL location;


    @FXML
    private ComboBox<String> listUsers;

    @FXML
    private Button abonents;

    @FXML
    private Label titleTable;

    @FXML
    private Button activs;

    @FXML
    private Button bulling;

    @FXML
    private Button controlDevices;

    @FXML
    private Button crm;

    @FXML
    private TableColumn<tableWindowUsers, String> fio;

    @FXML
    private Button help;

    @FXML
    private TableColumn<tableWindowUsers, String> licovShet;

    @FXML
    private TableColumn<tableWindowUsers, String> numTelef;

    @FXML
    private TableColumn<tableWindowUsers, String> officeUser;

    @FXML
    private Button prof;

    @FXML
    private TableColumn<tableWindowUsers, String> sercice;

    @FXML
    private TableView<tableWindowUsers> tableAdmin;

    @FXML
    private Button userSupport;

    @FXML
    private Button abonents1;

    @FXML
    private Button activs1;

    @FXML
    private Pane bgPane;

    @FXML
    private Button bulling1;

    @FXML
    private Button controlDevices1;

    @FXML
    private Button crm1;

    @FXML
    private Pane smPane;

    @FXML
    private Button userSupport1;

    @FXML
    private TableColumn<tableEvent, String> event;

    @FXML
    private TableView<tableEvent> tableEventTable;

    @FXML
    void initialize() {
        avatar.setImage(new Image("/sample/resources/pictures/???????? ?????? ????????????????.jpg"));
        initWorker();

        smPane.setVisible(false);
        bgPane.setVisible(true);

// ??????????????????????
        abonents.setOnAction(event -> {
            titleTable.setText("????????????????");
        });
        controlDevices.setOnAction(event -> {
            titleTable.setText("???????????????????? ??????????????????????????");
        });
        activs.setOnAction(event -> {
            titleTable.setText("????????????");
        });
        bulling.setOnAction(event -> {
            titleTable.setText("??????????????");
        });
        userSupport.setOnAction(event -> {
            titleTable.setText("?????????????????? ??????????????????????????");
        });
        crm.setOnAction(event -> {
            titleTable.setText("CRM");
        });

// ????????????????????
        abonents1.setOnAction(event -> {
            titleTable.setText("????????????????");
        });
        controlDevices1.setOnAction(event -> {
            titleTable.setText("???????????????????? ??????????????????????????");
        });
        activs1.setOnAction(event -> {
            titleTable.setText("????????????");
        });
        bulling1.setOnAction(event -> {
            titleTable.setText("??????????????");
        });
        userSupport1.setOnAction(event -> {
            titleTable.setText("?????????????????? ??????????????????????????");
        });
        crm1.setOnAction(event -> {
            titleTable.setText("CRM");
        });
        prof.setOnAction(event -> {
            bgPane.setVisible(false);
            smPane.setVisible(true);
        });
        help.setOnAction(event -> {
            bgPane.setVisible(true);
            smPane.setVisible(false);
        });

        initData();
        fio.setCellValueFactory(new PropertyValueFactory<tableWindowUsers, String>("fio"));
        numTelef.setCellValueFactory(new PropertyValueFactory<tableWindowUsers, String>("numTelef"));
        licovShet.setCellValueFactory(new PropertyValueFactory<tableWindowUsers, String>("licovShet"));
        sercice.setCellValueFactory(new PropertyValueFactory<tableWindowUsers, String>("service"));
        // ?????????????????? ?????????????? ??????????????
        tableAdmin.setItems(user);

        initEvent();
        event.setCellValueFactory(new PropertyValueFactory<tableEvent, String>("event"));

        // ?????????????????? ?????????????? ??????????????
        tableEventTable.setItems(events);

        listUsers.setOnAction(event -> {
            try {
                dbConnection = getDbConnection();
                ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM `???????????????????? ??????`");
                while (resSet.next()) {
                    if(resSet.getString("????????????????????").equals(listUsers.getValue())){
                        String idPicture = resSet.getString("?????????? ????????????????????");
                        avatar.setImage(new Image("/sample/resources/pictures/" + idPicture + ".jpg"));
                    }
                    if(resSet.getString("????????????????????").equals(listUsers.getValue())){
                        String idRole = resSet.getString("??????????????????");
                        if(Objects.equals(idRole,"???????????????????????? ???? ???????????? ?? ??????????????????")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(false);
                            activs.setVisible(false);
                            bulling.setVisible(true);
                            userSupport.setVisible(false);
                            crm.setVisible(true);
                        }
                        if(Objects.equals(idRole,"???????????????????????? ???????????? ?????????????????????? ??????????????????")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(true);
                            activs.setVisible(false);
                            bulling.setVisible(false);
                            userSupport.setVisible(true);
                            crm.setVisible(true);
                        }
                        if(Objects.equals(idRole,"???????????????????? ???? (???????????????? ??????????????)")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(true);
                            activs.setVisible(false);
                            bulling.setVisible(false);
                            userSupport.setVisible(true);
                            crm.setVisible(true);
                        }
                        if(Objects.equals(idRole,"??????????????????")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(false);
                            activs.setVisible(true);
                            bulling.setVisible(true);
                            userSupport.setVisible(false);
                            crm.setVisible(false);
                        }
                        if(Objects.equals(idRole,"???????????????? ???? ????????????????")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(true);
                            activs.setVisible(true);
                            bulling.setVisible(true);
                            userSupport.setVisible(true);
                            crm.setVisible(true);
                        }
                        if(Objects.equals(idRole,"?????????????????????? ????????????????????????")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(true);
                            activs.setVisible(true);
                            bulling.setVisible(false);
                            userSupport.setVisible(false);
                            crm.setVisible(true);
                        }
                        if(Objects.equals(idRole,"???????????????? ???? ???????????? ?? ??????????????????")){
                            abonents.setVisible(true);
                            controlDevices.setVisible(false);
                            activs.setVisible(false);
                            bulling.setVisible(false);
                            userSupport.setVisible(false);
                            crm.setVisible(true);
                        }
                    }

                }
                listUsers.getItems().addAll(workers);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        });

    }

    private void initWorker() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT ???????????????????? FROM `???????????????????? ??????`");
            while (resSet.next()) {
                workers.add(resSet.getString("????????????????????"));
            }
            listUsers.getItems().addAll(workers);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initEvent() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM `???????????????????? ?????? ??????????????????????`");
            while (resSet.next()) {
                events.add(new tableEvent(resSet.getString("??????????????")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initData() {
        try {
            dbConnection = getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM ????????????????");
            while (resSet.next()) {
                user.add(new tableWindowUsers(resSet.getString("??????"), resSet.getString("?????????? ????????????????"),
                        resSet.getString("?????????????? ????????"), resSet.getString("????????????")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + "localHost" + ":" + "3306" + "/" + "YP";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "root", "1234");
        return dbConnection;
    }

}
