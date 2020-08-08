import { Quiz } from './quiz.model';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { map } from 'rxjs/operators';

import { HttpClient } from "@angular/common/http";
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';

const BACKEND_URL = environment.apiUrl + "/quizzes/";

@Injectable({providedIn: "root"})

export class QuizsService {

    
    private quizzes: Quiz[] = [];
    private quizUpdated = new Subject<{quizzes: Quiz[], quizCount: number}>();
    private ans = new Subject<any>();
    public ansKey = <any>[];
    public score: number = 0;
    public totalQuestions: number;

    constructor(private http: HttpClient, private router: Router){}

    getQuizzesMaster(){
        this.http.get<{message: string, quizzes: any, maxQuizzes: number}>(BACKEND_URL)
        .pipe(map((quizData) => {
            return {quizzes: quizData.quizzes.map(quiz => {
                console.log(quiz);
                return {
                    id: quiz._id,
                    question: quiz.question,
                    options: [quiz.options[0],quiz.options[1],quiz.options[2]],
                    answer: quiz.answer
                }
            }), maxQuizzes: quizData.maxQuizzes}
        })).subscribe((transformedQuizData) => {
            console.log(transformedQuizData);
            this.quizzes = transformedQuizData.quizzes;
            this.quizUpdated.next({
                quizzes: [...this.quizzes],
                quizCount: transformedQuizData.maxQuizzes
            })
        })
    }

    getQuizUpdateListener(){
        return this.quizUpdated.asObservable();
    }

    getAnsListener(){
        return this.ans.asObservable();
    }

    getQuiz(id: string){
        console.log(id);
        return this.http.get<{ _id: string, question: string, options:any, answer: string }>(BACKEND_URL + id);
    }

    addQuiz(id: string ,question: string, option1: string, option2: string, option3: string, answer: string){
        const quizData: Quiz = {
                                id:id,
                                question: question, 
                                options: [option1, option2, option3],
                                answer: answer
                                };
        console.log(quizData);                        
        this.http.post<{message: string, quiz: Quiz}>(BACKEND_URL, quizData)
        .subscribe( responseData => {
            //this.router.navigate(["/"]);
        });
        
    }

    updateQuiz(id: string ,question: string, option1: string, option2: string, option3: string, answer: string){
        const quizData: Quiz = {
                                id:id,
                                question: question, 
                                options: [option1, option2, option3],
                                answer: answer
                                };
        console.log(quizData);                        
        this.http.put<{message: string, quiz: Quiz}>(BACKEND_URL +id, quizData)
        .subscribe( responseData => {
            //this.router.navigate(["/"]);
        });
        
    }
    
    
    deletePost(quizId: string){
        return this.http.delete(BACKEND_URL + quizId)
          }

          getAns(){
            this.http.get<{message: string, quizzes: any}>(BACKEND_URL)
            .pipe(map((quizData) => {
                return {quizzes: quizData.quizzes.map(quiz => {
                    return {
                        //question: quiz.question,
                        answer: quiz.answer
                    }
                }), }
            })).subscribe((transformedQuizData) => {
                this.quizzes = transformedQuizData.quizzes;
                this.quizzes.forEach((key,value)=>{
                    this.ansKey.push(key.answer);
                })
                console.log(this.ansKey[0]);
                // this.ans.next({
                //     ans : [...this.quizzes]
                // });
            })
        }     
        
        calcScore(ans: string, key: string){
            if(ans===key){
                this.score++;
            }
            console.log(this.score);
        }
        
        getTotalQuestion(){
            return this.totalQuestions;
        }
}