package nyc.c4q.techup.mainui.examplesmainui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.techup.R;

/**
 * Created by amirahoxendine on 12/25/17.
 */

public class ExampleCardAdapter extends RecyclerView.Adapter<ExampleCardViewHolder> {
    private List<ExampleCard> exampleCardList;
    private View.OnClickListener exampleOnClickListener;






    public ExampleCardAdapter(List<ExampleCard> exampleCardList, View.OnClickListener exampleOnClickListener){
        this.exampleCardList = exampleCardList;
        this.exampleOnClickListener = exampleOnClickListener;
    }

    @Override
    public ExampleCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.main_example_card_item_view, parent,false);

       return new ExampleCardViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ExampleCardViewHolder holder, int position) {
        ExampleCard exampleCard = exampleCardList.get(position);
        holder.onBind(exampleCard);
        holder.titleTextView.setTag(exampleCard.getName());
        holder.itemView.setOnClickListener(exampleOnClickListener);

    }



    @Override
    public int getItemCount() {
        return exampleCardList.size();
    }
}
