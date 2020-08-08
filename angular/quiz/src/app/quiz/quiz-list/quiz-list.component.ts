import { OnInit, Component } from '@angular/core';
import { QuizsService } from '../quiz.service';
import { Quiz } from '../quiz.model';
import { Subscription } from 'rxjs';
import { PageEvent } from '@angular/material/paginator';
import { AuthService } from 'src/app/auth/auth.service';
import { NgForm, FormGroup, FormControl, FormArray } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
    selector: "<app-quiz-list>",
    templateUrl: "./quiz-list.component.html",
    styleUrls: ["./quiz-list.component.css"]
})
export class QuizListComponent implements OnInit{

    form: FormGroup;
    option = [];
    quizzes: Quiz[] = [];
    private quizSub: Subscription;
    private ansSub: Subscription;
    isLoading = false;
    isAdmin = false;
    public totatQuiz = 0;
    public quizPerPage = 2;
    public currentPage = 1;
    public pageSizeOptions = [1,2,5,10];
    userIsAuthenticated = false;
    private ansKey:[{question: any, answer: any}];
    private key =[];
    opt1 = null;
    opt2 = null;
    opt3 = null;


    constructor(private quizService: QuizsService, 
        private authService: AuthService,
        private route: Router){}

    ngOnInit(){

        this.form = new FormGroup({
            'question': new FormControl(),
            'options': new FormArray([])
        });
        this.isLoading = true;
        this.quizService.getQuizzesMaster();
        this.isAdmin = this.authService.isUserAdmin();
        this.userIsAuthenticated = this.authService.getUserAuth();
        this.quizSub = this.quizService.getQuizUpdateListener()
        .subscribe( (quizData: {quizzes: Quiz[], quizCount: number}) => {
            this.isLoading = false;
            //this.userIsAuthenticated = true;
            this.totatQuiz = quizData.quizCount;
            this.quizzes =  quizData.quizzes;
        })
        console.log(this.quizzes);
    }

    onDelete(quizId: string){
        console.log(this.quizzes[0].id);
        console.log(quizId);
        this.isLoading = true;
        this.quizService.deletePost(quizId).subscribe(()=>{
            this.quizService.getQuizzesMaster();
        });
    }

    onSubmit(form: NgForm){

        if(form.invalid){
            console.log("invalid");
            return;
        }

        this.quizService.totalQuestions = this.option.length;
        console.log(this.option.length);
        this.quizService.getAns();
        this.isLoading = true;
        setTimeout(() =>{
            let i;
            for(i=0; i<this.option.length; i++){
                this.quizService.calcScore(this.option[i],this.quizService.ansKey[i]);
            }
            this.route.navigate(['/result']);
            this.isLoading = false;
        },5000)
        
    }

    

    onPageChanged(pagedata : PageEvent){
        this.isLoading = true;
        this.currentPage = pagedata.pageIndex + 1;
        this.quizPerPage = pagedata.pageSize;
        //this.postsService.getPosts(this.postPerPage, this.currentPage);
    }

    onRadioChange(opt,index){
        console.log(opt, index);
    }


}