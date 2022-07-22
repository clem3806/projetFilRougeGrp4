import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formations } from '../interfaces/formations';

@Injectable({
  providedIn: 'root'
})
export class FormationsService {

  private url: string = "http://localhost:5555/formations";
  
  constructor(private http: HttpClient) { }

  getAllFormations(): Observable<any>{
    return this.http.get<Formations[]>(this.url);
  }
  getOneFormation(id: number) {
    return this.http.get<Formations>(this.url + "/" + id);
  }
  addFormation(f: Formations) {
    return this.http.post<Formations>(this.url, f);
  }
  deletFormation(id: number) {
    return this.http.delete(this.url + "/" + id);
  }
  updateFormation(f: Formations) {
    return this.http.put<Formations>(this.url + "/" + f.id, f);
  }
}
