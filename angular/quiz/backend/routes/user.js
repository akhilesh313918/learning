const User = require('../models/user');
const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
//const user = require('../../../quiz/backend/models/user');


const router = express.Router();

router.post("/signup", (req, res, next) => {
    console.log("Email=====>>"+req.body.email);
    bcrypt.hash(req.body.password, 10)
    .then(hash => {
        const user = new User({
            email: req.body.email,
            password: req.body.password 
        });
        user.save()
            .then(result => {
                res.status(201).json({
                    message: "user created",
                    result: result
                })
            })
            .catch(err => {
                res.status(500).json({
                    error: err
                });
            })
    });
      
});

router.post("/login",(req, res, next) => {
    let fetchedUser;
    User.findOne({email: req.body.email})
     .then(user => {
        if(!user){
            console.log("1>>>>"+user);
            return res.status(401).json({
                message: "Auth Failed!"
            });
        }
        fetchedUser=user;
        return bcrypt.compare(req.body.password, user.password);
     })
     .then(result => {
        if(result){
            return res.status(401).json({
                message: "Auth Failed"
            }); 
        }
        const token = jwt.sign(
            {email: fetchedUser.email, userId: fetchedUser._id}, 
            process.env.JWT_KEY, 
            {expiresIn: '1h'}
            );
            res.status(200).json({
                token: token,
                expiresIn: 3600,
                isAdmin: fetchedUser.isAdmin
            })
     })
     .catch(err =>{
         return res.status(401).json({
             message: "Auth Failed"
         }); 
     });
})

module.exports = router;