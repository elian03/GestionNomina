import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {CarouselModule} from 'primeng/carousel';
import { DataListModule } from 'primeng/datalist';

import { TipoIngresoService } from '../services/tipo-ingreso.service';
import { TipoIngresoIndexComponent } from './index/tipo-ingreso-index.component';
import { TipoIngresoRoutingModule } from './tipo-ingreso-routing.module';
import { TipoIngresoCreateComponent } from './create/tipo-ingreso-create.component';
import { TipoIngresoUpdateComponent } from './update/tipo-ingreso-update.component';

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
    TipoIngresoRoutingModule,
    CarouselModule,
    DataListModule
  ],
  declarations: [
    TipoIngresoIndexComponent,
    TipoIngresoCreateComponent,
    TipoIngresoUpdateComponent,
  ],
  providers: [ TipoIngresoService,],
})

export class TipoIngresoModule {
}
