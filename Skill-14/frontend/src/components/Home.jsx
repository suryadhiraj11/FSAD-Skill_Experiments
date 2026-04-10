import { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("user");
    if (!user) navigate("/login");
  }, []);

  return (
    <div>
      <Navbar />
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h1>🎉 Welcome to Home Page</h1>
      </div>
    </div>
  );
}

export default Home;