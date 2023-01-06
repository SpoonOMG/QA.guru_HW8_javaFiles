package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Scenario {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;
}
