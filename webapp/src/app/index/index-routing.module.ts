import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';

const AppRoutes: Routes = [
  {
    path: '',
    component: IndexComponent
  }
];

/**
 * Responsible of managing dashboard routing.
 *
 * @export
 * @class DashboardRoutingModule
 */
@NgModule({
  imports: [RouterModule.forChild(AppRoutes)],
  exports: [RouterModule]
})

export class IndexRoutingModule { }
