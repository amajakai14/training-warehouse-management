async function fetchMenus() {
  const menus = await fetch("http://localhost:8080/menus");
  if (!menus.ok) {
    throw new Error("Could not fetch menus");
  }
  const menusJson = await menus.json();
  console.log(menusJson);
  renderMenus(menusJson);
}

function renderMenus(menusJson) {
  const menus = document.getElementById("menu-list");
  if (!menus) {
    throw new Error("Could not find orders element");
  }
  menus.innerHTML = "";
  const menuTable = document.createElement("table");
  menuTable.innerHTML = "<th>Menu ID</th><th>Menu Name</th>";
  menusJson.menus.forEach((menu) => {
    menuTable.innerHTML += `
    <tr>
      <td>${menu.id}</td>
      <td>${menu.name}</td>
    </th>
    `;
    menus.appendChild(menuTable);
  });
}
