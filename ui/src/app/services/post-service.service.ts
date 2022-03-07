import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from '../shared/models/post';
import { catchError, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {

  private readonly url='http://localhost:9000/api/post/todos/';
  constructor(private http:HttpClient) {

  }

  listarPosts():Observable<any>{
    return this.http.get(this.url).pipe(catchError(this.handleError<Post>('getPosts')));
  }

  private handleError<T>(operation='operation', result?:T){
    return (error: any): Observable<T> => {
      console.log(error);
      return of(result as T);
    }
  }
}
