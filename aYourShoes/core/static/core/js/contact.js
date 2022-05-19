$(document).ready(function(){
    
    (function($) {
        "use strict";

    
    jQuery.validator.addMethod('answercheck', function (value, element) {
        return this.optional(element) || /^\bcat\b$/.test(value)
    }, "type the correct answer -_-");

    // validar datos
    $(function() {
        $('#contactForm').validate({
            rules: {
                nombre: {
                    required: true,
                    minlength: 2
                },
                asunto: {
                    required: true,
                    minlength: 4
                },
                number: {
                    required: true,
                    minlength: 9
                },
                email: {
                    required: true,
                    email: true
                },
                mensaje: {
                    required: true,
                    minlength: 20
                }
            },
            messages: {
                nombre: {
                    required: "¿vamos, tienes un nombre?, ¿no?",
                    minlength: "tu nombre debe tener al menos 2 caracteres"
                },
                asunto: {
                    required: "¿Tienes algún tema que contarnos?.",
                    minlength: "El asunto tiene que tener mínimo 4 caracteres"
                },
                number: {
                    required: "Agrega algún número de teléfono.",
                    minlength: "Tu número de teléfono debe tener 9 dígitos"
                },
                email: {
                    required: "sin correo electrónico, no hay mensajes."
                },
                mensaje: {
                    required: "um ... sí, tienes que escribir algo para enviar este formulario..",
                    minlength: "¿eso es todo? ¿De Verdad?"
                }
            },
            
        })
    })
        
 })(jQuery)
})