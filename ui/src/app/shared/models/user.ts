import { Post } from "./post";

export interface User{
    id:                 String;
    email:              String;
    password:           String;
    name:               String;
    bio:                String;
    registrationDate:   String;
    posts:              Post[];
}