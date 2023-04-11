/*
 * after DOM is loaded, we call the fetchOrders function
 * so you dont need to click the button to show anymore
 */
document.addEventListener("DOMContentLoaded", fetchOrders());

async function fetchOrders() {
  const orders = await fetch("http://localhost:8080/orders");
  if (!orders.ok) {
    throw new Error("Could not fetch orders");
  }
  const ordersJson = await orders.json();
  console.log(ordersJson);
  renderOrders(ordersJson);
}

/*
 * we add a button to the table when we called the renderOrders function
 */
function renderOrders(ordersJson) {
  const orders = document.getElementById("order-list");
  if (!orders) {
    throw new Error("Could not find orders element");
  }
  orders.innerHTML = "";
  const orderDiv = document.createElement("table");
  orderDiv.innerHTML =
    "<th>Order ID</th><th>Item ID</th><th>Order Name</th><th>Order Amount</th><th>Order Status</th><th>Order Date</th>";
  ordersJson.orders.forEach((order) => {
    orderDiv.innerHTML += `
    <tr>
      <td>${order.id}</td>
      <td>${order.itemId}</td>
      <td>${order.name}</td>
      <td>${order.amount}</td>
      <td>${order.orderStatus}</td>
      <td>${order.orderDate}</td>
      <td>
      <button onclick="renderOrder(${order.id})">Edit</button>
      <button onclick="handleDeleteOrder(${order.id})">Delete</button>
      </td>
    </th>
    `;
    orders.appendChild(orderDiv);
  });
}
async function handleRegisterOrder(event) {
  event.preventDefault();
  const form = event.target.form;
  const formData = new FormData(form);
  const order = {
    itemId: formData.get("itemId"),
    name: formData.get("name"),
    amount: formData.get("amount"),
    orderStatus: formData.get("orderStatus"),
    orderDate: formData.get("orderDate"),
  };

  const response = await fetch("http://localhost:8080/orders", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(order),
  });
  if (!response.ok) {
    const error = await response.json();
    console.error(error);
    return;
  }

  fetchOrders();
}

async function fetchOrder(id) {
  const response = await fetch(`http://localhost:8080/orders/${id}`);
  if (!response.ok) {
    throw new Error("Could not fetch order");
  }
  return await response.json();
}

async function renderOrder(id) {
  const order = await fetchOrder(id);
  const orderDiv = document.getElementById("order-modal-component");
  orderDiv.innerHTML = `
  <form>
    <div> order id: ${order.id}</div>
    <label for="itemId">Item ID</label>
    <input type="text" name="itemId" value="${order.itemId}"/>
    <label for="name">Name</label>
    <input type="text" name="name" value="${order.name}"/>
    <label for="amount">Amount</label>
    <input type="number" name="amount" value="${order.amount}"/>
    <label for="orderStatus">orderStatus</label>
    <input type="text" name="orderStatus" value="${order.orderStatus}"/>
    <label for="orderDate">Amount</label>
    <input type="date" name="orderDate" value="${order.orderDate}"/>
    <button type="submit" onclick="handleUpdateOrder(event, ${order.id})">Update</button>
  </form>
  `;
  document.getElementById("myModal").style.display = "block";
}

async function handleUpdateOrder(event, id) {
  event.preventDefault();
  const form = event.target.form;
  const formData = new FormData(form);
  const order = {
    name: formData.get("name"),
    itemId: formData.get("itemId"),
    amount: formData.get("amount"),
    orderStatus: formData.get("orderStatus"),
    orderDate: formData.get("orderDate"),
  };

  const response = await fetch(`http://localhost:8080/orders/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(order),
  });

  if (!response.ok) {
    const result = await response.json();
    throw new Error(result.message);
  } else {
    await fetchOrders();
    document.getElementById("myModal").style.display = "none";
  }
}

/*
 * Exercise Implement the Java delete Controller
 */
async function handleDeleteOrder(id) {
  const response = await fetch(`http://localhost:8080/orders/${id}`, {
    method: "DELETE",
  });
  if (!response.ok) {
    throw new Error("Could not delete order");
  }
  fetchOrders();
}