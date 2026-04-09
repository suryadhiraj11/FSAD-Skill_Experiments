import { useEffect, useState } from "react";

function UserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then(res => res.json())
      .then(data => {
        setUsers(data);
        setLoading(false);
      });
  }, []);

  if (loading) return <h3>Loading API...</h3>;

  return (
    <div>
      <h2>Users from API</h2>
      {users.map(user => (
        <p key={user.id}>
          {user.name} | {user.email} | {user.phone}
        </p>
      ))}
    </div>
  );
}

export default UserList;