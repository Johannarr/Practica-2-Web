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

                    <h1 id="titulo">Estudiante</h1>

                </div>

        </div>
    </div>
    <!-- /#page-content-wrapper -->

        <div>
            </br></br>
            </br></br>
            <label for="matricula"> <span class="font-weight-bold">Matricula: </span> ${estudiante.matricula?string["0"]}</label>
            </br>
            <label for="nombre"> <span class="font-weight-bold">Nombre: </span>${estudiante.nombre}</label>
            </br>
            <label for="apellido"> <span class="font-weight-bold">Apellido: </span>${estudiante.apellido}</label>
            </br>
            <label for="telefono"> <span class="font-weight-bold">Telefono: </span>${estudiante.telefono}</label>
            </br>
        </div>

        <td><a href="/" class="btn btn-primary"><i class="btn btn"> Volver al Inicio</i></a></td>
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
