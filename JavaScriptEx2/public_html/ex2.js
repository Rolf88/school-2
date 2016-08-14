/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ex2 opg1.
var person = {
    firstName: document.getElementById("firstName"),
    lastName: document.getElementById("lastName"),
    phoneNumb: document.getElementById("phone"),
    email: document.getElementById("email")
};

document.getElementById("myForm").addEventListener("submit", function (e) {
    document.getElementById("showFirstName").innerText = person.firstName.value;
    document.getElementById("showLastName").innerText = person.lastName.value;
    document.getElementById("showPhoneNumb").innerText = person.phoneNumb.value;
    document.getElementById("showEmail").innerText = person.email.value;
    e.preventDefault();
}, false);

//Ex2 opg2
window.addEventListener("load", function () {
    document.getElementById("comments").addEventListener("click", function () {
        return writeComment(this, document.getElementById("writer").value);
    });
});

function writeComment(divE1, text) {
    alert(text);
    divE1.innerText = text;
}

//Ex2 opg5
$(document).ready(function () {
    $("#but").click(function () {
        var text = document.forms["inputform"]["input"].value;
        $("ul").append('<li>' + text + '</li>');
        $("ul li:last-child").click(function () {
            $(this).remove();

        });
    })
});