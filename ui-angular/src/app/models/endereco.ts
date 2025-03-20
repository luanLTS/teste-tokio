import { Cliente } from "./cliente";

export interface Endereco {
    id: number;
    address: string;
    number: string;
    complement: string;
    postalCode: string;
    city: string;
    state: string;
    country: string;
    client: Cliente;
}
