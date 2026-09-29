document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("loginForm");
    const message = document.getElementById("loginMessage");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const username = document.getElementById("username").value.trim();
        const password = document.getElementById("password").value;

        message.textContent = "Signing in...";
        message.className = "login-message info";

        try {
            const response = await fetch("/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ username, password })
            });

            const data = await response.json();

            if (!response.ok || !data.success) {
                throw new Error(data.message || "Invalid username or password.");
            }

            localStorage.setItem("username", data.username);
            localStorage.setItem("role", data.role);

            window.location.href = "/index.html";
        } catch (error) {
            message.textContent = error.message;
            message.className = "login-message error";
        }
    });
});