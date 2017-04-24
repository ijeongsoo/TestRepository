/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.homework03;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author ijeongsu
 */
public class RootController implements Initializable {

    @FXML
    private ListView<Member> listView;
    @FXML
    private TableView<Member> tableView;
    @FXML
    private ImageView image;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        listView.setCellFactory(new Callback<ListView<Member>, ListCell<Member>>() {
            @Override
            public ListCell<Member> call(ListView<Member> param) {
                ListCell<Member> listCell = new ListCell<Member>(){
                    @Override
                    protected void updateItem(Member item, boolean empty) {
                        super.updateItem(item, empty); 
                        if(empty) return;
                        try {
                            Parent parent = FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView image = (ImageView) parent.lookup("#image");
                            Label lbName =(Label)parent.lookup("#lbName");
                            Label lbID = (Label) parent.lookup("#lbID");
                            ImageView grade = (ImageView) parent.lookup("#grade");
                            
                            image.setImage(new Image(getClass().getResource("images/"+item.getImage()).toString()));
                            lbName.setText(item.getName());
                            lbID.setText(item.getId());
                            grade.setImage(new Image(getClass().getResource("images/star"+item.getGrade()+".png").toString()));
                            
                            setGraphic(parent);

                        } catch (IOException ex) {
                        }
                    }
                    
                  
                };
                return listCell;
            }
        });
        
        ObservableList<Member> list = FXCollections.observableArrayList();
        Member member1 = new Member("member01.png", "aaa", "이정수", 10, "남자",  20, "안녕하세요 이정수입니다");
        Member member2 = new Member("member02.png", "bbb", "김보현", 2, "남자",  24, "안녕하세요 김보현입니다");
        Member member3 = new Member("member03.png", "ccc", "강현규", 8, "남자",  26, "안녕하세요 강현규 입니다");
        list.add(member1);
        list.add(member2);
        list.add(member3);
        
        listView.setItems(list);
        
        TableColumn t0 = tableView.getColumns().get(0);
        TableColumn t1 = tableView.getColumns().get(1);
        TableColumn t2 = tableView.getColumns().get(2);
        TableColumn t3 = tableView.getColumns().get(3);
        TableColumn t4 = tableView.getColumns().get(4);
        
        t0.setCellValueFactory(new PropertyValueFactory("id"));
        t1.setCellValueFactory(new PropertyValueFactory("name"));
        t2.setCellValueFactory(new PropertyValueFactory("gender"));
        t3.setCellValueFactory(new PropertyValueFactory("age"));
        t4.setCellValueFactory(new PropertyValueFactory("comments"));
        
        ObservableList<Member> tList = FXCollections.observableArrayList();
        tList.add(member1);
        tList.add(member2);
        tList.add(member3);
        
        tableView.setItems(tList);
        
        
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                tableView.getSelectionModel().select(newValue.intValue());
                tableView.scrollTo(newValue.intValue());
            }
        });
        
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Member>() {
            @Override
            public void changed(ObservableValue<? extends Member> observable, Member oldValue, Member newValue) {
                image.setImage(new Image(getClass().getResource("images/"+newValue.getImage()).toString()));
                System.out.println("Name:"+newValue.getName());
                System.out.println("ID:"+newValue.getId());
                System.out.println("Gender:"+newValue.getGender());
                System.out.println("Age:"+newValue.getAge());
                System.out.println("Grade:"+newValue.getGrade());
                System.out.println("Image:"+newValue.getImage());
                System.out.println("Comments:"+newValue.getComments());
            }
        });
        
        btnClose.setOnAction((event) -> {
            Platform.exit();
        });
        
        
    }    
    
}
