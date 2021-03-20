package edit;

import editEvent.StudentEditEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Declaration;
import searchEvent.SearchEvent;

import java.io.*;

public class StudentEdit {

    Declaration declaration = new Declaration();
    public Stage stage = declaration.getStage();
    public TextField tfSearch = declaration.getTextField();
    public TextField tfEdit = declaration.getTextField();

    public Button btnSearch = declaration.getButton();
    public Button btnEdit = declaration.getButton();

    public void search() {
        tfSearch.clear();
        tfEdit.clear();
        final String[] found = new String[1];
        SearchEvent searchEvent = new SearchEvent();
        GridPane gridPane = declaration.getGridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);

        btnEdit.setText("Edit");
        btnSearch.setText("Search");

        btnSearch.setOnAction(value -> {
            try {
                found[0] = searchEvent.search(tfSearch.getText(), "StudentRegister.txt");
                tfEdit.setText(found[0]);
            } catch (IOException ignored) {
            }
        });

        btnEdit.setOnAction(value -> {
            try {
                edit(found[0]);
            } catch (IOException ignored) {
            }
        });

        gridPane.addRow(0, tfSearch, btnSearch, tfEdit, btnEdit);

        stage.setTitle("Search");
        stage.setScene(new Scene(gridPane));
        stage.setResizable(false);
        stage.show();

    }

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

    public Stage stage1 = new Stage();

    public void edit(String s) throws IOException {
        if (s.equalsIgnoreCase("Found")) {
            StudentEditEvent studentEditEvent = new StudentEditEvent();
            lblStudentName.setText("Student Name");
            lblStudentID.setText("Student ID");
            lblDepartment.setText("Department");
            lblGender.setText("Gender");
            lblCGPA.setText("CGPA");
            lblYear.setText("Year");
            btnSave.setText("Save");
            rbMale.setText("Male");
            rbFemale.setText("Female");

            String[] txt = search1(tfSearch.getText());

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
                    studentEditEvent.studentEdit(this, tfSearch.getText());
                } catch (FileNotFoundException ignored) {
                }
            });

            tfStudentName.setText(txt[1]);
            tfStudentID.setText(txt[0]);
            if ("Male".equalsIgnoreCase(txt[2])) {
                rbMale.setSelected(true);
            } else {
                rbFemale.setSelected(true);
            }

            tfDepartment.setText(txt[3]);
            tfYear.setText(txt[4]);
            tfCGPA.setText(txt[5]);

            Scene scene = new Scene(gridPane);
            stage1.setTitle("Student Register");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();

        }
    }

    public String[] search1(String text) throws IOException {

        String line;
        String[] txt = new String[7];
        File file = new File("StudentRegister.txt");
        FileReader file1 = new FileReader(file);
        BufferedReader scanner = new BufferedReader(file1);
        while ((line = scanner.readLine()) != null) {
            txt = line.split(",");
            if (txt[0].trim().equalsIgnoreCase(text)) {
                return txt;
            }
        }
        return txt;
    }
}
