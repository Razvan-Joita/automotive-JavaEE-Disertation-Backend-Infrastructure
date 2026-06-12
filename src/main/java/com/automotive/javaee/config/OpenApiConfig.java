package com.automotive.javaee.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Automotive JavaEE API",
                version = "1.0.0",
                description = "Automotive management API built with Jakarta EE"
        ),
        servers = {
                @Server(
                        url = "https://automotive-javaee-rz01.azurewebsites.net/ROOT",
                        description = "Local Docker Server"
                )
        }
)
public class OpenApiConfig {
}