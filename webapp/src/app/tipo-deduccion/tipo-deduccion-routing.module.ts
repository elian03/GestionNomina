import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TipoDeduccionIndexComponent } from './index/tipo-deduccion-index.component';

const AppRoutes: Routes = [
  {
    path: '',
    component: TipoDeduccionIndexComponent
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
export class TipoDeduccionRoutingModule { }
