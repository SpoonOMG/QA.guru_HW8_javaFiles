package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {
    @JsonProperty("code")
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String code;
}
