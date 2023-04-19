import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import Login from './Login/Login';
import SignUp from "./SignUp/SignUp";

function App() {
  return (

      <Router>
        <Routes>
        <Route exact path = "/" element={<Login/>}/>
        <Route exact path = "/SignUp" element={<SignUp/>}/>

        </Routes>
      </Router>
  );
}

export default App;
