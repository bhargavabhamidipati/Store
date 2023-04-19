import React from "react";
import { Stack } from '@mui/material';
import { Box } from "@mui/system";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import { useNavigate } from "react-router-dom";
import { getAuth, signInWithEmailAndPassword } from "firebase/auth";

export default function Login(){
    const navigate = useNavigate();
    const [email,setEmail] = React.useState("");
    const [password,setPassword] = React.useState("");
    const [isWrong,setIsWrong] = React.useState(false);

    const textFieldStyle = {
        backgroundColor : "#ffffff",
        borderRadius : 4
    }

    const authorize = () => {
        const auth = getAuth();
        signInWithEmailAndPassword(auth, email, password)
        .then((userCredential) => {
        // Signed in
        const user = userCredential.user;
        console.log("signed in successfully");
        // ...
        })
        .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        console.log("login failed")
        });
    }

    return (
        <div className="homecontainer" style={{alignItems:"center",padding: "10%"}}>
            <div style={{}}>
                <h1>Log in</h1>
            </div>
            <Box style={{
                width: "400px",
                backgroundColor: "white",
                borderRadius: 4,
                padding: 10,
            }}>
            <Stack spacing={2} direction= "column">
                <TextField
                    id="outlined-name"
                    label="Email"
                    style={textFieldStyle}
                    onChange={(e) =>{ setEmail(e.target.value)}}
                />
                {!isWrong && <TextField
                    id="outlined-name"
                    label="Password"
                    type="password"
                    style={textFieldStyle}
                    onChange={(e) =>{ setPassword(e.target.value)}}
                />}
                {isWrong && <TextField
                    error
                    id="outlined-name"
                    label="Password"
                    type="password"
                    helperText="Password incorrect"
                    style={textFieldStyle}
                    onChange={(e) =>{ setPassword(e.target.value)}}
                />}
            </Stack>
            </Box>
            <Button variant = "contained"
            style = {{width:"100px",align:"center", margin:"10px"}}
            onClick = {authorize}>

                Login
            </Button>
        </div>
    )

}