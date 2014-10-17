package br.com.exemplo.spark;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hellow World";
            }
        });
    }
}
