package com.enviro.assessment.grad001.LucianoCharles.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WasteCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String disposal_tip;
    private String recycling_tip;

    public WasteCategories(){
    }

    public WasteCategories(String category, String disposal_tip, String recycling_tip){
        this.category = category;
        this.disposal_tip = disposal_tip;
        this.recycling_tip = recycling_tip;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDisposalTip()  {return disposal_tip;}
    public void setDisposal_tip(String disposal_tip) {this.disposal_tip = disposal_tip;}
    public String getRecyclingTip()  {return recycling_tip;}
    public void setRecycling_tip(String recycling_tip) {
        this.recycling_tip = recycling_tip;
    }


}
