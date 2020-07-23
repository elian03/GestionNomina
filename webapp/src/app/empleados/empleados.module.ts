import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarouselModule} from 'primeng/carousel';
import {DataListModule} from 'primeng/datalist';

import { EmpleadoIndexComponent} from './index/empleado-index.component';
import { EmpleadosRoutingModule } from './empleados-routing.module';
import { EmpleadoService } from '../services/empleado.service';

/**
 * Represents the Index module configuration
 *
 * @export
 * @class IndexModule
 */
@NgModule({
  imports: [
    CommonModule,
    EmpleadosRoutingModule,
    CarouselModule,
    DataListModule
  ],
  declarations: [EmpleadoIndexComponent],
  providers: [ EmpleadoService,],
})

export class EmpleadosModule {
}
