import { Component, OnInit } from '@angular/core';
import { PostServiceService } from './services/post-service.service';
import { Post } from './shared/models/post';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'JavaBlog - O blog com a sua melhor linguagem!';
  posts: Post[] = [];
  constructor(private servico: PostServiceService){
  }
  ngOnInit(): void {
      this.servico.listarPosts().subscribe(objetos => this.posts=objetos);
  }
}