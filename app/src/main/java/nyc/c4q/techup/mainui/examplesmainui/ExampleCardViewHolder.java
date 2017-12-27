package nyc.c4q.techup.mainui.examplesmainui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.techup.R;

/**
 * Created by amirahoxendine on 12/25/17.
 */

public class ExampleCardViewHolder extends RecyclerView.ViewHolder{
    String name;
    TextView titleTextView;
    TextView descriptionTextView;

    public ExampleCardViewHolder(View itemView) {
        super(itemView);
        titleTextView = (TextView) itemView.findViewById(R.id.example_card_title_textview);
        descriptionTextView = (TextView) itemView.findViewById(R.id.example_card_description_textview);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void onBind(ExampleCard exampleCard){
        setName(exampleCard.getName());
        titleTextView.setText(exampleCard.getTitle());
        descriptionTextView.setText(exampleCard.getDescription());
    }
}
