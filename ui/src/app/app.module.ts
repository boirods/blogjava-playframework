import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import '@angular/compiler';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatMenuModule } from '@angular/material/menu';
import { PostServiceService } from './services/post-service.service';
import { UserService } from './services/user.service';
import { UserRegisterComponent } from './user-register/user-register.component';
import { IndexPostsComponent } from './index-posts/index-posts.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    UserRegisterComponent,
    IndexPostsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatMenuModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    HttpClientModule,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
