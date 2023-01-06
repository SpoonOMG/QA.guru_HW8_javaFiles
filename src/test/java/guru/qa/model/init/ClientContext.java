package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientContext{
    @JsonProperty("employee")
    public Employee getEmployee() {
        return this.employee; }
    public void setEmployee(Employee employee) {
        this.employee = employee; }
    public Employee employee;
}

