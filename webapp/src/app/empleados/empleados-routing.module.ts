import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmpleadoIndexComponent } from './index/empleado-index.component';

const AppRoutes: Routes = [
  {
    path: '',
    component: EmpleadoIndexComponent
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
export class EmpleadosRoutingModule { }
