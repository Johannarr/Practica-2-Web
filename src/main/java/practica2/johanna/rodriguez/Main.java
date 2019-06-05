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



        get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Inicio");
            if (estudiantes.size() > 5)
                attributes.put("estudiantes",estudiantes.subList(0,5));
            else
                attributes.put("estudiantes",estudiantes);
            return new ModelAndView(attributes, "inicio.ftl");
        }, freeMarkerEngine);


        get("/agregarEstudiantes", (request, response) -> configuration.getTemplate("formAgregar.ftl"));


        post("/agregar",(request, response) -> {
            StringWriter escritor = new StringWriter();
            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");
                String matriculaParseada = matricula.replace(",", "");
                estudiantes.add(new Estudiante(Integer.parseInt(matriculaParseada), nombre, apellido, telefono));
                response.redirect("/");
            }catch (Exception error){
                System.out.println("Error agregando estudiante " + error.toString());
                response.redirect("/agregarEstudiantes");
            }
            return escritor;
        });


        get("/eliminar/:posicion",(request, response) -> {

            String posicion = request.params("posicion");

            estudiantes.remove(Integer.parseInt(posicion));


            response.redirect("/");
            return "";
        });

        get("/editar/:posicion", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            String posicion = request.params("posicion");
            Estudiante estudiante = estudiantes.get(Integer.parseInt(posicion));

            estudianteEditar = estudiante;
            attributes.put("titulo", "Editar estudiante");
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "formEditar.ftl");
        }, freeMarkerEngine);

        post("/editar",(request, response) -> {
            StringWriter escritor = new StringWriter();
            try {
                String matricula = request.queryParams("matricula");
                String nombre = request.queryParams("nombre");
                String apellido = request.queryParams("apellido");
                String telefono = request.queryParams("telefono");

                int pos = posicionEstudiante(estudianteEditar);

                estudianteEditar.setMatricula(Integer.parseInt(matricula));
                estudianteEditar.setNombre(nombre);
                estudianteEditar.setApellido(apellido);
                estudianteEditar.setTelefono(telefono);

                if (pos != -1){

                    estudiantes.set(pos, estudianteEditar);
                    estudianteEditar = null;
                }

                response.redirect("/");
            }catch (Exception error){
                System.out.println("Editando estudiante " + error.toString());

            }
            return escritor;
        });

    }


    private static int posicionEstudiante(Estudiante estudiante){

        for (int i =0; i < estudiantes.size(); i++){

            if (estudiantes.get(i) == estudiante)
            {
                return i;
            }
        }

        return  -1;
    }
}