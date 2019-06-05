package practica2.johanna.rodriguez;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


    public class Main {

        private static ArrayList<Estudiante> estudiantes = new ArrayList<>();
        private static Estudiante estudianteEditar;
        public static void main(String[] args) {


            staticFiles.location("/templates");


            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            configuration.setClassForTemplateLoading(Main.class, "/templates");

            FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);




    }


