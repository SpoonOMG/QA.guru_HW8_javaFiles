package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class VerifyData {
    @JsonProperty("values")
    public ArrayList<Value> getValues() {
        return this.values;
    }

    public void setValues(ArrayList<Value> values) {
        this.values = values;
    }

    public ArrayList<Value> values;
}
