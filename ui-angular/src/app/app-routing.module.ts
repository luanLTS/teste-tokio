import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component'
import { CriarClienteComponent } from './components/criar-cliente/criar-cliente.component';
import { CriarEnderecoComponent } from './components/criar-endereco/criar-endereco.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'criar-cliente',
    component: CriarClienteComponent
  },
  {
    path: 'criar-cliente/:id',
    component: CriarClienteComponent
  },
  {
    path: 'criar-endereco',
    component: CriarEnderecoComponent
  },
  {
    path: 'criar-endereco/:id',
    component: CriarEnderecoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
