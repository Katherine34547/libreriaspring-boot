import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../model/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
 
  private baseUrl = 'http://localhost:8080/clientes'; // Web API

  //inyeccion de dependencias
  constructor( private http: HttpClient) { }

  findAll(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.baseUrl);
  }
   
  findOne(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.baseUrl}/${id}`);
  }

  save(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(this.baseUrl, cliente);
  }

  update(id: number, cliente:Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(`${this.baseUrl}/${id}`, cliente)
  }

  delete(id:number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

}
