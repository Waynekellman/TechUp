package nyc.c4q.techup.appexamples.jsonparsingexample;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nyc.c4q.techup.R;

public class ExampleJsonParsingActivity extends AppCompatActivity {

    private List<String> jsonMessageList;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_json_parsing);

//****sorry, everything is in classes below, no time to set up properly!

        //This example parses a json string and logs it to the console (not in a recycler view!)
        //theres a method for setting the Json string, setting a json object to the string,
        // getting the Json array, getting the keys from that array and putting then in a list, then using those keys to parse
        //the inner array. Complicated, yes unfortunately.

        JsonParsingInnerArray jsonParsingInnerArray = new JsonParsingInnerArray();
        jsonParsingInnerArray.businessLogic();
        //Output : Value {"affenpinscher":[],"african":[],"airedale":[],"akita":[],"appenzeller":[],"basenji":[],"beagle":[],"bluetick":[],
        // "borzoi":[],"bouvier":[],"boxer":[],"brabancon":[],"briard":[],"bulldog":["boston","french"],"bullterrier":["staffordshire"],"cairn":[],
        // "chihuahua":[],"chow":[],"clumber":[],"collie":["border"],"coonhound":[],"corgi":["cardigan"],"dachshund":[],"dane":["great"],"deerhound":["scottish"],
        // "dhole":[],"dingo":[],"doberman":[],"elkhound":["norwegian"],"entlebucher":[],"eskimo":[],"germanshepherd":[],"greyhound":["italian"],"groenendael":[],
        // "hound":["Ibizan","afghan","basset","blood","english","walker"],"husky":[],"keeshond":[],"kelpie":[],"komondor":[],"kuvasz":[],"labrador":[],"leonberg":[],
        // "lhasa":[],"malamute":[],"malinois":[],"maltese":[],"mastiff":["bull","tibetan"],"mexicanhairless":[],"mountain":["bernese","swiss"],"newfoundland":[],"otterhound":[],
        // "papillon":[],"pekinese":[],"pembroke":[],"pinscher":["miniature"],"pointer":["german"],"pomeranian":[],"poodle":["miniature","standard","toy"],"pug":[],"pyrenees":[],
        // "redbone":[],"retriever":["chesapeake","curly","flatcoated","golden"],"ridgeback":["rhodesian"],"rottweiler":[],"saluki":[],"samoyed":[],"schipperke":[],"schnauzer":["giant","miniature"],
        // "setter":["english","gordon","irish"],"sheepdog":["english","shetland"],"shiba":[],"shihtzu":[],"spaniel":["blenheim","brittany","cocker","irish","japanese","sussex","welsh"],
        // "springer":["english"],"stbernard":[],"terrier":["american","australian","bedlington","border","dandie","fox","irish","kerryblue","lakeland","norfolk","norwich","patterdale","scottish","sealyham","silky","tibetan","toy","westhighland","wheaten","yorkshire"],
        // "vizsla":[],"weimaraner":[],"whippet":[],"wolfhound":["irish"]}
//******

        //Gson Parsing shows how to read Json input from a file which is in the raw resources directory,
        //Terms data is a class that extends array list, it has a method to parse data from file and add to the list. this list
        //is then set into a recycler view.

        GsonParsingExample gsonParsingExample = new GsonParsingExample();
        gsonParsingExample.setRecyclerView();


    }

    private class JsonParsingInnerArray {
        //method calls other methods in class to set Json string, parse the object and log whats inside.
        public void businessLogic() {
            String jSonString = setJSonString();
            JSONObject exercise2 = setJSon(jSonString);
            String keyName = "message";
            JSONArray exercise2JSonArray = getJsonArray(exercise2, keyName);
            List<String> messageKeys = getMessageKeys(exercise2JSonArray);
            logKeys(messageKeys, exercise2JSonArray);

        }
        //just a string with json data
        public String setJSonString() {
            String jSonString = "{\"status\":\"success\",\"message\":{\"affenpinscher\":[],\"african\":[],\"airedale\":[],\"akita\":[],\"appenzeller\":[],\"basenji\":[],\"beagle\":[],\"bluetick\":[],\"borzoi\":[],\"bouvier\":[],\"boxer\":[],\"brabancon\":[],\"briard\":[],\"bulldog\":[\"boston\",\"french\"],\"bullterrier\":[\"staffordshire\"],\"cairn\":[],\"chihuahua\":[],\"chow\":[],\"clumber\":[],\"collie\":[\"border\"],\"coonhound\":[],\"corgi\":[\"cardigan\"],\"dachshund\":[],\"dane\":[\"great\"],\"deerhound\":[\"scottish\"],\"dhole\":[],\"dingo\":[],\"doberman\":[],\"elkhound\":[\"norwegian\"],\"entlebucher\":[],\"eskimo\":[],\"germanshepherd\":[],\"greyhound\":[\"italian\"],\"groenendael\":[],\"hound\":[\"Ibizan\",\"afghan\",\"basset\",\"blood\",\"english\",\"walker\"],\"husky\":[],\"keeshond\":[],\"kelpie\":[],\"komondor\":[],\"kuvasz\":[],\"labrador\":[],\"leonberg\":[],\"lhasa\":[],\"malamute\":[],\"malinois\":[],\"maltese\":[],\"mastiff\":[\"bull\",\"tibetan\"],\"mexicanhairless\":[],\"mountain\":[\"bernese\",\"swiss\"],\"newfoundland\":[],\"otterhound\":[],\"papillon\":[],\"pekinese\":[],\"pembroke\":[],\"pinscher\":[\"miniature\"],\"pointer\":[\"german\"],\"pomeranian\":[],\"poodle\":[\"miniature\",\"standard\",\"toy\"],\"pug\":[],\"pyrenees\":[],\"redbone\":[],\"retriever\":[\"chesapeake\",\"curly\",\"flatcoated\",\"golden\"],\"ridgeback\":[\"rhodesian\"],\"rottweiler\":[],\"saluki\":[],\"samoyed\":[],\"schipperke\":[],\"schnauzer\":[\"giant\",\"miniature\"],\"setter\":[\"english\",\"gordon\",\"irish\"],\"sheepdog\":[\"english\",\"shetland\"],\"shiba\":[],\"shihtzu\":[],\"spaniel\":[\"blenheim\",\"brittany\",\"cocker\",\"irish\",\"japanese\",\"sussex\",\"welsh\"],\"springer\":[\"english\"],\"stbernard\":[],\"terrier\":[\"american\",\"australian\",\"bedlington\",\"border\",\"dandie\",\"fox\",\"irish\",\"kerryblue\",\"lakeland\",\"norfolk\",\"norwich\",\"patterdale\",\"scottish\",\"sealyham\",\"silky\",\"tibetan\",\"toy\",\"westhighland\",\"wheaten\",\"yorkshire\"],\"vizsla\":[],\"weimaraner\":[],\"whippet\":[],\"wolfhound\":[\"irish\"]}}";
            return jSonString;
        }

        //sets a json object to the json string

        @Nullable//google what that means
        private JSONObject setJSon(String jSonString) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(jSonString);
            } catch (JSONException e) {

            }
            return jsonObject;
        }
            //method to get the array within the original json object, based on the key 9name of the array
        private JSONArray getJsonArray(JSONObject jsonObject, String keyName) {
            JSONArray jsonArray = new JSONArray();
            try {
                jsonArray = jsonObject.getJSONArray(keyName);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonArray;
        }

        //method that returns a list of all the keys with in the array (the keys are for the inner array within the first array

        private List<String> getMessageKeys(JSONArray jsonArray) {


            List<String> messagekeys = new ArrayList<>();
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    messagekeys.add(String.valueOf(jsonArray.getString(i)));
                }
            } catch (JSONException e) {

            }

            return messagekeys;

        }

        //method that uses the keys from the list and the first json array to log the data into the console

        public void logKeys(List<String> keyList, JSONArray jsonArray) {
            //this outer loop gets the keyname for the arrays inside the outer aray and logs them
            for (int i = 0; i < keyList.size(); i++) {
                Log.e("Dog Breeds: ", keyList.get(i));
                String key = keyList.get(i);//then take each key and parse their inner arrays with another (inner for loop)

                try {

                    JSONObject jsonArrayObject = jsonArray.getJSONObject(i);//creates an object for each object in the inner array.
                    //object is also an array itself (inner array)
                    JSONArray innerJSonArray = jsonArrayObject.getJSONArray(key);//gets array object for each key.
                    List<String> innerArrayStrings = new ArrayList<>();//creates a list for the objects within the inner array
                    //this method parses the inner array and logs the data
                    for (int j = 0; j < innerJSonArray.length(); j++) {
                        innerArrayStrings.add(innerJSonArray.getString(i));
                    }
                    //if there are objects in the array, if it it not empty, this logs them.
                    if (!innerArrayStrings.isEmpty()) {
                        for (String s : innerArrayStrings) {
                            Log.e(TAG, "Dog Breed Types:" + s);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }



    }

    private class GsonParsingExample {
        //TODO set up detail activity
        //Gson json parsing from a file: data class
        public class TermData extends ArrayList<Term> {
            private TermData termData;

            private TermData(){
            }
            //method to fill list with json object from file using input stream and gson.
            private TermData setTermsList() {
                Type collectionType = new TypeToken<Collection<Term>>() {
                }.getType();
                Gson gs = new Gson();
                Collection<Term> terms = null;
                InputStream is = getApplicationContext().getResources().openRawResource(R.raw.basicandroidterms);
                InputStreamReader isr = new InputStreamReader(is);
                terms = gs.fromJson(isr, collectionType);
                termData = new TermData();
                termData.addAll(terms);
                return termData;
            }

        }

        //method for building the recycler view to display data
        public void setRecyclerView(){
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent detailIntent = new Intent(ExampleJsonParsingActivity.this, ExampleJsonParsingDetailActivity.class);
                    startActivity(detailIntent);
                }
            };
            RecyclerView termsRecyclerView = (RecyclerView) findViewById(R.id.json_recycler_view);
            TermData termData = new TermData();
            termData = termData.setTermsList();
            TermAdapter termAdapter = new TermAdapter(termData, onClickListener);
            termsRecyclerView.setAdapter(termAdapter);
            termsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }

        //term model for recycler view

        private class Term implements Serializable {
            String term;
            String definition;
        }
        //viewholder for recycler view

        public class TermViewHolder extends RecyclerView.ViewHolder{
            TextView termView;
            TextView definition;
            public TermViewHolder(View itemView) {
                super(itemView);
                termView = (TextView) itemView.findViewById(R.id.term_text_view);
                definition = (TextView) itemView.findViewById(R.id.definition_text_view);
            }

            public void onBind (Term term){
                termView.setText(term.term);
                definition.setText(term.definition);
            }
        }
        //adapter for recycler view
        public class TermAdapter extends RecyclerView.Adapter<TermViewHolder> {
            private TermData termDataList;
            private View.OnClickListener termClickListener;

            public TermAdapter(TermData termDataList, View.OnClickListener termClickListener){
                this.termDataList = termDataList;
                this.termClickListener = termClickListener;
            }

            @Override
            public TermViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_jsonparing_itemview, parent, false);
                return new TermViewHolder(childView);
            }

            @Override
            public void onBindViewHolder(TermViewHolder holder, int position) {

                Term term = termDataList.get(position);
                holder.onBind(term);
                holder.itemView.setOnClickListener(termClickListener);
            }

            @Override
            public int getItemCount() {
                return termDataList.size();
            }
        }





    }
}
