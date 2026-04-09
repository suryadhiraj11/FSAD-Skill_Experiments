import { Link } from "react-router-dom";

function Dashboard() {
  return (
    <div>
      <h1>Dashboard</h1>

      <Link to="/local">Local Users</Link><br />
      <Link to="/api">Users API</Link><br />
      <Link to="/posts">Fake Posts</Link>
    </div>
  );
}

export default Dashboard;