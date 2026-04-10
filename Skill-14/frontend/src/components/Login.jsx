import { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "../App.css";

function Login() {
  const [user, setUser] = useState({ username: "", password: "" });
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    const trimmedUser = {
      username: user.username.trim(),
      password: user.password.trim()
    };

    const res = await axios.post("http://localhost:8081/api/login", trimmedUser);

    if (res.data) {
      localStorage.setItem("user", JSON.stringify(res.data));
      navigate("/home");
    } else {
      alert("Invalid credentials");
    }
  };

  return (
    <div className="container">
      <h1>🚀 SKILL 14 Login</h1>

      <form onSubmit={handleLogin}>
        <input placeholder="Username"
          onChange={(e)=>setUser({...user, username:e.target.value})}/>

        <input type="password" placeholder="Password"
          onChange={(e)=>setUser({...user, password:e.target.value})}/>

        <button>Login</button>
      </form>

      <p>Don't have account? <Link to="/register">Register</Link></p>
    </div>
  );
}

export default Login;