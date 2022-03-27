import { Component, OnInit } from '@angular/core';
import { UserService } from './services/user.service';
import { Post } from './shared/models/post';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  emOutroComponente:boolean = false;
  title = 'JavaBlog - O blog com a sua melhor linguagem!';
  posts: Post[] = [];
  constructor(private servico: UserService){
  }
  ngOnInit(): void {
      this.servico.listarPostUsers().subscribe(objetos => this.posts = objetos);
  }
}