package nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amirahoxendine on 12/19/17.
 */

public class NYTArticle {
    private String snippet;
    //@SerializedName("headline")//this is what its called in the JSON, lets me change the name
    private NYTHeadline headline;
    private NYTMultimedia[] multimedia;

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public NYTHeadline getHeadline() {
        return headline;
    }

    public void setHeadline(NYTHeadline headline) {
        this.headline = headline;
    }

    public NYTMultimedia[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(NYTMultimedia[] multimedia) {
        this.multimedia = multimedia;
    }
}
