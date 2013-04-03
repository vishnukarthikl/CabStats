$(document).ready(function () {

    var customer = $("#customer-details").hide();
    var secondaryFormElements = $(".secondary");
    secondaryFormElements.hide();

    $(".datepicker").datepicker();
    $("#timepicker1").timepicker();

    $("#msisdn").focusout(function (event) {

        $.get("getCustomer", {msisdn: this.value},function (data, status) {
            secondaryFormElements.hide();
            var dataToAppend = "Name : " + data.name + "<br>" +
                "Street : " + data.street + "<br>" +
                "Area : " + data.area + "<br>" +
                "Pincode : " + data.pincode + "<br>";
            customer.html("<b>Customer Details</b> <br>" + dataToAppend).show();
        }).fail(function () {
                customer.hide();
                secondaryFormElements.show();
                $("#name").focus();
            });
    });

});
