const path =  require('path');
const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose'); 
const userRoutes = require("./routes/user");
const quizRoutes = require("./routes/quizzes");



const app = express();
mongoose.connect("mongodb+srv://owner:"+process.env.MONGO_ATLAS_PW+"@cluster0.4ijpa.mongodb.net/quiz-app?retryWrites=true&w=majority")
.then(() => {
    console.log("Connected to Mongo DB Server");
})
.catch(() => {
    console.log("Connection to Mongo DB Server Failed");
})

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));
//JZUySvlgv35wF3jp
app.use((req, res, next) => {
    res.setHeader("Access-Control-Allow-Origin" , "*");
    res.setHeader("Access-Control-Allow-Headers" , "Orign, X-Requested-With, Content-Type, Accept, Authorization"); 
    res.setHeader("Access-Control-Allow-Methods" , "GET, PATCH, PUT, POST, DELETE, OPTIONS");
    next();
});


app.use("/api/user", userRoutes);
app.use("/api/quizzes", quizRoutes);

module.exports = app;