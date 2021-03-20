package edit;

import editEvent.ProjectEditEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Declaration;
import searchEvent.SearchEvent;

import java.io.*;

public class ProjectEdit {
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
                found[0] = searchEvent.search(tfSearch.getText(), "ProjectRegister.txt");
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

    public Button btnSave = declaration.getButton();
    public Label lblTitle = declaration.getLabel();
    public Label lblDescription = declaration.getLabel();
    public Label lblFieldOfStudy = declaration.getLabel();
    public Label lblAdvisorName = declaration.getLabel();
    public Label lblAdvisorID = declaration.getLabel();
    public Label lblQualification = declaration.getLabel();
    public Label lblSpecialization = declaration.getLabel();
    public Label lblGroupID = declaration.getLabel();


    public TextField tfTitle = declaration.getTextField();
    public TextField tfDescription = declaration.getTextField();
    public TextField tfFieldOfStudy = declaration.getTextField();
    public TextField tfAdvisorName = declaration.getTextField();
    public TextField tfAdvisorID = declaration.getTextField();
    public TextField tfSpecialization = declaration.getTextField();
    public ComboBox cbQualification = declaration.getComboBox();
    public TextField tfGroupID = declaration.getTextField();

    public Stage stage1 = declaration.getStage();

    public void edit(String s) throws IOException {
        if (s.equalsIgnoreCase("Found")) {
            ProjectEditEvent projectEditEvent = new ProjectEditEvent();
            btnSave.setText("Save");
            lblTitle.setText("Title");
            lblDescription.setText("Description");
            lblFieldOfStudy.setText("Field of Study");
            lblAdvisorName.setText("Advisor Name");
            lblAdvisorID.setText("Advisor ID");
            lblQualification.setText("Qualification");
            lblSpecialization.setText("Specialization");
            lblGroupID.setText("Group ID");
            cbQualification.getItems().addAll("graduate assistant", "lecture", "assistant professor");
            cbQualification.setValue("graduate assistant");

            String[] txt = search1(tfSearch.getText());

            GridPane gridPane = declaration.getGridPane();
            gridPane.setVgap(15);
            gridPane.setHgap(15);
            gridPane.setPadding(new Insets(15));

            gridPane.addColumn(0, lblTitle, lblDescription, lblFieldOfStudy,
                    lblAdvisorName, lblAdvisorID, lblQualification, lblSpecialization, lblGroupID);

            gridPane.addColumn(1, tfTitle, tfDescription, tfFieldOfStudy,
                    tfAdvisorName, tfAdvisorID, cbQualification, tfSpecialization, tfGroupID, btnSave);
            GridPane.setHalignment(btnSave, HPos.RIGHT);

            btnSave.setOnAction(value -> {
                try {
                    projectEditEvent.projectEdit(this, tfSearch.getText());
                } catch (FileNotFoundException ignored) {
                }
            });

            tfTitle.setText(txt[0]);
            tfDescription.setText(txt[1]);
            tfFieldOfStudy.setText(txt[2]);
            tfAdvisorName.setText(txt[3]);
            tfAdvisorID.setText(txt[4]);
            cbQualification.setValue(txt[5]);
            tfSpecialization.setText(txt[6]);
            tfGroupID.setText(txt[7]);

            stage1.setScene(new Scene(gridPane));
            stage1.setResizable(false);
            stage1.show();
        }
    }

    public String[] search1(String text) throws IOException {
        String line;
        String[] txt = new String[7];
        File file = new File("projectRegister.txt");
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
