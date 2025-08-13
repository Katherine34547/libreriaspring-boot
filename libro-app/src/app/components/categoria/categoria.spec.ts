import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoriaComponent } from './categoria';

describe('Categoria', () => {
  let component: CategoriaComponent;
  let fixture: ComponentFixture<CategoriaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CategoriaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CategoriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
