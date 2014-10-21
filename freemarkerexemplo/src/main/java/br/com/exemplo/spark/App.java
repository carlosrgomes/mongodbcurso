package br.com.exemplo.spark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args ) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/");

        Template template =  configuration.getTemplate("hello.ftl");

        StringWriter stringWriter = new StringWriter();

        Map<String, Object> param = new HashMap<>();
        param.put("nome", "Carlos Barbero");

        template.process(param, stringWriter);

        System.out.println(stringWriter.toString());

    }


}
