import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BriefService {
  // URLs for each microservice
  private briefsApiUrl = 'http://localhost:8080/briefs'; // Port for Brief service
  private learnersApiUrl = 'http://localhost:8082/api/users/learners'; // Port for User service
  private competenciesApiUrl = 'http://localhost:8083/skills'; // Port for Competency service

  constructor(private http: HttpClient) { }

  // Gets all briefs
  getBriefs(): Observable<any[]> {
    return this.http.get<any[]>(this.briefsApiUrl);
  }

  // Deletes a brief by ID
  deleteBrief(id: number): Observable<void> {
    return this.http.delete<void>(`${this.briefsApiUrl}/${id}`);
  }

  // Gets all learners for the assignment form
  getLearners(): Observable<any[]> {
    return this.http.get<any[]>(this.learnersApiUrl);
  }

  createBrief(briefData: any): Observable<any> {
    return this.http.post<any>(this.briefsApiUrl, briefData);
  }

  getCompetencies(): Observable<any[]> {
    return this.http.get<any[]>(this.competenciesApiUrl);
  }

   getBriefById(id: number): Observable<any> {
    return this.http.get<any>(`${this.briefsApiUrl}/${id}`);
  }

  updateBrief(id: number, briefData: any): Observable<any> {
    return this.http.put<any>(`${this.briefsApiUrl}/${id}`, briefData);
  }

   assignBrief(briefId: number, learnerId: number): Observable<any> {
    return this.http.post<any>(`${this.briefsApiUrl}/${briefId}/assign`, learnerId);
  }
}