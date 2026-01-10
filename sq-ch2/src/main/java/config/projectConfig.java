package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "Main")  // other way  basePackageClasses= Main.class
//it instructs spring to scan for classes to add its instances in its context
public class projectConfig {

}

/*
“src/main/java is only a Maven source directory.
Spring component scanning operates on Java package names defined in compiled classes, not on filesystem directories.”
 */
