package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
    @JsonProperty("meta")
    public Meta getMeta() {
        return this.meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta meta;

    @JsonProperty("data")
    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data data;
}
