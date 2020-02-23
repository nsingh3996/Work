# Work
Book.ts
export interface Book{
    bookId:number,
    bookTitle:string,
    bookAuthor:string,
    bookPubYear:number
}

lab4.html
<table class="table-striped" border="4">
    <tr>
      <th>Book ID</th>
      <th>Book Title</th>
      <th>Book Author</th>
      <th>Book Year of Publish</th>
    </tr>
    <tr>
        <td><input type="text" #id placeholder="Id" (keyup)="myFilter('id',id.value)"></td>
        <td><input type="text" #title placeholder="Title" (keyup)="myFilter('title',title.value)"></td>
        <td><input type="text" #author placeholder="Author" (keyup)="myFilter('author',author.value)"></td>
        <td><input type="text" #year placeholder="Year" (keyup)="myFilter('year',year.value)"></td>
      </tr>
    <tr *ngFor="let book of bookData">
      <td>{{book.id}}</td>
      <td>{{book.title}}</td>
      <td>{{book.author}}</td>
      <td>{{book.year}}</td>
   </tr>
  </table>
  
 
  lab4.ts
  import { Component, OnInit } from "@angular/core";
import { Lab4Service } from "./lab4.service";

@Component({
    selector: 'app-lab4',
    templateUrl: 'lab4.component.html',
    styles: [` `]
})
export class Lab4Component implements OnInit{
    bookData=null;
    jsonString;
    constructor(private _lab4Service:Lab4Service){ }
    ngOnInit(){
        this.bookData=this._lab4Service.getData().subscribe(data=> {this.bookData=data;this.jsonString=JSON.stringify(data);})
    }
    myFilter(para,filter){
        let i=0;
        this.bookData=JSON.parse(this.jsonString);
        while(this.bookData[i]){
            if(this.bookData[i][para].toString().indexOf(filter)<0){
              this.bookData.splice(i,1);
            }
            else{
              i++
            }
        }
      }
    
}

lab4.service.ts
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Book } from "./Book";

@Injectable()
export class Lab4Service{
    constructor(private http:HttpClient){ }
    getData():Observable<Book>
    {
        return this.http.get<Book>('../assets/booklist.json');
    }
}
