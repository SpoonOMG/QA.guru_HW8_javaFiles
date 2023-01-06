package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Value {
    @JsonProperty("id")
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;

    @JsonProperty("value")
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String value;
}
