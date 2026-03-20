import React, { useState } from "react";
import "./StudentManager.css";

function StudentManager() {

  // Initial Students
  const [students, setStudents] = useState([
    { id: 1, name: "Surya", course: "CSE" },
    { id: 2, name: "Ravi", course: "ECE" },
    { id: 3, name: "Anu", course: "EEE" },
    { id: 4, name: "Kiran", course: "IT" },
    { id: 5, name: "Meena", course: "CSE" }
  ]);

  // New Student Object
  const [newStudent, setNewStudent] = useState({
    id: "",
    name: "",
    course: ""
  });

  // Handle Input Change
  const handleChange = (e) => {
    setNewStudent({
      ...newStudent,
      [e.target.name]: e.target.value
    });
  };

  // Add Student
  const addStudent = () => {
    if (!newStudent.id || !newStudent.name || !newStudent.course) return;

    setStudents([...students, newStudent]);

    // Clear inputs
    setNewStudent({ id: "", name: "", course: "" });
  };

  // Delete Student
  const deleteStudent = (id) => {
    const updated = students.filter((s) => s.id !== id);
    setStudents(updated);
  };

  return (
    <div className="container">
      <h2>Student Manager</h2>

      {/* Input Fields */}
      <input
        type="number"
        name="id"
        placeholder="ID"
        value={newStudent.id}
        onChange={handleChange}
      />
      <input
        type="text"
        name="name"
        placeholder="Name"
        value={newStudent.name}
        onChange={handleChange}
      />
      <input
        type="text"
        name="course"
        placeholder="Course"
        value={newStudent.course}
        onChange={handleChange}
      />

      <button onClick={addStudent}>Add Student</button>

      {/* Display Students */}
      {students.length === 0 ? (
        <p>No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.course}</td>
                <td>
                  <button onClick={() => deleteStudent(s.id)}>
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;