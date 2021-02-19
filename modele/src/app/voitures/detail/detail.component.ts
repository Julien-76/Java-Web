import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Voiture } from 'src/app/models/models';
import { VoitureService } from '../voiture.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

  voiture: Voiture;

  constructor(private activatedRoute: ActivatedRoute,
    private voitureService: VoitureService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(id => {
      this.voitureService.getById(id).subscribe(v => this.voiture = v);
    });
  }

}
