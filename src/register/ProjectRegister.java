package register;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Declaration;
import registerEvent.ProjectRegisterEvent;

import java.io.IOException;

public class ProjectRegister {

    private final Declaration declaration = new Declaration();

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

    public Stage stage = declaration.getStage();

    public void projectRegister() {

        ProjectRegisterEvent projectRegisterEvent = new ProjectRegisterEvent();

        lblTitle.setText("Title");
        lblAdvisorID.setText("Advisor ID");
        lblAdvisorName.setText("Advisor Name");
        lblDescription.setText("Description");
        lblFieldOfStudy.setText("Field Of Study");
        lblQualification.setText("Qualification");
        lblSpecialization.setText("Specialization");
        lblGroupID.setText("Group ID");
        btnSave.setText("Save");

        GridPane gridPane = declaration.getGridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.addColumn(0, lblTitle, lblDescription, lblFieldOfStudy,
                lblAdvisorName, lblAdvisorID, lblQualification, lblSpecialization, lblGroupID);

        gridPane.addColumn(1, tfTitle, tfDescription, tfFieldOfStudy,
                tfAdvisorName, tfAdvisorID, cbQualification, tfSpecialization, tfGroupID, btnSave);

        ScrollPane sp = new ScrollPane(gridPane);


        cbQualification.getItems().addAll("graduate assistant", "lecture", "assistant professor");
        cbQualification.setValue("graduate assistant");

        GridPane.setHalignment(btnSave, HPos.RIGHT);


        btnSave.setOnAction(value -> {
            try {
                projectRegisterEvent.projectRegisterSave(this);
            } catch (IOException ignored) {
            }
        });

        Scene scene = new Scene(sp);
        stage.setTitle("Project Register");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
