package main;

import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Declaration {

    public Tab getTab() {
        return new Tab();
    }

    public Button getButton() {
        return new Button();
    }

    public TextField getTextField() {
        return new TextField();
    }

    public TextArea getTextArea() {
        return new TextArea();
    }

    public TabPane getTabPane() {
        return new TabPane();
    }

    public Label getLabel() {
        return new Label();
    }

    public ComboBox getComboBox() {
        return new ComboBox();
    }

    public RadioButton getRadioButton() {
        return new RadioButton();
    }

    public ToggleGroup getToggleGroup() {
        return new ToggleGroup();
    }

    public FlowPane getFlowPane() {
        return new FlowPane();
    }

    public GridPane getGridPane() {
        return new GridPane();
    }

    public Stage getStage(){
        return new Stage();
    }

}
