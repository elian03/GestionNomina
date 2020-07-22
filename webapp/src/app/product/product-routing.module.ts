import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { EntryComponent } from './entry/entry.component';
import { OutputComponent } from './output/output.component';


const AppRoutes: Routes = [
  {
    path: '',
    component: CreateComponent,
    children: [
      {
        path: '',
        component: CreateComponent
      },
      {
        path: 'updateProduct',
        component: UpdateComponent
      },
     {
        path: 'entry',
        component: EntryComponent
      },
      {
        path: 'output',
        component: OutputComponent
      }
    ]
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

export class ProductRoutingModule { }
