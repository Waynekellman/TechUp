package nyc.c4q.techup.appexamples.jsonparsingexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.techup.R;

public class ExampleJsonParsingDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Members> membersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_json_parsing_detail);

        //simple json parsing, from review lesson

        JSONObject jsonObject = new JSONObject();
        //can store arrays, strings, ints, booleans in key value pairs.
        //need to surround in try/catch because there's a chance to get error, like null pointer or
        //more commonly 'malformed' json, json written incorrectly.
        //key will always be a string.
        try {
            jsonObject.put("name", "AJ");
            jsonObject.put("members", new JSONArray()
                    .put(new JSONObject().put("name", "Jose").put("age", 80))
                    .put(new JSONObject().put("name", "Joanne").put("age", 75))
                    .put(new JSONObject().put("name", "Siran").put("age", 44)));
            Log.e("JSON", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        parseJSON(jsonObject.toString());

        recyclerView = (RecyclerView) findViewById(R.id.json_detail_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //layout manager informs recycler view how to layout views.
        recyclerView.setLayoutManager(linearLayoutManager);
        JSONAdapter jsonAdapter = new JSONAdapter(membersList);
        recyclerView.setAdapter(jsonAdapter);
    }

    public void parseJSON(String string){
        try {
            JSONObject jsonObject = new JSONObject(string);
            JSONArray jsonArray = jsonObject.getJSONArray("members");
            //extract each one.
            membersList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i); //want to create a new JSON object for each object in the array
                Members members = new Members();//instantiate model object and set its field to json object values.
                String objectName = jsonObject1.getString("name");
                int age = jsonObject1.getInt("age");
                members.setName(objectName);
                members.setAge(age);
                membersList.add(members);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class JSONModel {
        //typically you want to create a class that represents the entire Json string
        private String name;
        private List<Members> members;
        //in retrofit, would not need getters and setters. but with pure JSon parsing, you would need getters and setters.
        //variables within the models should be the same as the keys in your JSON

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Members> getMembers() {
            return members;
        }

        public void setMembers(List<Members> members) {
            this.members = members;
        }
    }

    public class Members {
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class JSONAdapter extends RecyclerView.Adapter<JSONViewHolder> {
        List<Members> membersList;

        public JSONAdapter (List<Members> membersList){
            this.membersList = membersList;
        }
        @Override
        public JSONViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.json_detail_item_view, parent, false);
            return new JSONViewHolder(childView);
        }

        @Override
        public void onBindViewHolder(JSONViewHolder holder, int position) {
            Members members = membersList.get(position);
            holder.onBind(members);

        }

        @Override
        public int getItemCount() {
            return membersList.size();
        }
    }

    public class JSONViewHolder extends RecyclerView.ViewHolder {
        TextView nameText;
        TextView ageText;
        public JSONViewHolder(View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(R.id.member_name);
            ageText = (TextView) itemView.findViewById(R.id.member_age);
        }

        public void onBind(Members members){
            nameText.setText("Name: " + members.getName());
            ageText.setText("Age: " + String.valueOf(members.getAge()));
        }
    }
}
