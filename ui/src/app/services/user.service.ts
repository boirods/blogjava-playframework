import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, of } from 'rxjs';
import { User } from '../shared/models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private readonly url4all='http://localhost:9000/api/user/todos/';
  private readonly url4allPosts = 'http://localhost:9000/api/user/allpostalluser';

  constructor(private http: HttpClient) { }

  listarUsers(): Observable<any>{
    return this.http.get(this.url4all).pipe(catchError(this.handleError<User>('getUsers')));
  }

  listarPostUsers():Observable<any>{
    return this.http.get(this.url4allPosts).pipe(catchError(this.handleError<User>('getPostAllUsers')));
  }

  private handleError<T>(operation='operation', result?:T){
    return (error:any): Observable<T> => {
      console.log(error);
      return of(result as T);
    }
  }
}
