import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Libro } from '../model/libro.model';

@Injectable({
  providedIn: 'root'
})
export class LibroService {
    private baseUrl = 'http://localhost:8080/Libros'; // Web API
    

  //inyeccion de dependencias
  constructor( private http: HttpClient) { }

  findAll(): Observable<Libro[]> {
    return this.http.get<Libro[]>(this.baseUrl);
  }
   
  findOne(id: number): Observable<Libro> {
    return this.http.get<Libro>(`${this.baseUrl}/${id}`);
  }

  save(libro: Libro): Observable<Libro>{
    return this.http.post<Libro>(this.baseUrl, libro);
  }

  update(id: number, libro:Libro): Observable<Libro>{
    return this.http.put<Libro>(`${this.baseUrl}/${id}`, libro)
  }

  delete(id:number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}