import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from './task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(
    private http: HttpClient
  ) { }

  all():Observable<Task[]>{
    return this.http.get<Task[]>(
      `http://localhost:8080/api/tasks`
    );
  }

  save(task:Task):Observable<Task>{
    return this.http.post<Task>(
      `http://localhost:8080/api/tasks`,
      task
    );
  }

}
