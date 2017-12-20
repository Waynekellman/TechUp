package nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amirahoxendine on 12/19/17.
 */

public class NYTArticle {
    String snippet;
    @SerializedName("headline")//this is what its called in the JSON, lets me change the name
            NYTHeadline nytHeadline;
    NYTMultimedia[] multimedia;

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public NYTHeadline getNytHeadline() {
        return nytHeadline;
    }

    public void setNytHeadline(NYTHeadline nytHeadline) {
        this.nytHeadline = nytHeadline;
    }

    public NYTMultimedia[] getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(NYTMultimedia[] multimedia) {
        this.multimedia = multimedia;
    }
}
