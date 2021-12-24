package com.ayrotek.taxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@SpringBootApplication
public class TaxServiceApplication {
    private static final Log log = LogFactory.getLog(TaxServiceApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TaxServiceApplication.class, args);
    }

}
