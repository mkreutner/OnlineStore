$(document).ready(function () {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();
        
        $('div[id=catalogue]').empty();
        $.ajax({
            url: "catalogue",
            success: function (result) {
                result.forEach((elem) => {
                    const row = "<a href=\"work-details?id=" + elem.id
                        + "\" class=\"list-group-item list-group-item-action\">"
                        + elem.title + " (" + elem.release + ")</a>";
                    $("div[id=catalogue]").append(row);
                });
                
            }
        });
    });
});