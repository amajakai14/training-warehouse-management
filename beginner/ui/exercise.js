async function fetchMenus() {
  const menus = await fetch("http://localhost:8080/menus");
  if (!menus.ok) {
    console.log(menus);
    throw new Error("Could not fetch menus");
  }
  const menusJson = await menus.json();
  console.log(menusJson);
  renderMenus(menusJson);
}

function renderMenus(menusJson) {
  const menus = document.getElementById("menu-list");
  if (!menus) {
    throw new Error("Could not find menus element");
  }
  menus.innerHTML = "";
  const menuTable = document.createElement("table");
  menuTable.innerHTML = "<th>Menu ID</th><th>Menu Name</th>";
  menusJson.menus.forEach((menu) => {
    menuTable.innerHTML += `
    <tr>
      <td>${menu.id}</td>
      <td>${menu.name}</td>
      <td>
      <button onclick="renderMenu(${menu.id})">Edit</button>
      </td>
    </th>
    `;
    menus.appendChild(menuTable);
  });
}

async function renderMenu(id) {
  const menu = await fetchMenu(id);
  const orderDiv = document.getElementById("menu-modal-component");
  orderDiv.innerHTML = `
  <form>
    <div> order id: ${menu.id}</div>
    <label for="itemId">Item ID</label>
    <input type="text" name="name" value="${menu.name}"/>
    <label for="amount">Amount</label>
    <button type="submit" onclick="handleUpdateOrder(event, ${menu.id})">Update</button>
  </form>
  `;
  document.getElementById("myMenu").style.display = "block";
}

async function fetchMenu(id) {
  // this should work after java logic has been implemented
  const response = await fetch(`http://localhost:8080/menus/${id}`);
  if (!response.ok) {
    throw new Error("Could not fetch menu");
  }
  return await response.json();
}

async function handleUpdateMenu(event, id) {
  event.preventDefault();
  //TODO update menu
}
