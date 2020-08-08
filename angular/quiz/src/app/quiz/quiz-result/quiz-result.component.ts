import { Component, OnInit } from '@angular/core';
import { QuizsService } from '../quiz.service';

@Component({
    selector: '<app-quiz-result>',
    templateUrl: './quiz-result.component.html',
    styleUrls: ['./quiz-result.component.css']
})
export class QuizResultComponent implements OnInit{

    constructor(private quizService: QuizsService){}

    score: number;
    total: number;

    ngOnInit(){
        this.score = this.quizService.score;
        this.total = this.quizService.getTotalQuestion();
    }
}