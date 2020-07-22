import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
import { NgModule } from '@angular/core';
import { CreateComponent } from './product/create/create.component';
import { UpdateComponent } from './product/update/update.component';
import { EntryComponent } from './product/entry/entry.component';
import { OutputComponent } from './product/output/output.component';
import { IndexComponent } from './index/index/index.component';
import { TransferDetailComponent } from './transfer/transfer-detail/transfer-detail.component';
import { TransferListComponent } from './transfer/transfer-list/transfer-list.component';

export const AppRoutes: Routes = [
    {
        path: '',
        redirectTo: 'index',
        pathMatch: 'full',
    },
    {
        path: '',
        component: LayoutComponent,
        children: [
            {
                path: 'index', component: IndexComponent
            },
            {
                path: 'createProduct',
                component: CreateComponent
              },
              {
                path: 'updateProduct/:id',
                component: UpdateComponent
              },
             {
                path: 'entry',
                component: EntryComponent
              },
              {
                path: 'output',
                component: OutputComponent
              },
              {
                path: 'transfer-detail/:id',
                component: TransferDetailComponent
              },
              {
                path: 'transfers',
                component: TransferListComponent
              }
        ]
    }
];
/**
 * Manage the Main screens route configuration
 *
 * @export
 * @class AppRoutingModule
 */
@NgModule({
    imports: [RouterModule.forRoot(AppRoutes)],
    exports: [RouterModule]
})

export class AppRoutingModule {
}
