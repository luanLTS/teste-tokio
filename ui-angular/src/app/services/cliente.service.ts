import { HttpClient } from '@angular/common/http';
import { Injectable} from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService  {

  constructor(private readonly http: HttpClient) { }

  getClientesLista(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>("/client/");
  }

  deleteCliente(id: number): Observable<string> {
    return this.http.delete<string>("/client/"+id, {responseType: "text" as "json"});
  }

}
