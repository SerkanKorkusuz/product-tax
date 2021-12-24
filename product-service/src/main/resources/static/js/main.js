$('.submitForm').click(function (e) {
    let data = $(this).closest('form').serialize().split("&");
    let obj = {};
    let objKey, objValue, objCode;
    for (let key in data) {
        [objKey, objValue] = data[key].split("=")
        obj[objKey] = objValue;
    }
    e.preventDefault();
    $.ajax({
        url: 'http://localhost:8090/tax-calculation',
        contentType: 'application/json',
        type: "POST",
        data: JSON.stringify(obj),
        success: function (res) {
            objCode = obj.code
            $('.' + objCode).replaceWith(res.tax);
        },
        error: function (err) {
            console.log(err);
        }
    });
});