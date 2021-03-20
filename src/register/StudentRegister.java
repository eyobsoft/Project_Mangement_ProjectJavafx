package register;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Declaration;
import registerEvent.StudentRegisterEvent;

import java.io.IOException;

public class StudentRegister {
    Declaration declaration = new Declaration();

    public Label lblStudentName = declaration.getLabel();
    public Label lblStudentID = declaration.getLabel();
    public Label lblGender = declaration.getLabel();
    public Label lblDepartment = declaration.getLabel();
    public Label lblYear = declaration.getLabel();
    public Label lblCGPA = declaration.getLabel();

    public TextField tfStudentName = declaration.getTextField();
    public TextField tfStudentID = declaration.getTextField();

    public RadioButton rbMale = declaration.getRadioButton();
    public RadioButton rbFemale = declaration.getRadioButton();

    public ToggleGroup tg = declaration.getToggleGroup();

    public TextField tfDepartment = declaration.getTextField();
    public TextField tfYear = declaration.getTextField();
    public TextField tfCGPA = declaration.getTextField();

    public Button btnSave = declaration.getButton();

    public Stage stage = new Stage();


    public void studentRegister() {
        StudentRegisterEvent studentRegisterEvent = new StudentRegisterEvent();

        lblStudentName.setText("Student Name");
        lblStudentID.setText("Student ID");
        lblDepartment.setText("Department");
        lblGender.setText("Gender");
        lblCGPA.setText("CGPA");
        lblYear.setText("Year");
        btnSave.setText("Save");
        rbMale.setText("Male");
        rbFemale.setText("Female");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);
        rbFemale.setToggleGroup(tg);
        rbMale.setToggleGroup(tg);

        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(rbMale, rbFemale);

        gridPane.addColumn(0, lblStudentName, lblStudentID, lblGender, lblDepartment, lblYear, lblCGPA);
        gridPane.addColumn(1, tfStudentName, tfStudentID, vBox, tfDepartment, tfYear, tfCGPA, btnSave);
        rbMale.setSelected(true);

        GridPane.setHalignment(btnSave, HPos.RIGHT);

        btnSave.setOnAction(value -> {
            try {
                studentRegisterEvent.studentRegisterSaveEvent(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(gridPane);
        stage.setTitle("Student Register");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
