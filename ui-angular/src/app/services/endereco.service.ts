import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from '../models/endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  constructor(private readonly http: HttpClient) { }


  getEnderecosCliente(clienteId:number): Observable<Endereco[]> {
    return this.http.get<Endereco[]>("/address/", {params: new HttpParams().set('client_id', clienteId.toString())});
  }
}
