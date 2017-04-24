/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch17.exam22;

/**
 *
 * @author ijeongsu
 */
public class Food {
    private String image;
    private String name;
    private int score;
    private String discription;
    
    public Food(){
        
    }

    public Food(String image, String name, int score, String discription) {
        this.image = image;
        this.name = name;
        this.score=score;
        this.discription = discription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
    
    
}
