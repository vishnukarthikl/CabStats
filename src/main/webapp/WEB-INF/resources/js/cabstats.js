$(document).ready(function () {

    var secondaryFormElements = $(".secondary");
    var customerStatus = $("#customer-status");
    secondaryFormElements.hide();
    customerStatus.hide();
    $(".datepicker").datepicker();
    $("#time").timepicker();

    $("#customerRegistrationRequest\\.msisdn").focusout(function (event) {

        $.get("getCustomer", {msisdn: this.value},function (data, status) {
            secondaryFormElements.fadeIn();
            customerStatus.removeClass("alert-error");
            customerStatus.addClass("alert-info");
            customerStatus.html("Phone number is present in the system");
            customerStatus.fadeIn();
            $("#customerRegistrationRequest\\.name").val(data.name);
            $("#customerRegistrationRequest\\.street").val(data.street);
            $("#customerRegistrationRequest\\.area").val(data.area);
            $("#customerRegistrationRequest\\.pincode").val(data.pincode);
            secondaryFormElements.fadeIn();
            $("#distance").focus();
        }).fail(function () {
                customerStatus.removeClass("alert-info");
                customerStatus.addClass("alert-error");
                customerStatus.html("Phone number is present in the system");
                customerStatus.fadeIn();
                secondaryFormElements.fadeIn();
                $("#name").focus();
            });
    });

});
