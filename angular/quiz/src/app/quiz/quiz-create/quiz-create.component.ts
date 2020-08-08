import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { QuizsService } from '../quiz.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Quiz } from '../quiz.model';

@Component({
selector: "<app-quiz-create>",
templateUrl: "./quiz-create.component.html",
styleUrls: ["./quiz-create.component.css"]
})
export class QuizCreateComponent implements OnInit{
    
    isLoading = false;
    form: FormGroup;
    public mode = 'create';
    private quizId: string;
    quiz: Quiz;
    option1 = "";
    option2 = "";
    option3 = "";
    
    constructor(public quizService: QuizsService, 
                private router: Router, 
                private activeRoute: ActivatedRoute){}

    ngOnInit(){
        this.form = new FormGroup({
            'question': new FormControl(null, {validators: [Validators.required, Validators.minLength(3)]}),
            'option1': new FormControl(null, {validators: [Validators.required, Validators.minLength(3)]}),
            'option2': new FormControl(null, {validators: [Validators.required, Validators.minLength(3)]}),
            'option3': new FormControl(null, {validators: [Validators.required, Validators.minLength(3)]}),
            'answer': new FormControl(null, {validators: [Validators.required]}),
        })
        this.activeRoute.paramMap.subscribe((paramMap: ParamMap) => {
            if(paramMap.has("quizId")){
                this.mode = "edit";
                this.quizId = paramMap.get("quizId");
                this.isLoading = true;
                this.quizService.getQuiz(this.quizId).subscribe(quizData => {
                    console.log(quizData);
                    this.isLoading = false;
                    this.quiz = {id: quizData._id,
                                question: quizData.question,
                                options: [quizData.options[0],quizData.options[1], quizData.options[2]],
                                answer: quizData.answer };
                                console.log(this.quiz);
                   this.form.setValue({'question': this.quiz.question,
                                       'option1': this.quiz.options[0],
                                       'option2': this.quiz.options[1],
                                       'option3': this.quiz.options[2],
                                       'answer': this.quiz.answer});             
                })
            }else{
                this.mode = 'create';
                this.quizId  = null;
            }
        })
    }

    onSave(){
        if(this.form.invalid){
            return;
        }
        if(this.mode==='create'){
                this.quizService.addQuiz(
                this.form.value.id,     
                this.form.value.question,
                this.form.value.option1,
                this.form.value.option2,
                this.form.value.option3,
                this.form.value.answer)
                this.form.reset();
                this.quizService.getQuizzesMaster();
                this.router.navigate(['/list']);
        }else{
            this.quizService.updateQuiz(
                this.quizId,     
                this.form.value.question,
                this.form.value.option1,
                this.form.value.option2,
                this.form.value.option3,
                this.form.value.answer)
                this.form.reset();
                this.quizService.getQuizzesMaster();
                this.router.navigate(['/list']);
        }
        
    }

    onClear(){
        this.form.reset();
    }
}