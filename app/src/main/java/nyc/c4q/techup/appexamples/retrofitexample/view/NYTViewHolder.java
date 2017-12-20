package nyc.c4q.techup.appexamples.retrofitexample.view;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels.NYTArticle;

/**
 * Created by amirahoxendine on 12/19/17.
 */

public class NYTViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView articleTitle;
    TextView articleSnippet;
    ImageView articlePhoto;
    public NYTViewHolder(View itemView) {
        super(itemView);

        //cv = (CardView)itemView.findViewById(R.id.cv);
        articleTitle = (TextView)itemView.findViewById(R.id.article_title);
        articleSnippet = (TextView)itemView.findViewById(R.id.article_snippet);
        articlePhoto = (ImageView)itemView.findViewById(R.id.article_photo);
    }

    public void onBind(NYTArticle article){
        articleTitle.setText(article.getHeadline().getPrint_headline());
        articleSnippet.setText(article.getSnippet());
        /*Glide.with(itemView.getContext())
               .load("https://www.nytimes.com/" + article.getMultimedia()[0].getUrl())
               .into(articlePhoto);*/
    }
}
