<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="../css/simple-sidebar.css" rel="stylesheet">
    <link href="../css/menu.css" rel="stylesheet">


</head>

<body>

<div id="wrapper">

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div style="float : left">

                <div id="tituloMenu">

                    <h1 id="titulo">Editar estudiante</h1>

                </div>
            </div>
            <div>

    <form method="POST" action="/editar">
        <div class="form-group">
            </br></br>
            </br></br>
            <label for="matricula">Matricula</label>
            <input type="number" class="form-control" placeholder="Introduce la matricula"  name="matricula" value="${estudiante.matricula?string["0"]}" required>
        </div>
        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input type="text" class="form-control" placeholder="Introduce el nombre"  name="nombre" value="${estudiante.nombre}" required>
        </div>
        <div class="form-group">
            <label for="apellido">Apellido</label>
            <input type="text" class="form-control" placeholder="Introduce el apellido" name="apellido" value="${estudiante.apellido}" required>
        </div>
        <div class="form-group">
            <label for="telefono">Telefono</label>
            <input type="text" class="form-control" placeholder="Introduce el telefono" name="telefono" value="${estudiante.telefono}" required>
        </div>


        <div style="float: right">
            <button type="submit" class="btn btn-default">Actualizar</button>
        </div>


    </form>

    </div>

</div>
<!-- /#wrapper -->

<!-- Bootstrap core JavaScript -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Menu Toggle Script -->
<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
</script>

</body>

</html>
