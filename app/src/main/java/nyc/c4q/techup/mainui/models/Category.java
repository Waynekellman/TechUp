package nyc.c4q.techup.mainui.models;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class Category {
    private String category;
    private String categoryDescription;


    public Category(String category, String categoryDescription) {
        this.category = category;
        this.categoryDescription = categoryDescription;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryDescription(){
        return categoryDescription;
    }
}
