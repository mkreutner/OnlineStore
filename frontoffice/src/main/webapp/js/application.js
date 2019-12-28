$(document).ready(function () {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();
        
        $('div[id=catalogue]').empty();
        $.ajax({
            url: "catalogue",
            success: function (result) {
                $("div[id=catalogue]").append(result);
            }
        });
    });
});


