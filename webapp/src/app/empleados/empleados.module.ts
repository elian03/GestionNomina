import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {CarouselModule} from 'primeng/carousel';
import {DataListModule} from 'primeng/datalist';

import { EmpleadoIndexComponent} from './index/empleado-index.component';
import { EmpleadosRoutingModule } from './empleados-routing.module';
import { EmpleadoService } from '../services/empleado.service';
import { EmpleadoCreateComponent } from './create/empleado-create.component';
import { EmpleadoUpdateComponent } from './update/empleado-update.component';

/**
 * Represents the Index module configuration
 *
 * @export
 * @class IndexModule
 */
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    EmpleadosRoutingModule,
    CarouselModule,
    DataListModule
  ],
  declarations: [EmpleadoIndexComponent, EmpleadoCreateComponent, EmpleadoUpdateComponent],
  providers: [ EmpleadoService,],
})

export class EmpleadosModule {
}
