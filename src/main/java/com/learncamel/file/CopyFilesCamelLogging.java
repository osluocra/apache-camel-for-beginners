package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelLogging {
    public static void main(String[] args) {
        int iSleepTime=5000;
        CamelContext context = new DefaultCamelContext();

        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");
                }
            });


            System.out.println("Starting context");
            context.start();

            Thread.sleep(iSleepTime);


            context.stop();

        } catch (Exception e) {
            System.out.println("Error is: " + e);
            e.printStackTrace();
        }


    }
}
