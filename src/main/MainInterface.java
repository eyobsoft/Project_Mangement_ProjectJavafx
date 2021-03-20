package main;

import delete.GroupDelete;
import delete.ProjectDelete;
import delete.StudentDelete;
import edit.GroupEdit;
import edit.ProjectEdit;
import edit.StudentEdit;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.FlowPane;
import registerEvent.GroupRegisterEvent;
import registerEvent.ProjectRegisterEvent;
import registerEvent.StudentRegisterEvent;


public class MainInterface {

    public TabPane tabPaneMethod() {

        Declaration declaration = new Declaration();

        TabPane tabPane = declaration.getTabPane();

        Tab tabRegister = declaration.getTab();
        tabRegister.setText("Click here to Register");
        tabRegister.setContent(registerContent());

        Tab tabEdit = declaration.getTab();
        tabEdit.setText("Click here to Edit");
        tabEdit.setContent(editContent());

        Tab tabDelete = declaration.getTab();
        tabDelete.setText("Click here to Delete");
        tabDelete.setContent(deleteContent());

        tabPane.getTabs().addAll(tabRegister, tabEdit, tabDelete);

        return tabPane;
    }

    public FlowPane deleteContent() {
        Declaration declaration = new Declaration();
        StudentDelete studentDelete = new StudentDelete();
        GroupDelete groupDelete = new GroupDelete();
        ProjectDelete projectDelete = new ProjectDelete();

        Button btnProject = declaration.getButton();
        btnProject.setText("Project");
        btnProject.setMinWidth(90);
        btnProject.setOnAction(value ->projectDelete.projectDelete());

        Button btnGroup = declaration.getButton();
        btnGroup.setText("Group");
        btnGroup.setMinWidth(90);
        btnGroup.setOnAction(value -> groupDelete.groupDelete());

        Button btnStudent = declaration.getButton();
        btnStudent.setText("Student");
        btnStudent.setMinWidth(90);
        btnStudent.setOnAction(value -> studentDelete.studentDelete());

        FlowPane flowPane = declaration.getFlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setPadding(new Insets(15));
        flowPane.setVgap(15);
        flowPane.getChildren().addAll(btnProject, btnGroup, btnStudent);

        return flowPane;
    }

    public FlowPane registerContent() {
        Declaration declaration = new Declaration();
        ProjectRegisterEvent projectRegisterEvent = new ProjectRegisterEvent();
        StudentRegisterEvent studentRegisterEvent = new StudentRegisterEvent();
        GroupRegisterEvent groupRegisterEvent = new GroupRegisterEvent();

        Button btnProject = declaration.getButton();
        btnProject.setText("Project");
        btnProject.setMinWidth(90);
        btnProject.setOnAction(e -> projectRegisterEvent.projectRegisterEvent());

        Button btnGroup = declaration.getButton();
        btnGroup.setText("Group");
        btnGroup.setMinWidth(90);
        btnGroup.setOnAction(e -> groupRegisterEvent.groupRegisterEvent());

        Button btnStudent = declaration.getButton();
        btnStudent.setText("Student");
        btnStudent.setMinWidth(90);
        btnStudent.setOnAction(e -> studentRegisterEvent.studentRegisterEvent());

        FlowPane flowPane = declaration.getFlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setPadding(new Insets(15));
        flowPane.setVgap(15);
        flowPane.getChildren().addAll(btnProject, btnGroup, btnStudent);

        return flowPane;
    }

    public FlowPane editContent() {
        StudentEdit studentEdit = new StudentEdit();
        ProjectEdit projectEdit = new ProjectEdit();
        Declaration declaration = new Declaration();
        GroupEdit groupEdit = new GroupEdit();

        Button btnProject = declaration.getButton();
        btnProject.setText("Project");
        btnProject.setMinWidth(90);
        btnProject.setOnAction(value -> projectEdit.search());

        Button btnGroup = declaration.getButton();
        btnGroup.setText("Group");
        btnGroup.setMinWidth(90);
        btnGroup.setOnAction(value -> groupEdit.search());

        Button btnStudent = declaration.getButton();
        btnStudent.setText("Student");
        btnStudent.setMinWidth(90);
        btnStudent.setOnAction(value -> studentEdit.search());

        FlowPane flowPane = declaration.getFlowPane();
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setPadding(new Insets(15));
        flowPane.setVgap(15);
        flowPane.getChildren().addAll(btnProject, btnGroup, btnStudent);

        return flowPane;
    }
}
