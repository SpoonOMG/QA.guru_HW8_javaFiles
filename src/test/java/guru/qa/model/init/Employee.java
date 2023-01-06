package guru.qa.model.init;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
    @JsonProperty("department")
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department department;
}
