const MODULES = {
    boreholes: {
        title: "Boreholes", subtitle: "Manage geothermal borehole fields.", endpoint: "/boreholes",
        fields: [
            ["boreholeName","Borehole Name","text",true],["location","Location","text",true],
            ["depthMeters","Depth (meters)","number",true],["status","Status","select",true,["Active","Inactive","Maintenance"]]
        ], columns: ["id","boreholeName","location","depthMeters","status"]
    },
    heatpumps: {
        title: "Heat Pumps", subtitle: "Manage ground-source heat pumps.", endpoint: "/heatpumps",
        fields: [["pumpName","Pump Name","text",true],["capacityKw","Capacity (kW)","number",true],["status","Status","select",true,["Active","Inactive","Maintenance"]]],
        columns: ["id","pumpName","capacityKw","status"]
    },
    loops: {
        title: "Geothermal Loops", subtitle: "Manage shared geothermal loops.", endpoint: "/geothermal/loops",
        fields: [
            ["loopName","Loop Name","text",true],["zoneName","Zone Name","text",true],
            ["borehole","Borehole","relation",true,"/boreholes","boreholeName"],
            ["heatpump","Heat Pump","relation",true,"/heatpumps","pumpName"],
            ["flowRate","Flow Rate","number",true],["status","Status","select",true,["Active","Inactive","Maintenance"]],
            ["description","Description","textarea",false]
        ], columns: ["id","loopName","zoneName","borehole","heatpump","flowRate","status","description"]
    },
    cop: {
        title: "COP Baselines", subtitle: "Configure seasonal coefficient of performance baselines.", endpoint: "/api/geothermal/cop-baselines".replace("/api",""),
        fields: [["loop","Geothermal Loop","relation",true,"/geothermal/loops","loopName"],["season","Season","select",true,["Summer","Winter","Spring","Autumn"]],["copValue","COP Value","number",true],["year","Year","number",true]],
        columns: ["id","loop","season","copValue","year"]
    },
    telemetry: {
        title: "Telemetry", subtitle: "Monitor flow and supply/return temperature readings.", endpoint: "/api/geothermal/telemetry".replace("/api",""),
        fields: [
            ["loop","Geothermal Loop","relation",true,"/geothermal/loops","loopName"],["readingDate","Reading Date","datetime",true],
            ["flowRate","Flow Rate","number",true],["supplyTemperature","Supply Temperature","number",true],
            ["returnTemperature","Return Temperature","number",true],["energyGj","Energy (GJ)","number",true],
            ["notes","Notes","textarea",false]
        ], columns: ["id","loop","readingDate","flowRate","supplyTemperature","returnTemperature","energyGj","notes"]
    },
    accounts: {
        title: "Chart of Accounts", subtitle: "Manage financial accounts.", endpoint: "/accounts",
        fields: [["accountCode","Account Code","text",true],["accountName","Account Name","text",true],
            ["accountType","Account Type","select",true,["ASSET","LIABILITY","INCOME","EXPENSE"]],
            ["description","Description","textarea",false],["status","Status","select",true,["Active","Inactive"]]],
        columns: ["id","accountCode","accountName","accountType","status"]
    },
    journals: {
        title: "Journals", subtitle: "Manage accounting journals.", endpoint: "/journals",
        fields: [["journalName","Journal Name","text",true],["journalType","Journal Type","select",true,["Sales","Purchase","Cash","Bank"]],
            ["description","Description","textarea",false],["status","Status","select",true,["Active","Inactive"]]],
        columns: ["id","journalName","journalType","description","status"]
    },
    journalEntries: {
        title: "Journal Entries", subtitle: "Manage accounting journal entries.", endpoint: "/journal-entries",
        fields: [["journal","Journal","relation",true,"/journals","journalName"],["entryDate","Entry Date","date",true],
            ["referenceType","Reference Type","text",false],["referenceId","Reference ID","number",false],
            ["description","Description","textarea",false]],
        columns: ["id","journal","entryDate","referenceType","referenceId","description"]
    },
    analyticAccounts: {
        title: "Analytic Accounts", subtitle: "Track geothermal loop zones.", endpoint: "/analytic-accounts",
        fields: [["code","Code","text",true],["name","Name","text",true],["zoneName","Zone Name","text",true],
            ["loop","Geothermal Loop","relation",false,"/geothermal/loops","loopName"],["description","Description","textarea",false],
            ["status","Status","select",true,["Active","Inactive"]]],
        columns: ["id","code","name","zoneName","loop","description","status"]
    },
    budgets: {
        title: "Budgets", subtitle: "Manage planned network operating funds.", endpoint: "/budgets",
        fields: [["analyticAccount","Analytic Account","relation",true,"/analytic-accounts","name"],["year","Year","number",true],
            ["category","Category","select",true,["Electricity","Glycol Restock","Energy Sales","Other"]],
            ["plannedAmount","Planned Amount","number",true],["notes","Notes","textarea",false]],
        columns: ["id","analyticAccount","year","category","plannedAmount","notes"]
    },
    users: {
        title: "Users", subtitle: "Manage network login users.", endpoint: "/users",
        fields: [["username","Username","text",true],["password","Password","password",true],["role","Role","select",true,["ADMIN","INVOICING_USER"]],
            ["status","Status","select",true,["Active","Inactive"]]],
        columns: ["id","username","role","status"]
    },
    customers: {
        title: "Customers", subtitle: "Manage residential homeowner associations.", endpoint: "/customers",
        fields: [["name","Customer Name","text",true],["address","Address","text",true],["contact","Contact","text",true],["email","Email","email",false]],
        columns: ["id","name","address","contact","email"]
    },
    vendors: {
        title: "Vendors", subtitle: "Manage geothermal vendors.", endpoint: "/vendors",
        fields: [["name","Vendor Name","text",true],["address","Address","text",true],["contact","Contact","text",true],["email","Email","email",false]],
        columns: ["id","name","address","contact","email"]
    },
    products: {
        title: "Products", subtitle: "Manage geothermal goods and services.", endpoint: "/products",
        fields: [["name","Product Name","text",true],["type","Type","select",true,["Goods","Service"]],
            ["unit","Unit","text",true],["price","Price","number",true],["description","Description","textarea",false]],
        columns: ["id","name","type","unit","price","description"]
    },
    salesOrders: {
        title: "Sales Orders", subtitle: "Manage seasonal heating/cooling supply orders.", endpoint: "/sales-orders",
        fields: [["orderNumber","Order Number","text",true],["customer","Customer","relation",true,"/customers","name"],
            ["orderDate","Order Date","date",true],["status","Status","select",true,["Draft","Confirmed","Cancelled","Completed"]],
            ["totalAmount","Total Amount","number",true],["notes","Notes","textarea",false]],
        columns: ["id","orderNumber","customer","orderDate","status","totalAmount","notes"]
    },
    salesOrderItems: {
        title: "Sales Order Items", subtitle: "Manage sales order line items.", endpoint: "/sales-order-items",
        fields: [["salesOrder","Sales Order","relation",true,"/sales-orders","orderNumber"],["product","Product","relation",true,"/products","name"],
            ["quantity","Quantity","number",true],["unitPrice","Unit Price","number",true],["totalAmount","Total Amount","number",true]],
        columns: ["id","salesOrder","product","quantity","unitPrice","totalAmount"]
    },
    invoices: {
        title: "Customer Invoices", subtitle: "Manage thermal energy invoices.", endpoint: "/invoices",
        fields: [["invoiceNumber","Invoice Number","text",true],["customer","Customer","relation",true,"/customers","name"],
            ["salesOrder","Sales Order","relation",false,"/sales-orders","orderNumber"],["telemetry","Telemetry","relation",false,"/geothermal/telemetry","id"],
            ["invoiceDate","Invoice Date","date",true],["energyGj","Energy (GJ)","number",true],["amount","Amount","number",true],
            ["status","Status","select",true,["Unpaid","Paid","Cancelled"]],["notes","Notes","textarea",false]],
        columns: ["id","invoiceNumber","customer","salesOrder","telemetry","invoiceDate","energyGj","amount","status"]
    },
    payments: {
        title: "Customer Payments", subtitle: "Record customer payments.", endpoint: "/payments",
        fields: [["invoice","Invoice","relation",true,"/invoices","invoiceNumber"],["paymentDate","Payment Date","date",true],
            ["amount","Amount","number",true],["paymentMethod","Payment Method","select",true,["BANK_TRANSFER","CASH","CARD","OTHER"]],
            ["status","Status","select",true,["Pending","Paid","Cancelled"]],["reference","Reference","text",false]],
        columns: ["id","invoice","paymentDate","amount","paymentMethod","status","reference"]
    },
    purchaseOrders: {
        title: "Purchase Orders", subtitle: "Manage vendor purchase orders.", endpoint: "/purchase-orders",
        fields: [["poNumber","PO Number","text",true],["vendor","Vendor","relation",true,"/vendors","name"],["orderDate","Order Date","date",true],
            ["status","Status","select",true,["Draft","Confirmed","Cancelled","Completed"]],["totalAmount","Total Amount","number",true],["notes","Notes","textarea",false]],
        columns: ["id","poNumber","vendor","orderDate","status","totalAmount","notes"]
    },
    purchaseOrderItems: {
        title: "Purchase Order Items", subtitle: "Manage purchase order line items.", endpoint: "/purchase-order-items",
        fields: [["purchaseOrder","Purchase Order","relation",true,"/purchase-orders","poNumber"],["product","Product","relation",true,"/products","name"],
            ["quantity","Quantity","number",true],["unitPrice","Unit Price","number",true],["totalAmount","Total Amount","number",true]],
        columns: ["id","purchaseOrder","product","quantity","unitPrice","totalAmount"]
    },
    vendorBills: {
        title: "Vendor Bills", subtitle: "Manage vendor bills.", endpoint: "/vendor-bills",
        fields: [["billNumber","Bill Number","text",true],["vendor","Vendor","relation",true,"/vendors","name"],
            ["purchaseOrder","Purchase Order","relation",false,"/purchase-orders","poNumber"],["billDate","Bill Date","date",true],
            ["dueDate","Due Date","date",true],["amount","Amount","number",true],["status","Status","select",true,["Unpaid","Paid","Cancelled"]],
            ["notes","Notes","textarea",false]],
        columns: ["id","billNumber","vendor","purchaseOrder","billDate","dueDate","amount","status"]
    },
    vendorPayments: {
        title: "Vendor Payments", subtitle: "Record vendor payments.", endpoint: "/vendor-payments",
        fields: [["vendorBill","Vendor Bill","relation",true,"/vendor-bills","billNumber"],["paymentDate","Payment Date","date",true],
            ["amount","Amount","number",true],["paymentMethod","Payment Method","select",true,["BANK","CASH","OTHER"]],
            ["status","Status","select",true,["Pending","Paid","Cancelled"]],["reference","Reference","text",false]],
        columns: ["id","vendorBill","paymentDate","amount","paymentMethod","status","reference"]
    }
};

let currentModule = null;
let records = [];
let editingId = null;

document.addEventListener("DOMContentLoaded", async () => {
    const session = requireLogin();
    if (!session) return;

    document.getElementById("topUsername").textContent = session.username;
    document.getElementById("topRole").textContent = roleLabel(session.role);
    buildManagementSidebar(session.role);

    const requested = new URLSearchParams(window.location.search).get("module") || "boreholes";
    if (!MODULES[requested]) {
        window.history.replaceState({}, "", "/management.html?module=boreholes");
        currentModule = "boreholes";
    } else {
        currentModule = requested;
    }

    if (session.role !== "ADMIN" && [
        "boreholes","heatpumps","loops","cop","telemetry","accounts","journals",
        "journalEntries","analyticAccounts","budgets","users"
    ].includes(currentModule)) {
        currentModule = "customers";
        window.history.replaceState({}, "", "/management.html?module=customers");
    }

    document.getElementById("addBtn").addEventListener("click", () => openModal());
    document.getElementById("searchInput").addEventListener("input", filterTable);
    document.getElementById("recordForm").addEventListener("submit", saveRecord);
    document.getElementById("closeModal").addEventListener("click", closeModal);
    document.getElementById("cancelBtn").addEventListener("click", closeModal);
    document.getElementById("modal").addEventListener("click", e => {
        if (e.target.id === "modal") closeModal();
    });

    await loadModule();
});

function buildManagementSidebar(role) {
    const sidebar = document.getElementById("sidebar");
    sidebar.innerHTML = `
        <div class="brand">
            <div class="brand-icon">🌱</div>
            <div><strong>GeoThermal</strong><span>Energy Management</span></div>
        </div>
        <nav>
            <a class="nav-link" href="/index.html">🏠 Dashboard</a>
            ${role === "ADMIN" ? `
            <div class="nav-title">ADMIN</div>
            <a class="nav-link" href="?module=boreholes">🕳️ Boreholes</a>
            <a class="nav-link" href="?module=heatpumps">♨️ Heat Pumps</a>
            <a class="nav-link" href="?module=loops">🔄 Geothermal Loops</a>
            <a class="nav-link" href="?module=cop">📊 COP Baselines</a>
            <a class="nav-link" href="?module=telemetry">📡 Telemetry</a>
            <a class="nav-link" href="?module=accounts">💰 Accounts</a>
            <a class="nav-link" href="?module=journals">📚 Journals</a>
            <a class="nav-link" href="?module=journalEntries">📒 Journal Entries</a>
            <a class="nav-link" href="?module=analyticAccounts">📈 Analytic Accounts</a>
            <a class="nav-link" href="?module=budgets">🎯 Budgets</a>
            <a class="nav-link" href="?module=users">👥 Users</a>
            ` : ""}
            <div class="nav-title">INVOICING</div>
            <a class="nav-link" href="?module=customers">🏠 Customers</a>
            <a class="nav-link" href="?module=vendors">🚚 Vendors</a>
            <a class="nav-link" href="?module=products">📦 Products</a>
            <a class="nav-link" href="?module=salesOrders">📝 Sales Orders</a>
            <a class="nav-link" href="?module=invoices">🧾 Customer Invoices</a>
            <a class="nav-link" href="?module=payments">💳 Customer Payments</a>
            <a class="nav-link" href="?module=purchaseOrders">📋 Purchase Orders</a>
            <a class="nav-link" href="?module=purchaseOrderItems">📦 PO Items</a>
            <a class="nav-link" href="?module=vendorBills">🧾 Vendor Bills</a>
            <a class="nav-link" href="?module=vendorPayments">💵 Vendor Payments</a>
            <div class="nav-title">REPORTS</div>
            <a class="nav-link" href="/reports.html">📊 Reports</a>
        </nav>
        <button class="logout-btn" onclick="logout()">🚪 Logout</button>
    `;

    sidebar.querySelectorAll(".nav-link").forEach(a => {
        if (a.href.includes(`module=${currentModule}`)) a.classList.add("active");
    });
}

async function loadModule() {
    const config = MODULES[currentModule];
    document.getElementById("pageTitle").textContent = config.title;
    document.getElementById("pageSubtitle").textContent = config.subtitle;
    document.getElementById("searchInput").value = "";
    clearMessage();

    try {
        records = await API.get(config.endpoint);
        if (!Array.isArray(records)) records = [];
        renderTable(records);
    } catch (error) {
        records = [];
        renderTable([]);
        showMessage("Unable to load data: " + error.message, "error");
    }
}

function renderTable(data) {
    const config = MODULES[currentModule];
    const head = document.getElementById("tableHead");
    const body = document.getElementById("tableBody");
    const empty = document.getElementById("emptyState");

    head.innerHTML = `<tr>${config.columns.map(c => `<th>${label(c)}</th>`).join("")}<th>Actions</th></tr>`;

    if (!data.length) {
        body.innerHTML = "";
        empty.classList.remove("hidden");
        return;
    }

    empty.classList.add("hidden");
    body.innerHTML = data.map(row => `
        <tr>
            ${config.columns.map(c => `<td>${formatValue(row[c], c)}</td>`).join("")}
            <td class="actions">
                <button class="table-btn edit" onclick="openModal(${Number(row.id)})">Edit</button>
                <button class="table-btn delete" onclick="deleteRecord(${Number(row.id)})">Delete</button>
            </td>
        </tr>
    `).join("");
}

function formatValue(value, fieldName) {
    if (value === null || value === undefined || value === "") return "—";

    if (typeof value === "object") {
        if (value.name) return escapeHtml(value.name);
        if (value.loopName) return escapeHtml(value.loopName);
        if (value.pumpName) return escapeHtml(value.pumpName);
        if (value.boreholeName) return escapeHtml(value.boreholeName);
        if (value.orderNumber) return escapeHtml(value.orderNumber);
        if (value.poNumber) return escapeHtml(value.poNumber);
        if (value.billNumber) return escapeHtml(value.billNumber);
        if (value.invoiceNumber) return escapeHtml(value.invoiceNumber);
        if (value.journalName) return escapeHtml(value.journalName);
        if (value.accountName) return escapeHtml(value.accountName);
        return escapeHtml(String(value.id ?? JSON.stringify(value)));
    }

    if (fieldName === "status") return `<span class="status ${String(value).toLowerCase()}">${escapeHtml(value)}</span>`;
    if (typeof value === "number" && /amount|price|cost|planned|debit|credit|energyGj|copValue|flowRate|temperature|depthMeters|capacityKw|quantity|unitPrice|totalAmount/.test(fieldName)) {
        return Number(value).toLocaleString("en-IN", { maximumFractionDigits: 2 });
    }
    return escapeHtml(String(value));
}

function label(text) {
    return text.replace(/([A-Z])/g, " $1").replace(/^./, s => s.toUpperCase());
}

async function openModal(id = null) {
    editingId = id;
    const config = MODULES[currentModule];
    document.getElementById("modalTitle").textContent = id ? `Edit ${config.title}` : `Add ${config.title}`;
    document.getElementById("formFields").innerHTML = "";
    document.getElementById("modal").classList.remove("hidden");

    const record = id ? records.find(r => Number(r.id) === Number(id)) : null;

    for (const field of config.fields) {
        const [name, title, type, required, optionsOrEndpoint, displayField] = field;
        const group = document.createElement("div");
        group.className = "field-group" + (type === "textarea" ? " full" : "");

        const labelEl = document.createElement("label");
        labelEl.textContent = title;
        labelEl.htmlFor = `field-${name}`;
        group.appendChild(labelEl);

        let input;
        const value = record ? getRecordValue(record, name) : "";

        if (type === "select") {
            input = document.createElement("select");
            input.innerHTML = `<option value="">Select ${title}</option>` +
                optionsOrEndpoint.map(o => `<option value="${escapeAttr(o)}">${escapeHtml(o)}</option>`).join("");
            input.value = value ?? "";
        } else if (type === "relation") {
            input = document.createElement("select");
            input.innerHTML = `<option value="">Loading...</option>`;
            try {
                const list = await API.get(optionsOrEndpoint);
                const rows = Array.isArray(list) ? list : [];
                const display = displayField || "name";
                input.innerHTML = `<option value="">Select ${title}</option>` +
                    rows.map(r => `<option value="${Number(r.id)}">${escapeHtml(String(r[display] ?? r.name ?? r.id))}</option>`).join("");
                if (value !== null && value !== undefined && value !== "") input.value = String(value);
            } catch {
                input.innerHTML = `<option value="">Unable to load options</option>`;
            }
        } else {
            input = document.createElement(type === "textarea" ? "textarea" : "input");
            if (type !== "textarea") input.type = type;
            input.value = value ?? "";
            if (type === "datetime" && input.value) input.value = String(input.value).slice(0,16);
        }

        input.id = `field-${name}`;
        input.name = name;
        input.required = !!required;
        if (type === "number") input.step = "any";
        group.appendChild(input);
        document.getElementById("formFields").appendChild(group);
    }
}

function getRecordValue(record, field) {
    const value = record[field];
    if (value && typeof value === "object") return value.id ?? "";
    return value ?? "";
}

async function saveRecord(event) {
    event.preventDefault();
    const config = MODULES[currentModule];
    const form = new FormData(event.target);
    const payload = {};

    for (const field of config.fields) {
        const [name, , type] = field;
        const raw = form.get(name);

        if (type === "relation") {
            payload[name] = raw ? { id: Number(raw) } : null;
        } else if (type === "number") {
            payload[name] = raw === "" ? null : Number(raw);
        } else {
            payload[name] = raw;
        }
    }

    try {
        if (editingId) {
            await API.put(`${config.endpoint}/${editingId}`, payload);
            showMessage("Record updated successfully.", "success");
        } else {
            await API.post(config.endpoint, payload);
            showMessage("Record added successfully.", "success");
        }

        closeModal();
        await loadModule();
    } catch (error) {
        showMessage("Save failed: " + error.message, "error");
    }
}

async function deleteRecord(id) {
    const config = MODULES[currentModule];
    if (!confirm(`Delete this ${config.title} record?`)) return;

    try {
        await API.delete(`${config.endpoint}/${id}`);
        showMessage("Record deleted successfully.", "success");
        await loadModule();
    } catch (error) {
        showMessage("Delete failed: " + error.message, "error");
    }
}

function filterTable() {
    const q = document.getElementById("searchInput").value.toLowerCase().trim();
    if (!q) {
        renderTable(records);
        return;
    }

    const filtered = records.filter(row => JSON.stringify(row).toLowerCase().includes(q));
    renderTable(filtered);
}

function closeModal() {
    document.getElementById("modal").classList.add("hidden");
    document.getElementById("recordForm").reset();
    editingId = null;
}

function showMessage(text, type) {
    const box = document.getElementById("message");
    box.textContent = text;
    box.className = `message ${type}`;
    clearTimeout(window.messageTimer);
    window.messageTimer = setTimeout(clearMessage, 4000);
}

function clearMessage() {
    const box = document.getElementById("message");
    box.textContent = "";
    box.className = "message hidden";
}

function escapeHtml(value) {
    return String(value)
        .replaceAll("&","&amp;").replaceAll("<","&lt;").replaceAll(">","&gt;")
        .replaceAll('"',"&quot;").replaceAll("'","&#039;");
}

function escapeAttr(value) {
    return escapeHtml(value);
}