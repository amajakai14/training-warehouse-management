var login = false;

function LoginComponent() {
  if (!login) return "<button onclick='login()'> Log in </button>";
  return "<div> You are logged in </div>";
}

function login() {
  login = true;
}
