import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import {AppRoutingModule } from './app-routing.module';
import {App } from './app';
import {ClienteComponent } from './components/cliente/cliente';
import {FormsModule} from '@angular/forms';
import {HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule } from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon'
import {MatButtonModule } from '@angular/material/button';
import {AutorComponent } from './components/autor/autor';
import {CategoriaComponent } from './components/categoria/categoria';
import {LibroComponent } from './components/libro/libro';
import {MatSelectModule } from '@angular/material/select';
import {MatOptionModule, MatNativeDateModule} from '@angular/material/core'
import {MatDialogModule } from '@angular/material/dialog';
import {MatDatepickerModule} from '@angular/material/datepicker'

@NgModule({
  declarations: [
    App,
    ClienteComponent,
    AutorComponent,
    CategoriaComponent,
    LibroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatFormFieldModule,
    MatIconModule,
    MatButtonModule,
    MatSelectModule,
    MatOptionModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    MatDatepickerModule
  ],
  bootstrap: [App]
})
export class AppModule { }
