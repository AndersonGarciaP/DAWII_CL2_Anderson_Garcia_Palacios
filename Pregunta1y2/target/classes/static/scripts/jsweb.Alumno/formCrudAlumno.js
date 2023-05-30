$(document).on("click", "#btnagregar", function(){
    $("#txtcodigo").val("");
    $("#txtnombre").val("");
    $("#txtapellido").val("");
    $("#cboespecialidad").empty();
    $("#txtprocedencia").val("");
    $("#hddidAlumno").val("0");
    $.ajax({
        type: "GET",
        url: "/Especialidad/listarEspecialidades",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
        }
    })
    $("#modalNuevo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnombre").val($(this).attr("data-nomalumno"));
    $("#txtapellido").val($(this).attr("data-apealumno"));
    $("#hddidAlumno").val($(this).attr("data-idalumno"));
    $("#cboespecialidad").empty();
    $("#txtprocedencia").val($(this).attr("data-proce"));
    var idesp = $(this).attr("data-idesp");
    $.ajax({
        type: "GET",
        url: "/Especialidad/listarEspecialidades",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cboespecialidad").append(
                    `<option value="${value.idesp}">${value.nomesp}</option>`
                )
            })
            $("#cboespecialidad").val(idesp);
        }
    })
    $("#modalNuevo").modal("show");
});


$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/Alumno/registrarAlumno",
        contentType: "application/json",
        data: JSON.stringify({

            idalumno: $("#txtcodigo").val(),
            nomalumno: $("#txtnombre").val(),
            apealumno: $("#txtapellido").val(),
            idesp: $("#cboespecialidad").val(),
            proce: $("#txtprocedencia").val()

        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarAlumno();
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalNuevo").modal("hide");
});

$(document).on("click", ".btneliminar", function(){
    var idalumno = $(this).attr("data-idalumno");
    $.ajax({
        type: "DELETE",
        url: "/Alumno/eliminarAlumno",
        contentType: "application/json",
        data: JSON.stringify({
            idalumno: idalumno
        }),
        success: function(resultado){
            if(resultado.respuesta){
                ListarAlumno();
            }
            alert(resultado.mensaje);
        }
    });
});

function ListarAlumno(){
    $.ajax({
        type: "GET",
        url: "/Alumno/listarAlumnos",
        dataType: "json",
        success: function(resultado){
            $("#tblAlumno > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblAlumno > tbody").append("<tr>"+
                    "<td>"+value.idalumno+"</td>"+
                    "<td>"+value.nomalumno+"</td>"+
                    "<td>"+value.apealumno+"</td>"+
                    "<td>"+value.proce+"</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-info btnactualizar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'"+
                                     "data-apealumno='"+value.apealumno+"'"+
                                     "data-idesp='"+value.idesp +"'"+
                                     "data-proce='"+value.proce+"'>Actualizar</button>"+
                    "</td>"+
                    "<td>"+
                        "<button type='button' class='btn btn-danger btneliminar'"+
                                     "data-idalumno='"+value.idalumno+"'"+
                                     "data-nomalumno='"+value.nomalumno+"'>Eliminar</button>"+
                    "</td></tr>");
            })
        }
    })
}