import axios from "axios";
import { useEffect, useState } from "react";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);

  const fetchData = () => {
    axios.get("https://dummyjson.com/posts")
      .then(res => {
        setPosts(res.data.posts);
        setFiltered(res.data.posts);
      });
  };

  useEffect(() => {
    fetchData();
  }, []);

  const filterByUser = (id) => {
    if (id === "") {
      setFiltered(posts);
    } else {
      setFiltered(posts.filter(p => p.userId == id));
    }
  };

  return (
    <div>
      <h2>Fake Posts</h2>

      <select onChange={(e) => filterByUser(e.target.value)}>
        <option value="">All</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
      </select>

      <button onClick={fetchData}>Refresh</button>

      {filtered.map(post => (
        <div key={post.id}>
          <h4>{post.title}</h4>
          <p>{post.body}</p>
        </div>
      ))}
    </div>
  );
}

export default FakePostList;