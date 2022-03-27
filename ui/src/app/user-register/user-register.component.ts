import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {
  registroGroup = new FormGroup({
    email:new FormControl(''),
    senha: new FormControl(''),
    nome: new FormControl(''),
    bio: new FormControl('')
  });
  
  constructor() { }

  ngOnInit(): void {
  }
  registra():void{
    console.warn(this.registroGroup.value);
    alert("Usuário registrado!");
  }
}
