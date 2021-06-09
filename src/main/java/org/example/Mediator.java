package org.example;

import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.example.interfaces.Observer;

public class Mediator implements Observer {
    ListView<ListCell> listView;
    Button edit;
    Button delete;
    Button add;

    public Mediator(ListView<ListCell> listView, Button edit, Button delete, Button add) {
        this.listView = listView;
        this.edit = edit;
        this.delete = delete;
        this.add = add;
    }

    @Override
    public void refresh(){
        int amount = listView.getSelectionModel().getSelectedItems().size();
        checkEdit(amount,edit);
        checkAdd(amount,add);
        checkDelete(amount,delete);
    }

    public void checkEdit(int amount,Button button){
        if(amount == 1){
            button.setDisable(false);
        } else {
            button.setDisable(true);
        }
    }
    public void checkAdd(int amount,Button button){
        if(amount == 0){
            button.setDisable(false);
        } else {
            button.setDisable(true);
        }
    }
    public void checkDelete(int amount,Button button){
        if(amount > 0){
            button.setDisable(false);
        } else {
            button.setDisable(true);
        }
    }
}
