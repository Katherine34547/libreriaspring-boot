import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarritoComponent } from './components/carrito/carrito';
import { LibrosListComponent } from './components/libros-list/libros-list';
import { CategoriaComponent } from './components/categoria/categoria';
import { AutorComponent } from './components/autor/autor';
import { ClienteComponent } from './components/cliente/cliente';
import { LibroComponent } from './components/libro/libro';

const routes: Routes = [
  {path: '', redirectTo: 'libros1', pathMatch: 'full'},
  {path: 'libros1', component: LibrosListComponent},
  {path: 'carrito', component: CarritoComponent},
  {path: 'categorias', component: CategoriaComponent },
  {path: 'autores', component: AutorComponent },
  {path: 'clientes', component: ClienteComponent},
  {path: 'libros', component: LibroComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
