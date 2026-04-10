import { useEffect, useState } from "react";
import axios from "axios";
import Navbar from "./Navbar";

function Profile() {
  const [profile, setProfile] = useState(null);

  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("user"));

    if (user) {
      axios.get(`http://localhost:8081/api/user/${user.id}`)
        .then(res => setProfile(res.data));
    }
  }, []);

  return (
    <div>
      <Navbar />

      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h2>👤 User Profile</h2>

        {profile && (
          <>
            <p>Username: {profile.username}</p>
            <p>Email: {profile.email}</p>
          </>
        )}
      </div>
    </div>
  );
}

export default Profile;