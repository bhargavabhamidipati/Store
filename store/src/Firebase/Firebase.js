// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getFirestore } from "firebase/firestore";

// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyB82tOQ8kq3wFmmUdMxbAz_Db4O3OD_cvo",
  authDomain: "store-6c372.firebaseapp.com",
  projectId: "store-6c372",
  storageBucket: "store-6c372.appspot.com",
  messagingSenderId: "1056926257648",
  appId: "1:1056926257648:web:f06d79919bdf51e49f0d35",
  measurementId: "G-Y3SRWGPNDG"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const db = getFirestore();

export default db;