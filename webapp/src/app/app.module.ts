import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { ToastrModule } from 'ngx-toastr';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LayoutComponent } from './layout/layout.component';
import { AppRoutingModule, AppRoutes } from './app-routing.module';
import { EmpleadosModule } from './empleados/empleados.module';
// import { IndexModule } from './index/index.module';
// import { ProductModule } from './product/product.module';
// import { ProductService } from './services/product.service';
// import { TransferModule } from './transfer/transfer.module';
// import { TransferService } from './services/transfer.service';


@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    // BrowserAnimationsModule,
    // ToastrModule.forRoot(),
    EmpleadosModule,
    // IndexModule,
    // ProductModule,
    // TransferModule,
    HttpClientModule
  ],
  providers: [ HttpClient,],
  bootstrap: [AppComponent]
})
export class AppModule { }
