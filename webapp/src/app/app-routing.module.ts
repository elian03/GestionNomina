import { RouterModule, Routes } from "@angular/router";
import { LayoutComponent } from "./layout/layout.component";
import { NgModule } from "@angular/core";
// import { CreateComponent } from "./product/create/create.component";
// import { UpdateComponent } from "./product/update/update.component";
// import { EntryComponent } from "./product/entry/entry.component";
// import { OutputComponent } from "./product/output/output.component";
// import { TransferDetailComponent } from "./transfer/transfer-detail/transfer-detail.component";
// import { TransferListComponent } from "./transfer/transfer-list/transfer-list.component";
import { EmpleadoIndexComponent } from "./empleados/index/empleado-index.component";

export const AppRoutes: Routes = [
  {
    path: "",
    redirectTo: "empleado/index",
    pathMatch: "full",
  },
  {
    path: "empleado",
    component: LayoutComponent,
    children: [
      {
        path: "index",
        component: EmpleadoIndexComponent,
      },
      // {
      //   path: "createProduct",
      //   component: CreateComponent,
      // },
      // {
      //   path: "updateProduct/:id",
      //   component: UpdateComponent,
      // },
      // {
      //   path: "entry",
      //   component: EntryComponent,
      // },
      // {
      //   path: "output",
      //   component: OutputComponent,
      // },
      // {
      //   path: "transfer-detail/:id",
      //   component: TransferDetailComponent,
      // },
      // {
      //   path: "transfers",
      //   component: TransferListComponent,
      // },
    ],
  },
];
/**
 * Manage the Main screens route configuration
 *
 * @export
 * @class AppRoutingModule
 */
@NgModule({
  imports: [RouterModule.forRoot(AppRoutes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
