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

}
