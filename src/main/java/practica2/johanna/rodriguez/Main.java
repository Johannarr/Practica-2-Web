package practica2.johanna.rodriguez;

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {

    private static Estudiante estudianteActual;
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public static void main(String[] args) throws Exception {


        staticFiles.location("/templates");

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            attributes.put("estudiantes",estudiantes);
            return new ModelAndView(attributes, "inicio.ftl");
        }, freeMarkerEngine);


        get("/agregarEstudiante", (request, response) ->
                configuration.getTemplate("formAgregar.ftl"));


        post("/agregar",(request, response) -> {
            StringWriter writer = new StringWriter();
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                String matriculaParseada = matricula.replace(",", "");
                estudiantes.add(new Estudiante(Integer.parseInt(matriculaParseada), nombre, apellido, telefono));
                response.redirect("/");
                return writer;
        });



        get("/ver/:pos", (request, response) -> {

            String pos = request.params("pos");
            Estudiante estudiante = estudiantes.get(Integer.parseInt(pos));
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);
            return new ModelAndView(attributes, "view.ftl");
        }, freeMarkerEngine);


        get("/editar/:pos", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String pos = request.params("pos");
            Estudiante estudiante = estudiantes.get(Integer.parseInt(pos));
            estudianteActual = estudiante;
            attributes.put("titulo", "Editar estudiante");
            attributes.put("estudiante", estudiante);
            return new ModelAndView(attributes, "formEditar.ftl");
        }, freeMarkerEngine);

        post("/editar",(request, response) -> {
            StringWriter writer = new StringWriter();
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");

                int pos = posEstudiante(estudianteActual);

                estudianteActual.setMatricula(Integer.parseInt(matricula));
                estudianteActual.setNombre(nombre);
                estudianteActual.setApellido(apellido);
                estudianteActual.setTelefono(telefono);

                if (pos != -1){

                    estudiantes.set(pos, estudianteActual);
                    estudianteActual = null;
                }
                response.redirect("/");

            return writer;
        });

        get("/eliminar/:pos",(request, response) -> {

            String pos = request.params("pos");
            estudiantes.remove(Integer.parseInt(pos));
            response.redirect("/");
            return "";
        });

    }


    private static int posEstudiante(Estudiante estudiante){

        for (int i =0; i < estudiantes.size(); i++){

            if (estudiantes.get(i) == estudiante)
            {
                return i;
            }
        }
        return  -1;
    }
}