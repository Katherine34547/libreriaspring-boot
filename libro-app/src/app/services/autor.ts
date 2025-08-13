import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Autor } from '../model/autor.model';

@Injectable({
  providedIn: 'root'
})
export class AutorService {
  
  private baseUrl = 'http://localhost:8080/Autors';

  constructor(private http: HttpClient) { }
  
  findAll(): Observable<Autor[]> {
    return this.http.get<Autor[]>(this.baseUrl);
  }

  findOne(id: number): Observable<Autor> {
    return this.http.get<Autor>(`${this.baseUrl}/${id}`);
  }

  save(autor: Autor): Observable<Autor> {
    return this.http.post<Autor>(this.baseUrl, autor);
  }

  update(id: number, autor: Autor): Observable<Autor> {
    return this.http.put<Autor>(`${this.baseUrl}/${id}`, autor);
  }

  delete(id:number): Observable<void> {
  return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
