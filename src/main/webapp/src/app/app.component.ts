import { Component } from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import { TaskService } from './task.service';
import { Task } from './task';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(
    private taskService : TaskService
  ){
    this.loadTasks();
    this.newTask();
  }

  loadTasks(){
    this.taskService.all().subscribe( tasks => {

      console.log(tasks);

      this.todo = tasks.filter( task => task.status === 'todo').sort( (a,b) => a.index - b.index);
      this.doing = tasks.filter( task => task.status === 'doing').sort( (a,b) => a.index - b.index);
      this.done = tasks.filter( task => task.status === 'done').sort( (a,b) => a.index - b.index);
      
    });
  }

  task!:Task;
  
  todo:Task[] = [];

  doing:Task[] = [];

  done:Task[] = [];

  newTask(){
    this.task = {
      id : null,
      index : this.todo.length,
      title : '',
      status : 'todo'
    };
  }

  addTask(){
    if(this.task.title.length===0)
      return;

    this.taskService.save(this.task).subscribe( task => {
      this.todo.push(this.task);
      this.newTask();
    });
    
  }

  updateIndex(tasks:Task[]){

    let tasksToUpdate:Task[] = [];

    for(let task of tasks){
      let index = tasks.indexOf(task);
      if(task.index !== tasks.indexOf(task)){
        task.index = index;
        tasksToUpdate.push(task);
      }
    }

    for(let task of tasksToUpdate)
      this.taskService.save(task).subscribe( t => {
        console.log(t);
      });

  }

  drop(event: CdkDragDrop<Task[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }

    let task = event.container.data[event.currentIndex];
    task.index = event.currentIndex;
    task.status = event.container.id;
        
    this.taskService.save(task).subscribe( t => {
      console.log(t);
    });

    this.updateIndex(this.todo);
    this.updateIndex(this.doing);
    this.updateIndex(this.done);

  }

}
