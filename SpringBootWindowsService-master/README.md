# Spring Boot Windows Service Example

This is an example of a Spring Boot application that can be deployed as a Windows service.
It is based on the code from https://github.com/snicoll-scratches/spring-boot-daemon.

# Usage

The `dist` folder holds the JAR file built from the code at 
https://github.com/OctopusDeploy/SpringBootStopper along with the winsw executable
and configuration from https://github.com/kohsuke/winsw, and the Spring Boot
JAR compiled from this project.

To install the Spring Boot JAR as a service, run:

```
SpringBoot.exe install
```

To remove the service, run:

```
SpringBoot.exe uninstall
```