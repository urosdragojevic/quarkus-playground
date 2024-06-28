package com.urosdragojevic;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface EmployeeEntityResource extends PanacheEntityResource<Employee, Long> {
}
