import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Post } from '../shared/models/post';


@Component({
  selector: 'app-index-posts',
  templateUrl: './index-posts.component.html',
  styleUrls: ['./index-posts.component.css']
})
export class IndexPostsComponent implements OnInit {
  posts: Post[] = [];
  constructor(private servico: UserService) { }

  ngOnInit(): void {
    this.servico.listarPostUsers().subscribe(objetos => this.posts = objetos);
  }

}
