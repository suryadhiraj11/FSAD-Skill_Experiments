import { useEffect, useState } from "react";
import axios from "axios";

function StudentList() {

  const [students, setStudents] = useState([]);
  const [form, setForm] = useState({
    name: "",
    email: "",
    course: ""
  });

  const [editingId, setEditingId] = useState(null);

  // Fetch students
  const fetchStudents = () => {
    axios.get("http://localhost:8080/students")
      .then(res => setStudents(res.data));
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  // Handle input change
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // Add OR Update
  const handleSubmit = () => {
    if (editingId) {
      // UPDATE
      axios.put(`http://localhost:8080/students/${editingId}`, form)
        .then(() => {
          fetchStudents();
          setEditingId(null);
        });
    } else {
      // ADD
      axios.post("http://localhost:8080/students", form)
        .then(() => fetchStudents());
    }

    setForm({ name: "", email: "", course: "" });
  };

  // Delete
  const deleteStudent = (id) => {
    axios.delete(`http://localhost:8080/students/${id}`)
      .then(() => fetchStudents());
  };

  // Edit
  const editStudent = (s) => {
    setForm({
      name: s.name,
      email: s.email,
      course: s.course
    });
    setEditingId(s.id);
  };

  return (
    <div>
      <h2>Student Management</h2>

      {/* FORM */}
      <input name="name" placeholder="Name" value={form.name} onChange={handleChange} />
      <input name="email" placeholder="Email" value={form.email} onChange={handleChange} />
      <input name="course" placeholder="Course" value={form.course} onChange={handleChange} />

      <button onClick={handleSubmit}>
        {editingId ? "Update" : "Add"}
      </button>

      <hr />

      {/* LIST */}
      {students.map(s => (
        <div key={s.id}>
          {s.name} | {s.email} | {s.course}

          <button onClick={() => editStudent(s)}>Edit</button>
          <button onClick={() => deleteStudent(s.id)}>Delete</button>
        </div>
      ))}
    </div>
  );
}

export default StudentList;