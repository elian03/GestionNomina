import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoIngresoIndexComponent } from './index/tipo-ingreso-index.component';

const AppRoutes: Routes = [
  {
    path: '',
    component: TipoIngresoIndexComponent
  }
];

/**
 * Responsible of managing dashboard routing.
 *
 * @export
 * @class EmpleadosRoutingModule
 */
@NgModule({
  imports: [RouterModule.forChild(AppRoutes)],
  exports: [RouterModule]
})
export class TipoIngresoRoutingModule { }
