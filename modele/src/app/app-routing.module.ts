import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailComponent } from './voitures/detail/detail.component';
import { VoituresComponent } from './voitures/voitures.component';

const routes: Routes = [
  {
    path: '', component: VoituresComponent, children: [
      {
        path: 'detail/:id', component: DetailComponent
      }
    ]
  }, {
    path: 'voitures', component: VoituresComponent, children: [
      {
        path: 'detail/:id', component: DetailComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
