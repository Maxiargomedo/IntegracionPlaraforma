$('#btnEnviar').click(function(){

    var esperar = 200;
    $.ajax({

        url: "respuesta.html",
        beforeSend : function(){
            $('#respuesta').text('cargando...');
        },

        success : function(data){
            setTimeout(function(){
                $('#respuesta').html(data);
            },esperar
            );
        }
    });
});