import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import { FormsModule } from '@angular/forms';
import {CarouselModule} from 'primeng/carousel';
import { DataListModule } from 'primeng/datalist';

import { TipoDeduccionService } from '../services/tipo-deduccion.service';
import { TipoDeduccionIndexComponent } from './index/tipo-deduccion-index.component';
import { TipoDeduccionRoutingModule } from './tipo-deduccion-routing.module';
import { TipoDeduccionCreateComponent } from './create/tipo-deduccion-create.component';
import { TipoDeduccionUpdateComponent } from './update/tipo-deduccion-update.component';

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
    // EmpleadosRoutingModule,
    TipoDeduccionRoutingModule,
    CarouselModule,
    DataListModule
  ],
  declarations: [
    TipoDeduccionIndexComponent,
    TipoDeduccionCreateComponent,
    TipoDeduccionUpdateComponent,
    // EmpleadoIndexComponent,
    // EmpleadoCreateComponent,
    // EmpleadoUpdateComponent
  ],
  providers: [ TipoDeduccionService,],
})

export class TipoDeduccionModule {
}
