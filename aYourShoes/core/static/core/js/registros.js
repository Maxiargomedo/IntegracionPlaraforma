$(document).ready(function() {

    (function($) {
        "use strict";


        jQuery.validator.addMethod('answercheck', function(value, element) {
            return this.optional(element) || /^\bcat\b$/.test(value)
        }, "type the correct answer -_-");

        // validar datos registro
        $(function() {
            $('#registrosFrom').validate({
                rules: {
                    Nombre1: {
                        required: true,
                        minlength: 5
                    },
                    Nombre2: {
                        required: true,
                        minlength: 3
                    },
                    Nombre3: {
                        required: true,
                        minlength: 4
                    },
                    Email1: {
                        required: true,
                        minlength: 3,
                    },
                    Direccion1: {
                        required: true,
                        minlength: 4
                    },
                },
                messages: {
                    Nombre1: {
                        required: "vamos, tienes que poner un Nombre usuario",
                        minlength: "tu nombre debe tener al menos 2 caracteres"
                    },
                    Nombre2: {
                        required: "¿no tienes nombre?",
                        minlength: "tienes que poner tu nombre"
                    },
                    Nombre3: {
                        required: "¿no tienes apellidos ?.",
                        minlength: "El asunto tiene que tener mínimo 4 caracteres"
                    },
                    Email1: {
                        required: "sin correo electrónico, no hay registro.",
                        minlength: "tiene que incluir @.gmail o hotmail."
                    },
                    Direccion1: {
                        required: "tienes que poner el lujar donde vives.",
                        minlength: "¿tiene que tener mínimo 4 caracteres ?"
                    },
                },

            })
        })

    })(jQuery)
})

$(document).ready(function() {
    (function($) {
        "use strict";
        jQuery.validator.addMethod('answercheck', function(value, element) {
            return this.optional(element) || /^\bcat\b$/.test(value)
        }, "type the correct answer -_-");

        // validar datos registro
        $(function() {
            $('#respuestaFrom').validate({
                rules: {
                    Email2: {
                        required: true,
                        minlength: 3
                    },
                },
                messages: {
                    Email2: {
                        required: "no hay direccion de correo.",
                        minlength: "tiene que incluir @.gmail o hotmail."
                    },
                }
            })
        })
    })(jQuery)
})