package net.xdclass;

import net.xdclass.utils.SysProperties;
import net.xdclass.utils.SysSequenceXml;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MasterApplication {
    public static void main(String[] args) throws IOException {
        initEnv();
        SpringApplication.run(MasterApplication.class,args);
    }

    private static void initEnv() throws IOException {
        SysProperties.loadAllProperties();
        SysSequenceXml.readXml();
    }

}
