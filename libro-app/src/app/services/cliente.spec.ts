import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteComponent } from './cliente';

describe('Cliente', () => {
  let Component: ClienteComponent;
  let fixture: ComponentFixture<ClienteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    declaration: [ClienteComponent]
  });

  it('should be created', () => {
    expect(Component).toBeTruthy();
  });
});
