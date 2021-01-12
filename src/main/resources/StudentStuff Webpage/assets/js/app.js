serviceEndpointURL = window.location.protocol + "//" + window.location.host;

function register(name, email, password, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/user/register",
        data: JSON.stringify({
            "name": name,
            "email": email,
            "password": password
        }),
        success: function (data, textStatus, response) {
            callbackSuccess(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

function login(email, password, remember, callback) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/login",
        data: JSON.stringify({
            "email": email,
            "password": password,
            "remember": remember
        }),
        success: function (data, textStatus, response) {
            callback(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callback(false);
        }
    });
}

function postOffer(offer, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/api/offer",
        data: offer,
        success: function (data, textStatus, response) {
            callbackSuccess(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

function postPurchase(purchase, callbackSuccess, callbackError) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/api/market",
        data: purchase,
        success: function (data, textStatus, response) {
            callbackSuccess(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

function getOffers(OfferID, callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/api/offer/" + OfferID,
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

function getOpenOffers(OfferID, callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/api/market/" + OfferID,
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

function deleteOffer(OfferID, callback) {
    $.ajax({
        type: "DELETE",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/api/offer/" + OfferID,
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

function putOffer(OfferID, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/api/market/buy",
        success: function (data, textStatus, response) {
            callback(data);
        },
        success: function (data, textStatus, response) {
                    callbackSuccess(true);
                },
         error: function (jqXHR, textStatus, errorThrown) {
                    console.log(jqXHR, textStatus, errorThrown);
                    callbackError(jqXHR.responseJSON.message);
         }
    });
}

function getOfferJSON(id, name, price, description, files) {
    if (id === null) {
        return JSON.stringify({
            "name": name,
            "email": email,
            "mobile": mobile,
            "files": files
        });
    }
}

function getPurchaseJSON(id, name, offerID) {
    if (id === null) {
        return JSON.stringify({
            "name": name,
            "offerID": offerID
        });
    }
}

function getCookie(name) {
    var match = document.cookie.match(new RegExp('(^| )' + name + '=([^;]+)'));
    if (match) return match[2];
}

function getCustomer(callback) {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: serviceEndpointURL + "/profile",
        success: function (data, textStatus, response) {
            callback(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
        }
    });
}

function putCustomer(name, email, password, mobile, callbackSuccess, callbackError) {
    $.ajax({
        type: "PUT",
        contentType: "application/json",
        headers: {
            "X-XSRF-TOKEN": getCookie("XSRF-TOKEN")
        },
        url: serviceEndpointURL + "/profile",
        data: JSON.stringify({
            "name": name,
            "email": email,
            "password": password
            "mobile": mobile
        }),
        success: function (data, textStatus, response) {
            callbackSuccess(true);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            callbackError(jqXHR.responseJSON.message);
        }
    });
}

