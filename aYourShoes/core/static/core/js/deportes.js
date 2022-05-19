$(document).ready(function() {
    $('#btnMostrarDeportes').click(function(){
        $.get("https://www.thesportsdb.com/api/v1/json/1/all_sports.php",
            function(data) {
                $.each(data.sports, 
                    function(i, item) {
                        var td1 = `<td>${item.idSport}</td>`;
                        var td2 = `<td>${item.strSport}</td>`;
                        var td3 = `<td><img class="deportes" src="${item.strSportThumb}"></td>`;
                        var td4 = `<td>${item.strSportDescription}</td>`;
                        var tr = `<tr>${td1}${td2}${td3}${td4}</tr>`;
                        $('#tblCategorias').append(tr);
                    });
            });
    });
});