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
import { EmpleadoCreateComponent } from "./empleados/create/empleado-create.component";
import { EmpleadoUpdateComponent } from "./empleados/update/empleado-update.component";
import { TipoDeduccionIndexComponent } from "./tipo-deduccion/index/tipo-deduccion-index.component";
import { TipoDeduccionCreateComponent } from "./tipo-deduccion/create/tipo-deduccion-create.component";

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
      {
        path: "create",
        component: EmpleadoCreateComponent,
      },
      {
        path: "edit/:id",
        component: EmpleadoUpdateComponent,
      },
    ],
  },
  {
    path: "tipo-deduccion",
    component: LayoutComponent,
    children: [
      {
        path: "index",
        component: TipoDeduccionIndexComponent,
      },
      {
        path: "create",
        component: TipoDeduccionCreateComponent,
      },
      // {
      //   path: "edit/:id",
      //   component: EmpleadoUpdateComponent,
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
