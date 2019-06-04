package practica2.johanna.rodriguez;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.staticFiles;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        staticFiles.location("/templates");


    }
}
