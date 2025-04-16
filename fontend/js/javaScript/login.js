$(document).ready(function () {
    $("#loginForm").submit(function (event) {
        event.preventDefault(); // Prevent form default submission

        let user = {
            email: $("#login_email").val().trim(),
            password: $("#login_password").val().trim()
        };

        $.ajax({
            url: "http://localhost:8080/api/v1/auth/authenticate",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function (response) {
                if (response.code === "201") { // Successfully authenticated
                    const authData = response.data;
                    const token = authData.token;

                    // Save token and email in localStorage
                    localStorage.setItem("token", token);
                    localStorage.setItem("email", authData.email);

                    // Optionally decode JWT payload (if needed)
                    // const payload = JSON.parse(atob(token.split('.')[1]));

                    // Clear inputs
                    $("#login_email").val('');
                    $("#login_password").val('');

                    // 🔁 Now you can decide redirect path based on role or any other logic
                    // If you're storing role in a cookie/session, fetch it in a second request or decode JWT

                    // Example: decode token to get role (if available in claims)
                    const tokenPayload = JSON.parse(atob(token.split('.')[1]));
                    const role = tokenPayload.role;

                    if (role === "STUDENT") {
                        window.location.href = "studentHome.html";
                    } else if (role === "TEACHER") {
                        window.location.href = "teacher_dashboard.html";
                    } else {
                        Swal.fire({
                            icon: "warning",
                            title: "Unknown Role",
                            text: "Redirect failed due to unknown user role."
                        });
                    }
                } else {
                    Swal.fire({
                        icon: "error",
                        title: "Login Failed",
                        text: response.message || "Invalid credentials",
                        confirmButtonText: "Try Again"
                    });
                }
            },
            error: function (xhr) {
                let errorMessage = "Invalid Email or Password";
                if (xhr.responseJSON && xhr.responseJSON.message) {
                    errorMessage = xhr.responseJSON.message;
                }

                Swal.fire({
                    icon: "error",
                    title: "Login Failed",
                    text: errorMessage,
                    confirmButtonText: "Try Again"
                });
            }
        });
    });
});
