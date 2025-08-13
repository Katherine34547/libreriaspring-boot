import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Cliente } from '../../model/cliente.model';
import { MatTableDataSource } from '@angular/material/table';
import { ClienteService } from '../../services/cliente';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ViewportRuler } from '@angular/cdk/scrolling';
import Swal from 'sweetalert2';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-cliente',
  standalone: false,
  templateUrl: './cliente.html',
  styleUrl: './cliente.css'
})
export class ClienteComponent implements OnInit{
  clientes: Cliente[] = [];
  cliente: Cliente = {} as Cliente;
  editar: boolean = false;  
  idEditar: number | null = null;

  dataSource!: MatTableDataSource<Cliente>;
  mostrarColumnas: string[] = ['idCliente','cedula', 'nombre', 'apellido', 'direccion', 'telefono','correo', 'acciones'];
 
  @ViewChild('formularioCliente') formularioCliente!: ElementRef;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  //inyeccion de dependencias
  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.findAll();  
  }

  findAll(): void{
    this.clienteService.findAll().subscribe(data => {
     //this.clientes = data;
     this.dataSource = new MatTableDataSource(data);
     this.dataSource.paginator = this.paginator;
     this.dataSource.sort = this.sort;
     });
  }
 
  save(): void {
    this.clienteService.save(this.cliente).subscribe(() =>{
      this.cliente = {} as Cliente;
      this.findAll();
     });
  }

  update(): void {
    if (this.idEditar !== null) {
      this.clienteService.update(this.idEditar, this.cliente).subscribe(() => {
        this.cliente = {} as Cliente;
        this.editar = false;
        this.idEditar = null;
        this.findAll();
      });
    }
  }

  delete():void {
  Swal.fire({
    title: 'Desea eliminar el dato?',
    text: 'Esta accion no se puede deshacer',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonText:'Si, eliminar',
    cancelButtonText: 'Cancelar',
    confirmButtonColor: '#d33',
    cancelButtonColor: '#3085d6'
  }).then((result) =>{
    if (result.isConfirmed) {
      this.clienteService.delete(this.cliente.idCliente).subscribe(() =>{ 
        this.findAll();
        this.cliente = { } as Cliente;
        Swal.fire('Eliminado','El cleinte ha sido eliminado','success')
      });
    }else {
      this.cliente = { } as Cliente;
    }
  });
}

  //metodos para interacion en la pag web
  editarCliente(cliente: Cliente): void {
    this.cliente ={...cliente};
    this.idEditar = cliente.idCliente;
    this.editar = true;

    setTimeout(() => {
      this.formularioCliente.nativeElement.scrollIntoView({ behavior: 'smooth', block: 'start' });
  },100); // Ajusta el tiempo según sea necesario
} 
 
  editarClienteCancelar(form:NgForm): void {
    this.cliente = {} as Cliente;
    this.idEditar = null;
    this.editar = false;
    form.resetForm();
  }

  guardarCliente(form: NgForm): void {
    if(this.editar && this.idEditar !== null){
      this.update();
      form.resetForm();
    }else{
      this.save();
      form.resetForm();
    }
  }

  buscarCliente(event: Event){
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  }


  /*filtroClientes(event: Event){
    const filtro = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filtro.trim().toLowerCase();
  }*/
}    
  

