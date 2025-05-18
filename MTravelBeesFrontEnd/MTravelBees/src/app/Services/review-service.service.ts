import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Review } from '../Entities/review';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReviewServiceService {

  //private apiUrl = 'http://localhost:8090';
  //private apiUrl = 'http://gateway:8090';

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  getReviewsByTourId(tourId: number): Observable<Review[]> {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set('Authorization',tokenStr);
    
    return this.http.get<Review[]>(`${this.apiUrl}/reviews/getTourReviews/${tourId}`,{headers});
  }
  
  addReviewToTour(tourId: number, review: Review): Observable<any> {
    let tokenStr='Bearer '+localStorage.getItem('token');
    const headers=new HttpHeaders().set('Authorization',tokenStr);

    const url = `${this.apiUrl}/reviews/addReviewToTour/${tourId}`;
    return this.http.post<any>(url, review,{headers});
  }
}
