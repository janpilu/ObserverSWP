package org.example;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.lang.module.FindException;
import java.util.ArrayList;

public class MainController{

    Mediator mediator;
    ViewModel vm;

    @FXML
    ListView<ListCell> listView;
    @FXML
    Button edit;
    @FXML
    Button add;
    @FXML
    Button delete;

    @FXML
    public void initialize(){
        vm = new ViewModel();
        mediator = new Mediator(listView,edit,delete,add);
        vm.add(mediator);

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> vm.alert());
    }


    public void edit(ActionEvent actionEvent) {
    }

    public void add(ActionEvent actionEvent) {
        ListCell entry = new ListCell();
        int index = listView.getItems().size()+1;
        entry.setText(index+"");
        listView.getItems().add(entry);
    }

    public void delete(ActionEvent actionEvent) {
        ObservableList selected = listView.getSelectionModel().getSelectedItems();
        listView.getItems().removeAll(selected);
    }
}
