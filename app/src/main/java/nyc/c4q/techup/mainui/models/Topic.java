package nyc.c4q.techup.mainui.models;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class Topic {
    private String topic;
    private String topicDescription;
    private String codeId;

    public Topic (String topic, String topicDescription, String codeId){
        this.topic = topic;
        this.topicDescription = topicDescription;
        this.codeId = codeId;
    }

    public String getTopic(){
        return topic;
    }

    public String getTopicDescription(){
        return topicDescription;
    }

    public String getCodeId(){
        return codeId;
    }


}
