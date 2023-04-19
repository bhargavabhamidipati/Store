import React from "react";
import { Stack } from '@mui/material';
import { Box } from "@mui/system";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import { useNavigate } from "react-router-dom";
import db from "../Firebase/Firebase"
import { collection, addDoc } from "firebase/firestore";
import { getAuth, createUserWithEmailAndPassword } from "firebase/auth";


export default function SignUp(){
    const navigate = useNavigate();
    const [firstName,setFirstName] = React.useState("");
    const [lastName,setLastname] = React.useState("");
    const [email,setEmail] = React.useState("");
    const [password,setPassword] = React.useState("");
    const [mobile,setMobile] = React.useState("");
    const [isWrong,setIsWrong] = React.useState(false);

    const textFieldStyle = {
        backgroundColor : "#ffffff",
        borderRadius : 4
    }

    const submit = async (e) => {
        e.preventDefault();
        try {
            const docRef = await addDoc(collection(db, "UserData"),{
                FirstName: firstName,
                LastName: lastName,
                Email: email,
                Mobile: mobile,
              });
            console.log("Document written with ID: ", docRef.id);
          } catch (e) {
            console.error("Error adding document: ", e);
          }

          const auth = await getAuth();
          createUserWithEmailAndPassword(auth, email, password)
            .then((userCredential) => {
              // Signed in
              const user = userCredential.user;
              // ...
            })
            .catch((error) => {
              const errorCode = error.code;
              const errorMessage = error.message;
              // ..
            });


        setFirstName("");
        setLastname("");
        setEmail("");
        setPassword("");
        setMobile("");
      };

    return (
        <div className="homecontainer" style={{alignItems:"center",padding: "10%"}}>
            <div style={{}}>
                <h1>Sign Up</h1>
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
                    label="First name"
                    style={textFieldStyle}
                    onChange={(e) =>{ setFirstName(e.target.value)}}
                />
                <TextField
                    id="outlined-name"
                    label="Last Name"
                    style={textFieldStyle}
                    onChange={(e) =>{ setLastname(e.target.value)}}
                />
                <TextField
                    id="outlined-name"
                    label="Mobile"
                    style={textFieldStyle}
                    onChange={(e) =>{ setMobile(e.target.value)}}
                />
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
            onClick = {submit}>

                Sign up
            </Button>
        </div>
    )

}