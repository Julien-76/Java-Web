import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Voiture } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class VoitureService {

  private BASE_URL = 'http://localhost:8080/DemoJavaEE/api'

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll(): Observable<Voiture[]> {
    return this.httpClient.get<Voiture[]>(this.BASE_URL);
  }

  getById(id): Observable<Voiture> {
    return this.httpClient.get<Voiture>(this.BASE_URL + '/' + id.id)
  }

}
