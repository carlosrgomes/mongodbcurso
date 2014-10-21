package br.com.exemplo.spark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CRG1211 on 21/10/2014.
 */
public class FremarkerSpark {



    public static void main(String[] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                Template template = null;
                StringWriter stringWriter = new StringWriter();
                try {
                template = configuration.getTemplate("hello.ftl");


                Map<String, Object> param = new HashMap<>();
                param.put("nome", "Carlos Barbero");

                template.process(param, stringWriter);


                }catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }

                return stringWriter;
            }
        });
    }
}
