import React, { useEffect, useState } from "react";
import API from "../Api";

function TaskList() {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  // Fetch tasks
  const fetchTasks = async () => {
    const res = await API.get("");
    setTasks(res.data);
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  // Add task
  const addTask = async () => {
    try {
      await API.post("", {
        title,
        description,
        completed: false
      });
      setTitle("");
      setDescription("");
      fetchTasks();
    } catch (err) {
      if (err.response && err.response.data) {
          alert(JSON.stringify(err.response.data));
        } else {
          alert("Network error: Backend not reachable");
        }
    }
  };

  // Delete task
  const deleteTask = async (id) => {
    await API.delete(`/${id}`);
    fetchTasks();
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Task Manager</h2>

      <input
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
      />
      <br /><br />

      <input
        placeholder="Description"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
      />
      <br /><br />

      <button onClick={addTask}>Add Task</button>

      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <b>{task.title}</b> - {task.description}
            <button onClick={() => deleteTask(task.id)}>❌</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TaskList;
