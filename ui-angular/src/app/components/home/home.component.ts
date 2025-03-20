import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente';
import { Endereco } from 'src/app/models/endereco';
import { ClienteService } from 'src/app/services/cliente.service';
import { EnderecoService } from 'src/app/services/endereco.service';

@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    constructor(private readonly clienteService: ClienteService,
        private readonly enderecoService: EnderecoService
    ) { }

    step = 0;
    clientes: Cliente[] = [];
    colunas: string[] = ["id", 'address', "number", "complement", 'state', 'city', "postalCode", "country", "actions"];
    enderecos: Endereco[] = [];

    ngOnInit(): void {
        this.clienteService.getClientesLista().subscribe(lista => this.clientes = lista);
    }

    setStep(index: number) {
        this.step = index;
        this.getEnderecoes()
    }

    onDeleteUsuario(id: number) {
        this.clientes = this.clientes.filter(c => c.id !== id);
    }

    onDeleteEndereco(id: number) {
        this.enderecos = this.enderecos.filter(e => e.id !== id);
    }

    getEnderecoes() {
        this.enderecoService.getEnderecosCliente(this.step).subscribe(lista => this.enderecos = lista);
    }
}
