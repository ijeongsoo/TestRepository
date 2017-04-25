/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam22;

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
    private ListView<Food> listView;
    @FXML
    private Button btn1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        btn1.setOnAction((event) -> {
            Platform.exit();
        });
        
        
        listView.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>() {
            @Override
            public ListCell<Food> call(ListView<Food> param) {
                ListCell<Food> listCell = new ListCell<Food>(){
                    @Override
                    protected void updateItem(Food item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty) return;
                        try {
                            
                            //셀에 들어갈 컨테이너 생성
                            Parent parent = FXMLLoader.load(getClass().getResource("item.fxml"));
                            ImageView foodImage = (ImageView) parent.lookup("#image");
                            Label foodName = (Label) parent.lookup("#name");
                            ImageView foodScore = (ImageView) parent.lookup("#score");
                            Label foodDescription = (Label) parent.lookup("#description");
                            
                            
                            foodImage.setImage(new Image(getClass().getResource("images/"+item.getImage()).toString()));
                            foodName.setText(item.getName());
                            foodScore.setImage(new Image(getClass().getResource("images/star"+item.getScore()+".png").toString()));
                            foodDescription.setText(item.getDiscription());
                            
                            //셀의 내용으로 설정
                            setGraphic(parent);
                        } catch (IOException ex) { ex.printStackTrace();}
                        
                        
                    }
                    
                };
                return listCell;
            }
        });
        
        
        //선택 속성 감시
        /*listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
            @Override
            public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
                System.out.println(newValue.getName());
                System.out.println(newValue.getImage());
                System.out.println(newValue.getDiscription());
                System.out.println(newValue.getScore());
                
            }
        });*/
        
        listView.setOnMouseClicked((event) -> {
            ObservableList<Food> list;
            Food food = listView.getSelectionModel().getSelectedItem();
            //list=listView.getSelectionModel().getSelectedItems();
            //System.out.println(list.get(0).getName());
            System.out.println(food.getName());
        });
        
        
        
        
        //데이터 셋팅
        ObservableList<Food> value = FXCollections.observableArrayList();
        value.add(new Food("food01.png", "삼겹살", 5,"맛있는 삼겹살"));
        value.add(new Food("food02.png", "장어 양념구이", 2,"맛있는 장어 양념구이"));
        value.add(new Food("food03.png", "장어 소금구이", 1,"맛있는 장어 소금구이"));
        value.add(new Food("food04.png", "육회 비빔밥", 8,"맛있는 비빔밥"));
        value.add(new Food("food05.png", "복음밥", 4,"맛있는 복음밥"));
        value.add(new Food("food06.jpg", "떡볶이", 10,"맛있는 떡뽂이"));

        

        listView.setItems(value);
        
        
        
        
        
        
    }    
    
}
