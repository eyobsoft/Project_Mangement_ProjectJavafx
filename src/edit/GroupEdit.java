package edit;

import editEvent.GroupEditEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Declaration;
import searchEvent.SearchEvent;

import java.io.*;

public class GroupEdit {
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
                found[0] = searchEvent.search(tfSearch.getText(), "GroupRegister.txt");
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

    public Label lblGroupName = declaration.getLabel();
    public Label lblGroupID = declaration.getLabel();
    public Label lblStudentID = declaration.getLabel();

    public TextField tfGroupName = declaration.getTextField();
    public TextField tfGroupID = declaration.getTextField();
    public TextField tfStudentId1 = declaration.getTextField();
    public TextField tfStudentId2 = declaration.getTextField();
    public TextField tfStudentId3 = declaration.getTextField();


    public Button btnSave = declaration.getButton();

    public Stage stage1 = declaration.getStage();

    public void edit(String s) throws IOException {
        if (s.equalsIgnoreCase("Found")) {
            GroupEditEvent groupEditEvent = new GroupEditEvent();

            GridPane gridPane = declaration.getGridPane();
            gridPane.setPadding(new Insets(15));
            gridPane.setHgap(15);
            gridPane.setVgap(15);

            String[] txt = search1(tfSearch.getText());

            lblGroupName.setText("Group Name");
            lblGroupID.setText("Group ID");
            lblStudentID.setText("Student IDs");

            btnSave.setText("Save");

            gridPane.addColumn(0, lblGroupName, lblGroupID, lblStudentID);
            gridPane.addColumn(1, tfGroupName, tfGroupID, tfStudentId1, tfStudentId2, tfStudentId3, btnSave);

            GridPane.setHalignment(btnSave, HPos.RIGHT);

            btnSave.setOnAction(value -> {
                try {
                    groupEditEvent.groupEdit(this, tfSearch.getText());
                } catch (FileNotFoundException ignored) {
                }
            });

            tfGroupName.setText(txt[1]);
            tfGroupID.setText(txt[0]);
            tfStudentId1.setText(txt[2]);
            if (!(txt[3].equalsIgnoreCase("null"))) {
                tfStudentId2.setText("");
            }
            if (!(txt[4].equalsIgnoreCase("null"))) {
                tfStudentId3.setText("");
            }

            stage1.setScene(new Scene(gridPane));
            stage1.setTitle("Group Register");
            stage1.setResizable(false);
            stage1.show();
        }

    }

    private String[] search1(String text) throws IOException {

        String line;
        String[] txt = new String[7];
        File file = new File("GroupRegister.txt");
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
