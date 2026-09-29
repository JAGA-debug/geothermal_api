const API = {
    base: "/api",

    async request(path, options = {}) {
        const response = await fetch(this.base + path, {
            headers: { "Content-Type": "application/json", ...(options.headers || {}) },
            ...options
        });

        const text = await response.text();
        let data = null;
        try { data = text ? JSON.parse(text) : null; } catch { data = text; }

        if (!response.ok) {
            const message = data?.message || data?.error || (typeof data === "string" ? data : `HTTP ${response.status}`);
            throw new Error(message);
        }
        return data;
    },

    get(path) { return this.request(path); },

    post(path, body) {
        return this.request(path, { method: "POST", body: JSON.stringify(body) });
    },

    put(path, body) {
        return this.request(path, { method: "PUT", body: JSON.stringify(body) });
    },

    delete(path) {
        return this.request(path, { method: "DELETE" });
    }
};

function getSession() {
    return {
        username: localStorage.getItem("username") || "",
        role: localStorage.getItem("role") || ""
    };
}

function requireLogin() {
    const session = getSession();
    if (!session.username || !session.role) {
        window.location.href = "/login.html";
        return null;
    }
    return session;
}

function logout() {
    localStorage.removeItem("username");
    localStorage.removeItem("role");
    window.location.href = "/login.html";
}

function roleLabel(role) {
    return role === "ADMIN" ? "Network Manager" : "Invoicing User";
}