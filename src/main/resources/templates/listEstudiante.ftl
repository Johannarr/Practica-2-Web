<!DOCTYPE html>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
<h1>Welcome!</h1>
<a href="/crearEstudiante/">Crear Estudiante</a>
<h1>Lista de estudiantes</h1>
<table border="1" width="900"  margins="10">
    <thead>
    <tr>
        <td><strong> Matricula </strong></td>
        <td><strong> Nombre </strong></td>
        <td><strong> Apellido </strong></td>
        <td><strong> Telefono </strong></td>
    </tr>
    </thead>
    <tbody>
    <#list list as estudiante>
    <tr><td>${estudiante.matricula}</td>
        <td>${estudiante.nombre}</td>
        <td>${estudiante.apellido}</td>
        <td>${estudiante.telefono}</td>
        </#list>
    </tbody>

</table>
</body>
</html>