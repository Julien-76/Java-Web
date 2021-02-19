import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Voiture } from '../models/models';
import { VoitureService } from './voiture.service';

@Component({
  selector: 'app-voitures',
  templateUrl: './voitures.component.html',
  styleUrls: ['./voitures.component.scss']
})
export class VoituresComponent implements OnInit {
  voitures$: Observable<Voiture[]>;

  constructor(
    private voitureService: VoitureService
  ) { }

  ngOnInit(): void {
    this.voitures$ = this.voitureService.getAll();
  }

}
