document.addEventListener("DOMContentLoaded", async () => {
    const session = requireLogin();
    if (!session) return;

    document.getElementById("topUsername").textContent = session.username;
    document.getElementById("topRole").textContent = roleLabel(session.role);
    buildSidebar(session.role);

    await Promise.all([loadBalanceSheet(), loadProfitLoss(), loadBudget()]);
});

function money(value) {
    const n = Number(value || 0);
    return "₹" + n.toLocaleString("en-IN", { minimumFractionDigits: 2, maximumFractionDigits: 2 });
}

async function loadBalanceSheet() {
    try {
        const d = await API.get("/reports/balance-sheet");
        document.getElementById("assets").textContent = money(d.totalAssets);
        document.getElementById("liabilities").textContent = money(d.totalLiabilities);
        document.getElementById("cash").textContent = money(d.cashBank);
    } catch (e) {
        showReportError(e.message);
    }
}

async function loadProfitLoss() {
    try {
        const d = await API.get("/reports/profit-loss");
        document.getElementById("income").textContent = money(d.totalIncome);
        document.getElementById("expenses").textContent = money(d.totalExpenses);
        document.getElementById("profit").textContent = money(d.netProfit);
    } catch (e) {
        showReportError(e.message);
    }
}

async function loadBudget() {
    try {
        const d = await API.get("/reports/budget");
        document.getElementById("planned").textContent = money(d.plannedAmount);
        document.getElementById("actual").textContent = money(d.actualAmount);
        document.getElementById("remaining").textContent = money(d.remainingAmount);
    } catch (e) {
        showReportError(e.message);
    }
}

function showReportError(message) {
    const box = document.getElementById("reportMessage");
    box.textContent = "Report error: " + message;
    box.className = "message error";
}