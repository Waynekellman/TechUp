package nyc.c4q.techup.appexamples.retrofitexample.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.retrofitexample.nytretrofitmodels.NYTArticle;
import nyc.c4q.techup.appexamples.retrofitexample.view.NYTViewHolder;

/**
 * Created by amirahoxendine on 12/19/17.
 */

public class NYTAdapter extends RecyclerView.Adapter<NYTViewHolder> {

    List<NYTArticle> articleList;
    public NYTAdapter (List<NYTArticle> articleList){
        this.articleList = articleList;
    }

    @Override
    public NYTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_retrofit_itemview, parent, false);
        return new NYTViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(NYTViewHolder holder, int position) {
        NYTArticle article = articleList.get(position);
        holder.onBind(article);

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
