import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarouselModule} from 'primeng/carousel';
import {DataListModule} from 'primeng/datalist';

import { ProductRoutingModule } from './product-routing.module';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { EntryComponent } from './entry/entry.component';
import { OutputComponent } from './output/output.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

/**
 * Represents the Product module configuration
 *
 * @export
 * @class ProductModule
 */
@NgModule({
  imports: [
    CommonModule,
    ProductRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [CreateComponent, UpdateComponent, EntryComponent, OutputComponent]
})

export class ProductModule {
}
