const Quiz = require('../models/quiz');
const express = require('express');
const checkAuth = require('../middleware/check-auth');

const router = express.Router();


router.get("",(req, res, next) => {
    //const pageSize = +req.query.pagesize;
    //const currentPage = +req.query.page;
    const quizQuery = Quiz.find();
    let fetchedQuizzes;
    // if(pageSize && currentPage){
    //     postQuery
    //         .skip(pageSize * (currentPage - 1))
    //         .limit(pageSize);
    // }
    quizQuery.then(quizzes => {
        fetchedQuizzes = quizzes 
        return Quiz.count(); 
    }).then( count => {
        res.status(200).json({
            message: 'Quiz fetched successfully!',
            quizzes: fetchedQuizzes,
            maxQuiz: count
        });
    });
    
});

router.get("/:id", (req, res, next) => {
    console.log("Inside get with ID")
    Quiz.findById(req.params.id).then(quiz => {
        if(quiz){
            console.log("Inside get with ID inside IF")
            console.log(quiz);
            res.status(200).json(quiz);
        }else{
            res.status(404).json({message: 'Post not found'});
        }
    })
})

router.post("",checkAuth,(req, res, next) =>{
    console.log(req.body.question);
    console.log(req.body.options[0]);
    const quiz = new Quiz({
        question: req.body.question,
        // option1: req.body.option1,
        // option2: req.body.option2,
        // option3: req.body.option3,
        options: [req.body.options[0], 
                  req.body.options[1],
                  req.body.options[2]],
        answer: req.body.answer
    });    
    quiz.save().then(createdQuiz => {
        console.log(createdQuiz);
        res.status(201).json({
            message: 'Quiz added successfully',
            postId: createdQuiz._id,
            quiz: {
                ...createdQuiz,
                id: createdQuiz._id
            }

        });
    });
    });


    router.put("/:id",checkAuth, (req, res, next) => {
            const quiz = new Quiz({
            _id: req.body.id,
            question: req.body.question,
            options: [req.body.options[0], 
                      req.body.options[1],
                      req.body.options[2]],
            answer: req.body.answer
        });
        console.log(quiz);
        Quiz.updateOne({_id: req.params.id}, quiz).then(result => {
             console.log(result);
             res.status(200).json({message: "update successful"});
        });
    });

    router.delete("/:id", checkAuth, (req, res, next) => {
        console.log(req.params.id);
        Quiz.deleteOne({_id: req.params.id}).then( result => {
            console.log(result);
            res.status(200).json({ message: 'Quiz deleted!' });
        });
        
    });

    module.exports = router; 