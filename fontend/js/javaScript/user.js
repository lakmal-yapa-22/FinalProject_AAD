
$("#register_btn").click(function () {
    saveUser();
});

function saveUser() {
    let user = {
        email: $("#email").val().trim(),
        name: $("#name").val().trim(),
        nic: $("#nic").val().trim(),
        password: $("#password").val().trim(),
        userType: $("#user_type").val().trim()
    };

    $.ajax({
        url: "http://localhost:8080/api/v1/user/save",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(user),
        success: function(response) {
            if (response && response.code === 201) {  // Check backend response
                Swal.fire({
                    icon: "success",
                    title: "User Saved",
                    text: "User registration successful!",
                    confirmButtonColor: "#3085d6"
                }).then(() => {
                    clearFields();
                });
            } else {
                Swal.fire({
                    icon: "error",
                    title: "Registration Failed",
                    text: "User not saved. Try again.",
                    confirmButtonColor: "#d33"
                });
            }
        },
        error: function(xhr) {
            console.log("Error Response: ", xhr.responseText); // Log error message
            Swal.fire({
                icon: "error",
                title: "Error",
                text: xhr.responseText || "Something went wrong!",
                confirmButtonColor: "#d33"
            });
        }
    });
}

function clearFields() {
    $("#email").val("");
    $("#name").val("");
    $("#nic").val("");
    $("#password").val("");
    $("#user_type").val("");
}





//user update



// Profile Image Preview
document.getElementById("profileImage").addEventListener("change", function(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById("profileImagePreview").src = e.target.result;
        };
        reader.readAsDataURL(file);
    }
});

// Handle Form Submission (For Backend Integration)
document.getElementById("profileEditForm").addEventListener("submit", function(event) {
    event.preventDefault();

});

$("#profileImage").change(function (event) {
    let reader = new FileReader();
    reader.onload = function (e) {
        $("#profileImagePreview").attr("src", e.target.result);
    };
    reader.readAsDataURL(event.target.files[0]);
});
