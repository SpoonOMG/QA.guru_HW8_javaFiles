package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("scenario")
    public Scenario getScenario() {
        return this.scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario scenario;

    @JsonProperty("clientContext")
    public ClientContext getClientContext() {
        return this.clientContext;
    }

    public void setClientContext(ClientContext clientContext) {
        this.clientContext = clientContext;
    }

    public ClientContext clientContext;

    @JsonProperty("verifyData")
    public VerifyData getVerifyData() {
        return this.verifyData;
    }

    public void setVerifyData(VerifyData verifyData) {
        this.verifyData = verifyData;
    }

    public VerifyData verifyData;

    @JsonProperty("operation")
    public Operation getOperation() {
        return this.operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    Operation operation;
}
