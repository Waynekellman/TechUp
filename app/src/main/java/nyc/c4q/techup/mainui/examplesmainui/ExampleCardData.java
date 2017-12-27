package nyc.c4q.techup.mainui.examplesmainui;

import android.content.Context;
import android.support.constraint.ConstraintLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import nyc.c4q.techup.R;
import nyc.c4q.techup.appexamples.jsonparsingexample.ExampleJsonParsingActivity;

/**
 * Created by amirahoxendine on 12/25/17.
 */

public class ExampleCardData extends ArrayList<ExampleCard>{
    private ExampleCardData exampleCardData;
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public ExampleCardData(){

    }

    public ExampleCardData setExampleCardList() {
        Type collectionType = new TypeToken<Collection<ExampleCard>>() {
        }.getType();
        Gson gs = new Gson();
        Collection<ExampleCard> examples = null;
        InputStream is = context.getApplicationContext().getResources().openRawResource(R.raw.examplecard);
        InputStreamReader isr = new InputStreamReader(is);
        examples = gs.fromJson(isr, collectionType);
        exampleCardData = new ExampleCardData();
        exampleCardData.addAll(examples);
        return exampleCardData;
    }
}
