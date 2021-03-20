package delete;

import deleteEvent.DeleteEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Declaration;
import searchEvent.SearchEvent;

import java.io.IOException;

public class StudentDelete {
    Declaration declaration = new Declaration();

    public TextField tfSearch = declaration.getTextField();
    public TextField tfDelete = declaration.getTextField();

    public Button btnSearch = declaration.getButton();
    public Button btnDelete = declaration.getButton();

    public Stage stage = declaration.getStage();

    public void studentDelete() {
        tfDelete.clear();
        tfSearch.clear();
        final String[] text = new String[1];
        SearchEvent searchEvent = new SearchEvent();
        DeleteEvent deleteEvent = new DeleteEvent();
        GridPane gridPane = declaration.getGridPane();
        gridPane.addRow(0, tfSearch, btnSearch, tfDelete, btnDelete);
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);

        btnSearch.setText("Search");
        btnDelete.setText("Delete");

        btnSearch.setOnAction(value -> {
            try {
                text[0] = searchEvent.search(tfSearch.getText(), "StudentRegister.txt");
                tfDelete.setText(text[0]);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        btnDelete.setOnAction(value -> {
            try {
                deleteEvent.delete(text[0], tfSearch.getText(), stage, "StudentRegister.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        stage.setTitle("Search");
        stage.setScene(new Scene(gridPane));
        stage.setResizable(false);
        stage.show();

    }
}
