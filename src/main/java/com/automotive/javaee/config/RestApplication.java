package com.automotive.javaee.config;

import com.automotive.javaee.resource.AppointmentResource;
import com.automotive.javaee.resource.CustomerResource;
import com.automotive.javaee.resource.DealershipResource;
import com.automotive.javaee.resource.EmployeeResource;
import com.automotive.javaee.resource.HealthResource;
import com.automotive.javaee.resource.InvoiceResource;
import com.automotive.javaee.resource.ManufacturerResource;
import com.automotive.javaee.resource.PartResource;
import com.automotive.javaee.resource.ServiceRecordResource;
import com.automotive.javaee.resource.UserResource;
import com.automotive.javaee.resource.VehicleResource;
import com.automotive.javaee.resource.WarrantyResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(AppointmentResource.class);
        classes.add(CustomerResource.class);
        classes.add(DealershipResource.class);
        classes.add(EmployeeResource.class);
        classes.add(HealthResource.class);
        classes.add(InvoiceResource.class);
        classes.add(ManufacturerResource.class);
        classes.add(PartResource.class);
        classes.add(ServiceRecordResource.class);
        classes.add(UserResource.class);
        classes.add(VehicleResource.class);
        classes.add(WarrantyResource.class);

        return classes;
    }
}