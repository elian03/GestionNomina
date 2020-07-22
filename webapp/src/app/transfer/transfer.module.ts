import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarouselModule} from 'primeng/carousel';
import {DataListModule} from 'primeng/datalist';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TransferDetailComponent } from './transfer-detail/transfer-detail.component';
import { TransferListComponent } from './transfer-list/transfer-list.component';

/**
 * Represents the Product module configuration
 *
 * @export
 * @class ProductModule
 */
@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [TransferDetailComponent, TransferListComponent]
})

export class TransferModule {
}
