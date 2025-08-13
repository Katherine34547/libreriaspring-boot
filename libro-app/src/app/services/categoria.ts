import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../model/categoria.model';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  private baseUrl = 'http://localhost:8080/api/Categorias'; // URL to web API

  // Inyección de dependencias
  constructor(private http: HttpClient) { }

  findAll(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.baseUrl);
  }

  findOne(id: number): Observable<Categoria> {
    return this.http.get<Categoria>(`${this.baseUrl}/${id}`);
  }

  save(categoria: Categoria): Observable<Categoria> {
    return this.http.post<Categoria>(this.baseUrl, categoria);
  }

  update(id: number, categoria: Categoria): Observable<Categoria> {
    return this.http.put<Categoria>(`${this.baseUrl}/${id}`, categoria);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
  
}
