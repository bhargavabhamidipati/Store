import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import Login from './Login/Login';

function App() {
  return (

      <Router>
        <Routes>
        <Route exact path = "/" element={<Login/>}/>
        </Routes>
      </Router>
  );
}

export default App;
