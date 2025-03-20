import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    constructor(private readonly clienteService: ClienteService) { }

    clientes: Cliente[] = [];

    ngOnInit(): void { 
        this.clienteService.getClientesLista().subscribe(lista => this.clientes = lista);
    }
}
