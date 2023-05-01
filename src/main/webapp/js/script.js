$("#form-cadastro").submit((e) => {
    e.preventDefault()
    let data = {
        id: $("#id").val(),
        description: $("#description").val(),
        price: $("#price").val()
    }
    $.ajax({
        type: "POST",
        url: "/product",
        data: JSON.stringify(data)
    })
        .then(() => alert("Success"))
        .catch(() => alert("Error"))
})