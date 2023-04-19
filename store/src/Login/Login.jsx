import React from "react";
import { Stack } from '@mui/material';
import { Box } from "@mui/system";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import { useNavigate } from "react-router-dom";

export default function Login(){
    const navigate = useNavigate();
    const [email,setEmail] = React.useState("");
    const [password,setPassword] = React.useState("");
    const [isWrong,setIsWrong] = React.useState(false);

    const textFieldStyle = {
        backgroundColor : "#ffffff",
        borderRadius : 4
    }

    const authorize = () => {}

    return (
        <div className="homecontainer" style={{alignItems:"center",padding: "10%"}}>
            <div style={{color:"white"}}>
                <h1>Log in</h1>
            </div>
            <Box style={{
                width: "400px",
                backgroundColor: "rgb(0,0,111)",
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
            onClick = {() => {console.log('email',email);console.log('password',password)}}>

                Login
            </Button>
        </div>
    )

}