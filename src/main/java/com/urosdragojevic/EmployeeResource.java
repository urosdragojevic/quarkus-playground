package com.urosdragojevic;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface EmployeeResource extends PanacheEntityResource<Employee, Long> {
}
