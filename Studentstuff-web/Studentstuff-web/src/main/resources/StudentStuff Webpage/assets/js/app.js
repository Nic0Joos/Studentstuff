function putCustomer(customerID, customer, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/api/customer/" + customerID,
        data: customer,
        success: function (data, textStatus, response) {
            callbackSuccess(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

function getCustomerJSON(id, name, email, mobile) {
    if (id === null) {
        return JSON.stringify({
            "name": name,
            "email": email,
            "mobile": mobile
        });
    }
    return JSON.stringify({
        "id": id,
        "name": name,
        "email": email,
        "mobile": mobile
    });
}