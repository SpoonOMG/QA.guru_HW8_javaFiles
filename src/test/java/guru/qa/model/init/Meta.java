package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    @JsonProperty("channel")
    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String channel;
}
