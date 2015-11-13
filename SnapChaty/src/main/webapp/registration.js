/**
 * Created by Stamatios Tsalikis on 10/11/2015.
 */
var UserToJSONRegistration = function (user) {
    this.user = user;
};

UserToJSONRegistration.prototype.registerToJSON = function () {
    var firstName = this.user.getFirstName();

    var lastName = this.user.getLastName();

    var userName = this.user.getUserName();

    var password = this.user.getPassword();

    var eMail = this.user.getEMail();

    var request = $.ajax({
        type: "POST",

        contentType: "text/plain",

        url: "http://localhost:8080/SnapChaty/rest/signup",

        dataType: "text",

        data: JSON.stringify({
            onoma: firstName,

            epitheto: lastName,

            username: userName,

            pass: password,

            email: eMail
        })
    })
};
