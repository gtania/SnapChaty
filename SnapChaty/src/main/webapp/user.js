/**
 * Created by Stamatios Tsalikis on 10/11/2015.
 */
var User = function (firstName, lastName, userName, password, eMail) {
    this.firstName = firstName;

    this.lastName = lastName;

    this.userName = userName;

    this.password = password;

    this.eMail = eMail;
};

User.prototype.getFirstName = function () {
    return this.firstName;
};

User.prototype.getLastName = function () {
    return this.lastName;
};

User.prototype.getUserName = function () {
    return this.userName;
};

User.prototype.getPassword = function () {
    return this.password;
};

User.prototype.getEMail = function () {
    return this.eMail;
};
