import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import axios from "axios";

function App() {
  const [data, setdata] = useState(["hello", "world"]);
  const [item, setItem] = useState();
  const handleGetData = async () => {
    try {
      axios.get("http://localhost:8080/get").then((response) => {
        setdata(response.data);
      });
    } catch (error) {
      console.log("Error in getting data: ", error);
    }
  };
  const handlePostData = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(`http://localhost:8080/post/${item}`);
      setdata(response.data);
    } catch (error) {
      console.log("Error in posting data: ", error);
    }
  };

  return (
    <div className="App">
      <p>{data}</p>
      <button onClick={handleGetData}>Get Data</button>
      <form>
        <input
          type="text"
          name="item"
          value={item}
          onChange={(e) => setItem(e.target.value)}
        ></input>

        <button onClick={handlePostData}>Post Data</button>
      </form>
    </div>
  );
}

export default App;
