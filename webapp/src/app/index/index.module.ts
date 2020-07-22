import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {CarouselModule} from 'primeng/carousel';
import {DataListModule} from 'primeng/datalist';

import {IndexComponent} from './index/index.component';
import { IndexRoutingModule } from './index-routing.module';

/**
 * Represents the Index module configuration
 *
 * @export
 * @class IndexModule
 */
@NgModule({
  imports: [
    CommonModule,
    IndexRoutingModule,
    CarouselModule,
    DataListModule
  ],
  declarations: [IndexComponent]
})

export class IndexModule {
}
