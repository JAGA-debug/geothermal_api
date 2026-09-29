const DASH_MODULES = [
    { title: "Boreholes", icon: "🕳️", endpoint: "/boreholes", module: "boreholes", admin: true },
    { title: "Heat Pumps", icon: "♨️", endpoint: "/heatpumps", module: "heatpumps", admin: true },
    { title: "Geothermal Loops", icon: "🔄", endpoint: "/geothermal/loops", module: "loops", admin: true },
    { title: "Telemetry", icon: "📡", endpoint: "/geothermal/telemetry", module: "telemetry", admin: true },
    { title: "Customers", icon: "🏠", endpoint: "/customers", module: "customers", admin: false },
    { title: "Invoices", icon: "🧾", endpoint: "/invoices", module: "invoices", admin: false },
    { title: "Reports", icon: "📊", endpoint: null, module: null, reports: true }
];

document.addEventListener("DOMContentLoaded", async () => {
    const session = requireLogin();
    if (!session) return;

    document.getElementById("topUsername").textContent = session.username;
    document.getElementById("topRole").textContent = roleLabel(session.role);

    buildSidebar(session.role);
    buildQuickCards(session.role);

    await loadCount("/boreholes", "boreholeCount");
    await loadCount("/heatpumps", "heatpumpCount");
    await loadCount("/customers", "customerCount");
    await loadCount("/invoices", "invoiceCount");
});

function buildSidebar(role) {
    const sidebar = document.getElementById("sidebar");
    sidebar.innerHTML = `
        <div class="brand">
            <div class="brand-icon">🌱</div>
            <div><strong>GeoThermal</strong><span>Energy Management</span></div>
        </div>
        <nav>
            <a class="nav-link active" href="/index.html">🏠 Dashboard</a>
            <div class="nav-title">ADMIN</div>
            ${role === "ADMIN" ? `
                <a class="nav-link" href="/management.html?module=boreholes">🕳️ Boreholes</a>
                <a class="nav-link" href="/management.html?module=heatpumps">♨️ Heat Pumps</a>
                <a class="nav-link" href="/management.html?module=loops">🔄 Geothermal Loops</a>
                <a class="nav-link" href="/management.html?module=cop">📊 COP Baselines</a>
                <a class="nav-link" href="/management.html?module=telemetry">📡 Telemetry</a>
                <a class="nav-link" href="/management.html?module=accounts">💰 Accounts</a>
                <a class="nav-link" href="/management.html?module=journals">📚 Journals</a>
                <a class="nav-link" href="/management.html?module=journalEntries">📒 Journal Entries</a>
                <a class="nav-link" href="/management.html?module=analyticAccounts">📈 Analytic Accounts</a>
                <a class="nav-link" href="/management.html?module=budgets">🎯 Budgets</a>
                <a class="nav-link" href="/management.html?module=users">👥 Users</a>
            ` : `<div class="role-note">Admin modules are hidden for this role.</div>`}
            <div class="nav-title">INVOICING</div>
            <a class="nav-link" href="/management.html?module=customers">🏠 Customers</a>
            <a class="nav-link" href="/management.html?module=vendors">🚚 Vendors</a>
            <a class="nav-link" href="/management.html?module=products">📦 Products</a>
            <a class="nav-link" href="/management.html?module=salesOrders">📝 Sales Orders</a>
            <a class="nav-link" href="/management.html?module=invoices">🧾 Customer Invoices</a>
            <a class="nav-link" href="/management.html?module=payments">💳 Customer Payments</a>
            <a class="nav-link" href="/management.html?module=purchaseOrders">📋 Purchase Orders</a>
            <a class="nav-link" href="/management.html?module=vendorBills">🧾 Vendor Bills</a>
            <a class="nav-link" href="/management.html?module=vendorPayments">💵 Vendor Payments</a>
            <div class="nav-title">REPORTS</div>
            <a class="nav-link" href="/reports.html">📊 Reports</a>
        </nav>
        <button class="logout-btn" onclick="logout()">🚪 Logout</button>
    `;
}

function buildQuickCards(role) {
    const grid = document.getElementById("quickGrid");
    grid.innerHTML = DASH_MODULES
        .filter(m => (!m.admin || role === "ADMIN") || m.reports)
        .map(m => `
            <a class="quick-card" href="${m.reports ? "/reports.html" : `/management.html?module=${m.module}`}">
                <div class="quick-icon">${m.icon}</div>
                <div><strong>${m.title}</strong><span>Open module →</span></div>
            </a>
        `).join("");
}

async function loadCount(endpoint, elementId) {
    try {
        const data = await API.get(endpoint);
        document.getElementById(elementId).textContent = Array.isArray(data) ? data.length : "0";
    } catch {
        document.getElementById(elementId).textContent = "—";
    }
}