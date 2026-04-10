import { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";
import "../App.css";

function Register() {
  const [user, setUser] = useState({
    username: "",
    password: "",
    email: ""
  });

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const trimmedUser = {
      username: user.username.trim(),
      password: user.password.trim(),
      email: user.email.trim()
    };
    await axios.post("http://localhost:8081/api/register", trimmedUser);
    navigate("/login");
  };

  return (
    <div className="container">
      <h1>🚀 SKILL 14 Register</h1>

      <form onSubmit={handleSubmit}>
        <input placeholder="Username"
          onChange={(e)=>setUser({...user, username:e.target.value})}/>

        <input placeholder="Email"
          onChange={(e)=>setUser({...user, email:e.target.value})}/>

        <input type="password" placeholder="Password"
          onChange={(e)=>setUser({...user, password:e.target.value})}/>

        <button>Register</button>
      </form>

      <p>Already have account? <Link to="/login">Login</Link></p>
    </div>
  );
}

export default Register;