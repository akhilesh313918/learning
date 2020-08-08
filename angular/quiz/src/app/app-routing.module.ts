import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { QuizCreateComponent } from './quiz/quiz-create/quiz-create.component';
import { QuizListComponent } from './quiz/quiz-list/quiz-list.component';
import { AuthGuard } from './auth/auth.guard.service';
import { HomeComponent } from './home/home.component';
import { QuizResultComponent } from './quiz/quiz-result/quiz-result.component';

const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'list', component: QuizListComponent, canActivate: [AuthGuard]},
    {path: 'login', component: LoginComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'create', component: QuizCreateComponent, canActivate: [AuthGuard]},
    {path: 'edit/:quizId', component: QuizCreateComponent, canActivate: [AuthGuard]},
    {path: 'result', component: QuizResultComponent, canActivate: [AuthGuard]},

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
    providers: [AuthGuard]
})
export class AppRoutingModule{

}