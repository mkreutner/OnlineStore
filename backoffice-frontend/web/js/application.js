$(document).ready(function () {
    $('div[id=addworkform-container]').hide();
    
    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };    

    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();

        $('div[id=addworkform-container]').hide();
        $('div[id=catalogue]').show();
        $('div[id=catalogue]').empty();
        $.ajax({
            url: "http://localhost:8080/services/rest/work",
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
    $('a[href=addworkform]').on('click', function (event) {
        event.preventDefault();

        $('div[id=catalogue]').hide();
        $('div[id=addworkform-container]').toggle();
    });

    $('form[id=addworkform]').submit(function (event) {
        event.preventDefault();

        const form = $(this);
        const url = "http://localhost:8080/services/rest/work";
        const payload = form.serializeObject();
        
        console.log(payload);
        
        $.ajax({
            type: "POST",
            url: url,
            data: payload,
            dataType : 'json',
            
            success: function (data)
            {
                alert(data); // show response from service.
            }
        });
    });
});